package com.github.dmcapps.viewobjectmapperexample.examples.resIdMap;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.annotations.ViewResourceId;
import com.github.dmcapps.viewobjectmapperexample.R;

/**
 * Created by DCarmo on 16-08-17.
 */
public class ViewHolder {

    @ViewResourceId(R.id.test_text_view)
    public TextView mTextView;
    @ViewResourceId(R.id.test_edit_text)
    public EditText mEditText;
    @ViewResourceId(R.id.test_radio_group)
    public RadioGroup mRadioGroup;
    @ViewResourceId(R.id.test_radio_button_1)
    public RadioButton mRadioButton1;
    @ViewResourceId(R.id.test_radio_button_2)
    public RadioButton mRadioButton2;

}
