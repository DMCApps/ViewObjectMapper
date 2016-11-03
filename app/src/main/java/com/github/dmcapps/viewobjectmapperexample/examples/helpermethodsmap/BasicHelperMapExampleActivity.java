package com.github.dmcapps.viewobjectmapperexample.examples.helpermethodsmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class BasicHelperMapExampleActivity extends AppCompatActivity {
    private static final String TAG = BasicHelperMapExampleActivity.class.getSimpleName();

    private TextView mTextView;
    private EditText mEditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_helper_map_example);

        new ViewObjectMapper.Builder(this)
                .build().map();

        if (mTextView == null
                || mEditText == null
                || mRadioGroup == null
                || mRadioButton1 == null
                || mRadioButton2 == null) {
            throw new RuntimeException(TAG + ": Failed to map object");
        }
    }
}
