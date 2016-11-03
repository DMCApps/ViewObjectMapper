package com.github.dmcapps.viewobjectmapperexample.examples.fragementmap;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BasicMappingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BasicMappingFragment extends Fragment {
    private static final String TAG = BasicMappingFragment.class.getSimpleName();

    private TextView mTextView;
    private EditText mEditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;

    public BasicMappingFragment() {
        // Required empty public constructor
    }

    public static BasicMappingFragment newInstance() {
        return new BasicMappingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_mapping, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new ViewObjectMapper.Builder(this)
                .build().map();

        if (mTextView == null
                || mEditText == null
                || mRadioGroup == null
                || mRadioButton1 == null
                || mRadioButton2 == null) {
            throw new RuntimeException(TAG + ": Failed to map object");
        }
    }
}
