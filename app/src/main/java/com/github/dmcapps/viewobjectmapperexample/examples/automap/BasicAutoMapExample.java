package com.github.dmcapps.viewobjectmapperexample.examples.automap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

// TODO: Runtime check layout for mappings
// TODO: Add prefix to annotation to have a custom prefix on all values
public class BasicAutoMapExample extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    private static final String TAG = BasicAutoMapExample.class.getSimpleName();

    private TextView mTextView;
    private EditText mEditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private Button mButtonClickable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_auto_map_example);

        new ViewObjectMapper.Builder(this)
                .setObjectToMap(this)
                .setViewToMap(findViewById(R.id.automap_container))
                .setButtonOnClickListener(this)
                .setEditTextTextWatcher(this)
                .build()
                .map();

        if (mTextView == null
                || mEditText == null
                || mRadioGroup == null
                || mRadioButton1 == null
                || mRadioButton2 == null) {
            throw new RuntimeException(TAG + ": Failed to map object");
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.i(TAG, "EditText.beforeTextChanged fired");
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i(TAG, "EditText.onTextChanged fired");
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.i(TAG, "EditText.afterTextChanged fired");
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "Button.onClick!");
    }
}
