package com.github.dmcapps.viewobjectmapperexample.examples.automap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewMapped;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

// TODO: Runtime check layout for mappings
// TODO: Add prefix to annotation to have a custom prefix on all values
public class BasicAutoMapExample extends AppCompatActivity {
    private static final String TAG = BasicAutoMapExample.class.getSimpleName();

    // Note some of these are without the m prefix
    // The parser will remove the m prefix so that it doesn't
    // Need to be in the android:id xml field.
    @ViewMapped
    private TextView mTextView;
    @ViewMapped
    private EditText mEditText;
    @ViewMapped
    private RadioGroup mRadioGroup;
    @ViewMapped
    private RadioButton mRadioButton1;
    @ViewMapped
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_auto_map_example);

        ViewObjectMapper.mapObjectToView(this, this, findViewById(R.id.automap_container));
    }
}