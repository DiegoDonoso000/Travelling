package es.travelWorld.travelling;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import es.travelWorld.travelling.databinding.ActivityNewAccountBinding;

public class NewAccountActivity extends AppCompatActivity {
    AppCompatImageView photo;
    ActivityNewAccountBinding bindingActivity;
    boolean errConditionFirstName,errConditionSurname,errConditionAge;
    private ActivityResultLauncher<Void> phothoBitmap= registerForActivityResult(new ActivityResultContracts.TakePicturePreview(), result -> {
        photo = findViewById(R.id.user_picture);
        if(result!=null){
            photo.setImageBitmap(result);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingActivity = ActivityNewAccountBinding.inflate(getLayoutInflater());
        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.background_new_account));
        setContentView(bindingActivity.getRoot());
        setValues();
        setListeners();
    }

    private void setListeners(){
        bindingActivity.toolbar.setNavigationOnClickListener(view -> Toast.makeText(NewAccountActivity.this,"Boton de navegación",Toast.LENGTH_LONG).show());
        bindingActivity.accountFirstName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().contains("@") || editable.toString().contains("!")){
                    bindingActivity.accountFirstnameLay.setError(getString(R.string.error_text_name));
                    errConditionFirstName=true;
                }
                else
                {   bindingActivity.accountFirstnameLay.setError(null);
                    errConditionFirstName=false ;
                }
                setButtonstatus();
            }
        });

        bindingActivity.accountSurname.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().contains("@") || editable.toString().contains("!")) {
                    bindingActivity.accountSurnameLay.setError(getString(R.string.error_text_name));
                    errConditionSurname=true;
                }
                else {
                    bindingActivity.accountSurnameLay.setError(null);
                    errConditionSurname=false;
                }
                setButtonstatus();
            }
        });

        bindingActivity.ageGroups.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("18-99") && !editable.toString().equals("")) {
                    bindingActivity.ageGroupsLayout.setError(getString(R.string.error_age));
                    errConditionAge=true;
                }
                else {
                    bindingActivity.ageGroupsLayout.setError(null);
                    errConditionAge= false;
                }
                setButtonstatus();
            }

        });

        bindingActivity.acceptButton.setOnClickListener(view -> { });

        bindingActivity.getAccountActionText.setOnClickListener(view -> openConditionsWeb("https://developers.google.com/ml-kit/terms"));

        bindingActivity.floatingCameraButton.setOnClickListener(this::openCamera);

    }

    private void openCamera(View view) {
        phothoBitmap.launch(null);
    }
    private void openConditionsWeb(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void setButtonstatus() {
        boolean btnEnabled=!(errConditionFirstName | errConditionSurname | errConditionAge
                | bindingActivity.accountFirstName.length()==0
                | bindingActivity.accountSurname.length()==0
                | bindingActivity.ageGroups.length()==0);
        bindingActivity.acceptButton.setEnabled(btnEnabled);
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




