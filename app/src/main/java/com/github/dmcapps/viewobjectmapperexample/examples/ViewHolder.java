package com.github.dmcapps.viewobjectmapperexample.examples;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewId;

/**
 * Created by DCarmo on 16-08-17.
 */
public class ViewHolder {

    @ViewId("test_text_view")
    public TextView textView;
    @ViewId("test_edit_text")
    public EditText editText;
    @ViewId("test_radio_group")
    public RadioGroup radioGroup;
    @ViewId("test_radio_button_1")
    public RadioButton radioButton1;
    @ViewId("test_radio_button_2")
    public RadioButton radioButton2;

}
