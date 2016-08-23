package com.github.dmcapps.viewobjectmapperexample.examples.automap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewIdPrefix;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class PrefixAutoMapExample extends AppCompatActivity {
    private static final String TAG = PrefixAutoMapExample.class.getSimpleName();

    @ViewIdPrefix("prefix_example_")
    private TextView mTextView;
    @ViewIdPrefix("prefix_example_")
    private EditText mEditText;
    @ViewIdPrefix("prefix_example_")
    private RadioGroup mRadioGroup;
    @ViewIdPrefix("prefix_example_")
    private RadioButton mRadioButton1;
    @ViewIdPrefix("prefix_example_")
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefix_auto_map_example);

        Date startTime = new Date();
        ViewObjectMapper.mapObjectToView(this, this, findViewById(R.id.automap_container));
        Date endTime = new Date();

        Log.i(TAG, "Time to map: " + (endTime.getTime() - startTime.getTime()));

        assert(mTextView == null
                || mEditText == null
                || mRadioGroup == null
                || mRadioButton1 == null
                || mRadioButton2 == null);
    }
}
