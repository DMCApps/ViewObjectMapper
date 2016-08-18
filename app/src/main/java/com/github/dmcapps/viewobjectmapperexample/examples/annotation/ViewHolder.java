package com.github.dmcapps.viewobjectmapperexample.examples.annotation;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewId;
import com.github.dmcapps.viewobjectmapperexample.R;

/**
 * Created by DCarmo on 16-08-17.
 */
public class ViewHolder {

    @ViewId(R.id.test_text_view)
    public TextView mTextView;
    @ViewId(R.id.test_edit_text)
    public EditText mEditText;
    @ViewId(R.id.test_radio_group)
    public RadioGroup mRadioGroup;
    @ViewId(R.id.test_radio_button_1)
    public RadioButton mRadioButton1;
    @ViewId(R.id.test_radio_button_2)
    public RadioButton mRadioButton2;

}
