package com.github.dmcapps.viewobjectmapper.core;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.github.dmcapps.viewobjectmapper.core.annotations.ViewIdPrefix;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewResourceId;
import com.github.dmcapps.viewobjectmapper.utils.ResourceUtils;
import com.github.dmcapps.viewobjectmapper.utils.ViewObjectMapperUtils;
import com.google.common.base.CaseFormat;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

import static android.R.id.list;
import static com.github.dmcapps.viewobjectmapper.utils.ViewObjectMapperUtils.getAndroidContentViewGroup;

/**
 * Created by DCarmo on 16-08-17.
 */
public class ViewObjectMapper {
    private static final String TAG = ViewObjectMapper.class.getSimpleName();

    // ==================
    // PROPERTIES
    // ==================

    private Context context;
    private Object object;
    private View view;
    private TextWatcher editTextTextWatcher;
    private View.OnClickListener buttonOnClickListener;
    private AdapterView.OnItemClickListener listItemClickListener;

    // ==================
    // CONSTRUCTORS
    // ==================

    public ViewObjectMapper() {}

    private ViewObjectMapper(Context context, Object object, View view, TextWatcher editTextTextWatcher, View.OnClickListener buttonOnClickListener, AdapterView.OnItemClickListener onItemClickListener) {
        this.context = context;
        this.object = object;
        this.view = view;
        this.buttonOnClickListener = buttonOnClickListener;
        this.editTextTextWatcher = editTextTextWatcher;
        this.listItemClickListener = onItemClickListener;
    }


    // ==================
    // PUBLIC
    // ==================

    public static class Builder {
        private Context context;
        private Object object;
        private View view;
        private TextWatcher editTextTextWatcher;
        private View.OnClickListener buttonOnClickListener;
        private AdapterView.OnItemClickListener listItemClickListener;

        public Builder(Activity activity) {
            this((Context)activity);
            this.object = activity;
            this.view = getAndroidContentViewGroup(activity);
        }

        public Builder(Fragment fragment) {
            this((Context)fragment.getActivity());

            ViewObjectMapperUtils.validateFragmentIsSetUp(fragment);

            Activity activity = fragment.getActivity();
            this.object = fragment;
            this.view = getAndroidContentViewGroup(activity);
        }

        public Builder(Context context, Object object, View view) {
            this(context);
            this.object = object;
            this.view = view;
        }

        private Builder(Context context) {
            this.context = context;
        }

        // TODO: Ability to add multiple objects
        public Builder setObjectToMap(Object object) {
            this.object = object;
            return this;
        }

        // TODO: Ability to add multiple views
        public Builder setViewToMap(View view) {
            this.view = view;
            return this;
        }

        public Builder setEditTextTextWatcher(TextWatcher textWatcher) {
            this.editTextTextWatcher = textWatcher;
            return this;
        }

        public Builder setButtonOnClickListener(View.OnClickListener onClickListener) {
            this.buttonOnClickListener = onClickListener;
            return this;
        }

        public Builder setListOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
            this.listItemClickListener = onItemClickListener;
            return this;
        }

        public ViewObjectMapper build() {
            validateRequiredValuesSet();

            return new ViewObjectMapper(
                    this.context,
                    this.object,
                    this.view,
                    this.editTextTextWatcher,
                    this.buttonOnClickListener,
                    this.listItemClickListener
            );
        }

        private void validateRequiredValuesSet() {
            if (context == null) {
                throw new RuntimeException("You must set a Context");
            }
            if (object == null) {
                throw new RuntimeException("You must set an Object to map the view ids to");
            }
            if (view == null) {
                throw new RuntimeException("You must provide a view that contains all the ids to map to the Object");
            }
        }
    }

    public void map() {
        ViewObjectMapperUtils.validateMapObjectToViewInputs(context, object, view);

        Class<?> clazz = object.getClass();
        while (clazz != null && !clazz.getName().startsWith("android")) {
            final Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (View.class.isAssignableFrom(field.getType())) {
                    ViewObjectMapperUtils.mapObjectToView(context, view, object, field);

                    if ((buttonOnClickListener != null && Button.class.isAssignableFrom(field.getType()))
                            || (editTextTextWatcher != null && EditText.class.isAssignableFrom(field.getType()))
                            || (listItemClickListener != null && ListView.class.isAssignableFrom(field.getType()))) {
                        field.setAccessible(true);
                        Object obj = null;
                        try {
                            obj = field.get(this.object);
                        } catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                        }

                        if (obj != null) {
                            if (buttonOnClickListener != null && obj instanceof Button) {
                                ((View)obj).setOnClickListener(buttonOnClickListener);
                            }
                            else if (editTextTextWatcher != null && obj instanceof EditText) {
                                ((EditText)obj).addTextChangedListener(editTextTextWatcher);
                            }
                            else if (listItemClickListener != null && obj instanceof ListView) {
                                ((ListView)obj).setOnItemClickListener(listItemClickListener);
                            }
                        }
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    // ==================
    // PRIVATE
    // ==================
}
