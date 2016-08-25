package com.github.dmcapps.viewobjectmapperexample.examples.automap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

// TODO: Runtime check layout for mappings
// TODO: Add prefix to annotation to have a custom prefix on all values
public class BasicAutoMapExample extends AppCompatActivity {
    private static final String TAG = BasicAutoMapExample.class.getSimpleName();

    private TextView mTextView;
    private EditText mEditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_auto_map_example);

        ViewObjectMapper.mapObjectToView(this, this, findViewById(R.id.automap_container));

        if (mTextView == null
                || mEditText == null
                || mRadioGroup == null
                || mRadioButton1 == null
                || mRadioButton2 == null) {
            throw new RuntimeException(TAG + ": Failed to map object");
        }
    }
}
