package com.github.dmcapps.viewobjectmapperexample.examples.annotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.annotations.ViewMapped;
import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class BasicMappingExample extends AppCompatActivity {
    private static final String TAG = BasicMappingExample.class.getSimpleName();

    @ViewMapped(R.id.test_text_view)
    private TextView mTextView;
    @ViewMapped(R.id.test_edit_text)
    private EditText mEditText;
    @ViewMapped(R.id.test_radio_group)
    private RadioGroup mRadioGroup;
    @ViewMapped(R.id.test_radio_button_1)
    private RadioButton mRadioButton1;
    @ViewMapped(R.id.test_radio_button_2)
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_mapping_example);

        Date startTime = new Date();
        ViewObjectMapper.mapObjectToView(this, findViewById(R.id.container));
        Date endTime = new Date();

        Log.d(TAG, String.format("Time to Map: %d", (endTime.getTime() - startTime.getTime())));
    }
}
