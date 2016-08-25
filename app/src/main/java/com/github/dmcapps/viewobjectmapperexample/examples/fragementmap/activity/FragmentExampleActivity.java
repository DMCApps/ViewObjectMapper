package com.github.dmcapps.viewobjectmapperexample.examples.fragementmap.activity;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.dmcapps.viewobjectmapperexample.R;
import com.github.dmcapps.viewobjectmapperexample.examples.fragementmap.BasicMappingFragment;

public class FragmentExampleActivity extends AppCompatActivity {

    public static final String EXTRA_CLASS_NAME = "EXTRA_CLASS_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        String className = getIntent().getStringExtra(EXTRA_CLASS_NAME);

        Fragment fragment;
        try {
            Class<?> clazz = Class.forName(className);
            fragment = (Fragment)clazz.newInstance();
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
