package com.github.dmcapps.viewobjectmapper.utils;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by DCarmo on 16-08-17.
 */
public class ResourceUtil {
    private static final String TAG = ResourceUtil.class.getSimpleName();

    public static int getResId(Context context, String strResId, String defType) {
        try {
            String packageName = context.getPackageName();
            int resId = context.getResources().getIdentifier(strResId, defType, packageName);
            return resId;
        }
        catch (Exception ex) {
            Log.e(TAG, "Unable to find resource of name " + strResId + " in package " + context.getPackageName());
            return Integer.MIN_VALUE;
        }
    }

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
