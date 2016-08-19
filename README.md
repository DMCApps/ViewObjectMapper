#View Object Mapper

## Author

Daniel Carmo, dcarmo@alumni.uoguelph.ca

##Adding the library to your android studio project

In your app build.gradle file add the following to your dependencies. Project only available on jCenter repository.

```groovy
compile 'com.github.dmcapps:view-object-mapper:0.0.2'
```

##Current Version

0.0.2

##Introduction

This library allows you to map models to UI elements with ease! No more findViewById and casting to get your layout linked with your local files.

Simple add the `@ViewMapped` annotation to your property, and match the id from the XML (using underscores eg `android:id="@+id/button_hello"`) to the name of the property (using camel casing `eg Button mButtonHello`). Call the `ViewObjectMapper.mapObjectToView(Object, View)` in the method of your choosing after you've created the view and you're done. See the full examples below and in the project.

###Example

In your Activity, Fragment, etc. you add your properties that you would like mapped. 

``` java
import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewMapped;

public class BasicAutoMapExample extends AppCompatActivity {
    private static final String TAG = BasicAutoMapExample.class.getSimpleName();

    // Note some of these are without the m prefix
    // The parser will remove the m prefix so that it doesn't
    // Need to be in the android:id xml field.
    @ViewMapped
    TextView mTextView;
    @ViewMapped
    EditText EditText;
    @ViewMapped
    RadioGroup mRadioGroup;
    @ViewMapped
    RadioButton RadioButton1;
    @ViewMapped
    RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_auto_map_example);

        ViewObjectMapper.mapObjectToView(this, this, findViewById(R.id.automap_container));
    }
}
```

The above class links to the following layout `activity_basic_auto_map_example.xml` below. NOTE: The names of the XML are the same as the variables but using underscores instead of camel casing.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/automap_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="vertical"
    tools:context=".examples.automap.BasicAutoMapExample">

    <TextView
        android:id="@+id/text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Text View Example" />

    <EditText
        android:id="@+id/edit_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <RadioGroup
        android:id="@+id/radio_group"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/radio_button1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radio 1" />

        <RadioButton
            android:id="@+id/radio_button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radio 2" />

    </RadioGroup>

</LinearLayout>
```

Have a prefix that you like to add to all your xml files? If so you can take advantage of the `resIdPrefix` on the `ViewMapped` annotation. Below is an example of that in action!

```java
... 

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewMapped;

public class PrefixAutoMapExample extends AppCompatActivity {
    private static final String TAG = PrefixAutoMapExample.class.getSimpleName();

    @ViewMapped(resIdPrefix = "prefix_example_")
    TextView mTextView;
    @ViewMapped(resIdPrefix = "prefix_example_")
    EditText mEditText;
    @ViewMapped(resIdPrefix = "prefix_example_")
    RadioGroup mRadioGroup;
    @ViewMapped(resIdPrefix = "prefix_example_")
    RadioButton mRadioButton1;
    @ViewMapped(resIdPrefix = "prefix_example_")
    RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefix_auto_map_example);
        
        ViewObjectMapper.mapObjectToView(this, this, findViewById(R.id.automap_container));
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/automap_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="vertical"
    tools:context=".examples.automap.PrefixAutoMapExample">

    <TextView
        android:id="@+id/prefix_example_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Text View Example" />

    <EditText
        android:id="@+id/prefix_example_edit_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <RadioGroup
        android:id="@+id/prefix_example_radio_group"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/prefix_example_radio_button1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radio 1" />

        <RadioButton
            android:id="@+id/prefix_example_radio_button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radio 2" />

    </RadioGroup>

</LinearLayout>
```

##Change Log

###0.0.2
- Removed the requirement for the one time set up.
- Now pass in a context to `mapObjectToView(Context, Object, View)` and you are done!

###0.0.1
- Initial Launch
- Maps views to models using annotations.
- Requires users to do a one time set up.

In Android Studio Terminal use:
```
./gradlew install

./gradlew bintrayUpload
```

#License

Copyright (c) 2016 DMCApps [MIT License](https://opensource.org/licenses/MIT)
