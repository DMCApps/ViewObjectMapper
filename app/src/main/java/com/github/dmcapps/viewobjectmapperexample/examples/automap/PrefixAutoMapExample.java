package com.github.dmcapps.viewobjectmapperexample.examples.automap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewMapped;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class PrefixAutoMapExample extends AppCompatActivity {
    private static final String TAG = PrefixAutoMapExample.class.getSimpleName();

    @ViewMapped(resIdPrefix = "prefix_example_")
    private TextView mTextView;
    @ViewMapped(resIdPrefix = "prefix_example_")
    private EditText mEditText;
    @ViewMapped(resIdPrefix = "prefix_example_")
    private RadioGroup mRadioGroup;
    @ViewMapped(resIdPrefix = "prefix_example_")
    private RadioButton mRadioButton1;
    @ViewMapped(resIdPrefix = "prefix_example_")
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefix_auto_map_example);

        ViewObjectMapper.setUpResourceIdClass(R.id.class);
        ViewObjectMapper.mapObjectToView(this, findViewById(R.id.automap_container));
    }
}
