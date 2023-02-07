package es.travelWorld.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import es.travelWorld.travelling.databinding.ActivityNewAccountBinding;

public class NewAccountActivity extends AppCompatActivity {
    ActivityNewAccountBinding bindingActivity;
    boolean errCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingActivity = ActivityNewAccountBinding.inflate(getLayoutInflater());
        Window window = this.getWindow();
//        window.setStatusBarColor(this.getColor(R.color.background_new_account));
        setContentView(bindingActivity.getRoot());
        setValues();
        setListeners();
    }

    private void setListeners(){

        bindingActivity.accountFirstName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().indexOf("@")>0 || editable.toString().indexOf("!")>0)
                    bindingActivity.accountFirstnameLay.setError(getString(R.string.error_text_name));
                else
                    bindingActivity.accountFirstnameLay.setError(null);
            }
        });
        bindingActivity.accountSurname.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().indexOf("@")>0 || editable.toString().indexOf("!")>0)
                    bindingActivity.accountSurnameLay.setError(getString(R.string.error_text_name));
                else
                    bindingActivity.accountSurnameLay.setError(null);
            }
        });
        bindingActivity.ageButton.setOnClickListener(view -> { });
        bindingActivity.ageGroups.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("18-99") && !editable.toString().equals(""))
                    bindingActivity.ageGroupsLayout.setError(getString(R.string.error_text_name));
                else
                    bindingActivity.ageGroupsLayout.setError(null);
            }

        });
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




