package es.travelWorld.travelling;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.google.android.material.snackbar.Snackbar;

import es.travelWorld.travelling.databinding.ActivityMainBinding;
import es.travelWorld.travelling.databinding.HomeBinding;
import es.travelWorld.travelling.databinding.LoginBinding;
import es.travelWorld.travelling.databinding.OnboardingBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bindingMainActivity;
    OnboardingBinding bindingOnboard;
    HomeBinding bindingHome;
    LoginBinding bindingLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMainActivity= ActivityMainBinding.inflate(getLayoutInflater());
        bindingOnboard=OnboardingBinding.inflate(getLayoutInflater());
        bindingHome= HomeBinding.inflate(getLayoutInflater());
        bindingLogin=LoginBinding.inflate(getLayoutInflater());

        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_onboarding));
        setContentView(bindingOnboard.getRoot());
        setOnboardingListeners();
    }

    private void setOnboardingListeners() {
        // escuchar el boton next de Onboarding
        bindingOnboard.onboardButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPulseBtnNextOnboarding();
            }
        });
    }
    private void actionPulseBtnNextOnboarding() {
        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_home));
        setContentView(bindingLogin.getRoot());
        setLoginListeners();
    }

    private void setLoginListeners() {
        // gestionar click en get new de
        bindingLogin.pwdForgotActionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,R.string.in_construction_text,Snackbar.LENGTH_LONG).show();
            }
        });
        bindingLogin.getAccountActionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,R.string.in_construction_text,Snackbar.LENGTH_LONG).show();
            }
        });
    }


}