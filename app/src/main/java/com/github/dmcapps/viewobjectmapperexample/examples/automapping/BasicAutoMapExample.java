package com.github.dmcapps.viewobjectmapperexample.examples.automapping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapper.core.annotations.NoViewMap;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class BasicAutoMapExample extends AppCompatActivity {
    private static final String TAG = BasicAutoMapExample.class.getSimpleName();

    // Note some of these are without the m prefix
    // The parser will remove the m prefix so that it doesn't
    // Need to be in the android:id xml field.
    private TextView mTextView;
    private EditText EditText;
    private RadioGroup mRadioGroup;
    private RadioButton RadioButton1;
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_auto_map_example);

        ViewObjectMapper.setUpResourceIdClass(R.id.class);
        ViewObjectMapper.enableAutoMap(true);
        Date startTime = new Date();
        ViewObjectMapper.mapObjectToView(this, findViewById(R.id.container));
        Date endTime = new Date();

        Log.d(TAG, String.format("Time to Map: %d", (endTime.getTime() - startTime.getTime())));
    }
}
