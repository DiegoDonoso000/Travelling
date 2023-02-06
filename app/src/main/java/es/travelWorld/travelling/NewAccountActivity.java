package es.travelWorld.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import es.travelWorld.travelling.databinding.ActivityNewAccountBinding;

public class NewAccountActivity extends AppCompatActivity {
    ActivityNewAccountBinding bindingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingActivity = ActivityNewAccountBinding.inflate(getLayoutInflater());
        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.background_new_account));
        setContentView(bindingActivity.getRoot());
        setValues();
    }

    private void setValues() {
        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView textView = (AutoCompleteTextView) bindingActivity.ageGroups;
        // Get the string array
        String[] ageGroups = getResources().getStringArray(R.array.age_groups_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ageGroups);
        textView.setAdapter(adapter);
    }

}




