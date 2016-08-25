package com.github.dmcapps.viewobjectmapperexample.examples.helpermethodsmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;
import com.github.dmcapps.viewobjectmapperexample.examples.resIdMap.ViewHolderUsingResourceId;

import java.util.Date;

public class ObjectHelperMapExample extends AppCompatActivity {
    private static final String TAG = ObjectHelperMapExample.class.getSimpleName();

    ViewHolderUsingNames mViewHolder = new ViewHolderUsingNames();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_helper_map_example);

        ViewObjectMapper.mapObjectToView(this, mViewHolder);

        if (mViewHolder.mTextView == null
                || mViewHolder.mEditText == null
                || mViewHolder.mRadioGroup == null
                || mViewHolder.mRadioButton1 == null
                || mViewHolder.mRadioButton2 == null) {
            throw new RuntimeException(TAG + ": Failed to map object");
        }
    }
}
