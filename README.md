#View Object Mapper

## Author

Daniel Carmo, dcarmo@alumni.uoguelph.ca

##Adding the library to your android studio project

In your app build.gradle file add the following to your dependencies. Project only available on jCenter repository.

```groovy
compile 'com.github.dmcapps:view-object-mapper:0.1.0'
```

##Current Version

0.1.0

##Introduction

This library allows you to map models to UI elements with ease! No more findViewById and casting to get your layout linked with your local files.

Simplely match the id from the XML (using underscores eg `android:id="@+id/button_hello"`) to the name of the property (using camel casing `eg Button mButtonHello`). Call the `ViewObjectMapper.mapObjectToView(Activity or Fragment)` in the method of your choosing after you've created the view and you're done. See the full examples below and in the project.

###Example

In your Activity, Fragment, etc. you add your properties that you would like mapped. 

``` java
import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;

public class BasicAutoMapExample extends AppCompatActivity {
    private static final String TAG = BasicAutoMapExample.class.getSimpleName();

    // Note some of these are without the m prefix
    // The parser will remove the m prefix so that it doesn't
    // Need to be in the android:id xml field.
    // this maps to text_view
    TextView mTextView;
    // this maps to edit_text
    EditText EditText;
    // this maps to radio_group
    RadioGroup mRadioGroup;
    // this maps to radio_button1
    RadioButton RadioButton1;
    // this maps to radio_button2
    RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_auto_map_example);

        ViewObjectMapper.mapObjectToView(this);
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

    <!-- This maps to mTextView OR textView -->
    <TextView
        android:id="@+id/text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Text View Example" />

    <!-- This maps to mEditText OR editText -->
    <EditText
        android:id="@+id/edit_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <!-- This maps to mRadioGroup OR radioGroup -->
    <RadioGroup
        android:id="@+id/radio_group"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <!-- This maps to mRadioButton1 OR radioButton1 -->
        <RadioButton
            android:id="@+id/radio_button1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radio 1" />

        <!-- This maps to mRadioButton2 OR radioButton2 -->
        <RadioButton
            android:id="@+id/radio_button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Radio 2" />

    </RadioGroup>

</LinearLayout>
```

Have a prefix that you like to add to all your xml ids? If so you can take advantage of the `ViewIdPrefix`annotation. Below is an example of that in action!

```java
... 

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewResourceId;

public class PrefixAutoMapExample extends AppCompatActivity {
    private static final String TAG = PrefixAutoMapExample.class.getSimpleName();

    // this maps to prefix_example_text_view
    @ViewIdPrefix("prefix_example_")
    TextView mTextView;
    // this maps to prefix_example_edit_text
    @ViewIdPrefix("prefix_example_")
    EditText mEditText;
    // this maps to prefix_example_radio_group
    @ViewIdPrefix("prefix_example_")
    RadioGroup mRadioGroup;
    // this maps to prefix_example_radio_button1
    @ViewIdPrefix("prefix_example_")
    RadioButton mRadioButton1;
    // this maps to prefix_example_radio_button2
    @ViewIdPrefix("prefix_example_")
    RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefix_auto_map_example);
        
        ViewObjectMapper.mapObjectToView(this);
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

###0.1.0
- Added in helper methods to map directly to fragment or activity.
- Removed the requirement to pass in the main view.
- Added in support for fragments.
- Added in additional test cases for override methods

###0.0.4
- Made ViewIdPrefix annotation available at runtime and limited to fields
- Refactoring to `ViewObjectMapper` class

###0.0.3
- Removed the `ViewMapped` annotation.
- ViewObjectMapper is now smart enough to make the mapping for you based off the name of the view!
- Can now use the `ViewResourceId` annotation to give a view id directly
- Can now use the `ViewIdPrefix` annotation to add a prefix to the objects converted name
- Updated all examples to reflect the changes above

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
