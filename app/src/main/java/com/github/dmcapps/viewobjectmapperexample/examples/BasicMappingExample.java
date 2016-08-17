package com.github.dmcapps.viewobjectmapperexample.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewId;
import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

public class BasicMappingExample extends AppCompatActivity {

    @ViewId(R.id.test_text_view)
    private TextView mTextView;
    @ViewId(R.id.test_edit_text)
    private EditText mEditText;
    @ViewId(R.id.test_radio_group)
    private RadioGroup mRadioGroup;
    @ViewId(R.id.test_radio_button_1)
    private RadioButton mRadioButton1;
    @ViewId(R.id.test_radio_button_2)
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_mapping_example);

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        ViewObjectMapper.mapObjectToView(this, viewGroup);


    }
}
