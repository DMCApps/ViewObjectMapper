package com.github.dmcapps.viewobjectmapper.core;

import android.view.View;

import com.github.dmcapps.viewobjectmapper.utils.ResourceUtil;

import java.lang.reflect.Field;

/**
 * Created by DCarmo on 16-08-17.
 */
public final class ViewObjectMapper {

    public static void mapObjectToView(Object object, View view) {
        Class<?> clazz = object.getClass();
        while (clazz != null && !clazz.getName().startsWith("android")) {
            final Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ViewId.class)) {
                    final ViewId annotation = field.getAnnotation(ViewId.class);
                    int resId = annotation.value();

                    View foundView = view.findViewById(resId);

                    try {
                        field.setAccessible(true);
                        field.set(object, foundView);
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
    }
}
