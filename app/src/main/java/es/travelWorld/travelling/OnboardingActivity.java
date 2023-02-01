package es.travelWorld.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import es.travelWorld.travelling.databinding.ActivityOnboardingBinding;

public class OnboardingActivity extends AppCompatActivity {
    ActivityOnboardingBinding bindingOnboardingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingOnboardingActivity=ActivityOnboardingBinding.inflate(getLayoutInflater());
        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_onboarding));
        setContentView(bindingOnboardingActivity.getRoot());
        setListeners();
    }

    private void setListeners() {
        bindingOnboardingActivity.onboardButtonNext.setOnClickListener(view->actionPulseBtnHome());
    }
    private void actionPulseBtnHome() {
        startActivity(new Intent(this,HomeActivity.class));
    }
}