package com.github.dmcapps.viewobjectmapper.core;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.github.dmcapps.viewobjectmapper.core.annotations.ViewIdPrefix;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewResourceId;
import com.github.dmcapps.viewobjectmapper.utils.ResourceUtil;
import com.google.common.base.CaseFormat;

import java.lang.reflect.Field;
import java.util.Locale;

/**
 * Created by DCarmo on 16-08-17.
 */
public final class ViewObjectMapper {
    private static final String TAG = ViewObjectMapper.class.getSimpleName();

    // ==================
    // PROPERTIES
    // ==================

    // ==================
    // PUBLIC
    // ==================

    public static void mapObjectToView(Context context, Object object, View mainView) {
        if (context == null || object == null || mainView == null) {
            throw new RuntimeException("You must provide a context, object and view to ViewObjectMapper#mapObjectToView");
        }

        Class<?> clazz = object.getClass();
        while (clazz != null && !clazz.getName().startsWith("android")) {
            final Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (View.class.isAssignableFrom(field.getType())) {
                    mapObjectToView(context, mainView, object, field);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    // ==================
    // PRIVATE
    // ==================

    private static void mapObjectToView(Context context, View mainView, Object object, Field field) {
        int resId = resIdFromField(context, field);
        setViewWithResIdToObjectField(mainView, resId, object, field);
    }

    private static int resIdFromField(Context context, Field field) {
        int resId = Integer.MIN_VALUE;
        if (field.isAnnotationPresent(ViewResourceId.class)) {
            final ViewResourceId annotation = field.getAnnotation(ViewResourceId.class);
            resId = annotation.value();
        }

        if (resId == Integer.MIN_VALUE) {
            resId = resIdFromFieldName(context, field);
        }

        return resId;
    }

    private static int resIdFromFieldName(Context context, Field field) {
        String searchResName = resNameFromFieldName(field);
        int resId = ResourceUtil.getResId(context, searchResName, "id");

        if (resId == Integer.MIN_VALUE) {
            Log.e(TAG, "Unable to find view id for field '" + field.getName() + "' attempting to find R.id." + searchResName);
        }

        return resId;
    }

    private static String resNameFromFieldName(Field field) {
        String resIdPrefix = "";
        if (field.isAnnotationPresent(ViewIdPrefix.class)) {
            final ViewIdPrefix annotation = field.getAnnotation(ViewIdPrefix.class);
            resIdPrefix = annotation.value();
        }

        String fieldName = field.getName();
        String searchResName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
        // Check if the field name starts with m and trim it
        if (searchResName.startsWith("m_")) {
            searchResName = searchResName.substring(2);
        }

        searchResName = String.format(Locale.ENGLISH, "%s%s", resIdPrefix, searchResName);
        return searchResName;
    }

    private static void setViewWithResIdToObjectField(View mainView, int resId, Object object, Field field) {
        View foundView = mainView.findViewById(resId);

        if (foundView == null) {
            Log.e(TAG, "Unable to find view with resource id " + resId + ".");
        }
        else {
            try {
                field.setAccessible(true);
                field.set(object, foundView);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
