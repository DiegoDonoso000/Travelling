package es.travelWorld.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

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

    }
}