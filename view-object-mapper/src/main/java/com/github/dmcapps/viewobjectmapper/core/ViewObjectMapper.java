package com.github.dmcapps.viewobjectmapper.core;

import android.view.View;

import com.github.dmcapps.viewobjectmapper.utils.ResourceUtil;

import java.lang.reflect.Field;

/**
 * Created by DCarmo on 16-08-17.
 */
public final class ViewObjectMapper {

    private static Class<?> mIdClass;

    /***
     * One time set up so that we have access to your local projects generated R.id class.
     * The idClass is the R.id.class so that we have an instance of your local generated
     * class to look for the id in.
     *
     * @param
     *      idClass -> The R.id.class for your local project.
     */
    public static void mapperIdClass(Class<?> idClass) {
        mIdClass = idClass;
    }

    public static void mapObjectToView(Object object, View view) {
        Class<?> clazz = object.getClass();
        while (clazz != null && !clazz.getName().startsWith("android")) {
            final Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ViewId.class)) {
                    final ViewId annotation = field.getAnnotation(ViewId.class);
                    String viewId = annotation.value();
                    int resId = ResourceUtil.getResId(viewId, mIdClass);

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
