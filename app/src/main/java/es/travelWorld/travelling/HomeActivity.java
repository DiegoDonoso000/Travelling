package es.travelWorld.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import es.travelWorld.travelling.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding bindingHomeActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingHomeActivity= ActivityHomeBinding.inflate(getLayoutInflater());
        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_home));
        setContentView(bindingHomeActivity.getRoot());
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        bindingHomeActivity.textoEntrada.setText(intent.getStringExtra(MainActivity.DESTINY));
    }
}