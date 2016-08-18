package com.github.dmcapps.viewobjectmapper.utils;

import java.lang.reflect.Field;

/**
 * Created by DCarmo on 16-08-17.
 */
public class ResourceUtil {

    /**
     * Returns a resource id for the given string name.
     *
     * @param
     * 		resName -> name of the resource to find
     * @param
     * 		resClass -> resource class to look for the id in. (ie R.drawable.class, R.string.class, etc.)
     * @return
     * 		The resource Id or {@link Integer#MIN_VALUE} if not found
     */
    public static int getResId(String resName, Class<?> resClass) {
        try {
            Field idField = resClass.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }
    }
}
