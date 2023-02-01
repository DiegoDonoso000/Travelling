package es.travelWorld.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.google.android.material.snackbar.Snackbar;
import es.travelWorld.travelling.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding bindingLoginActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window=this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_login));
        bindingLoginActivity= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bindingLoginActivity.getRoot());
        setListeners();
    }
    private void setListeners() {
        bindingLoginActivity.pwdForgotActionText.setOnClickListener(view -> showSnackContruction(view));
        bindingLoginActivity.getAccountActionText.setOnClickListener(view -> showSnackContruction(view));
    }

    private void showSnackContruction(View view) {
        Snackbar.make(view,R.string.in_construction_text,Snackbar.LENGTH_LONG).show();
    }
}