package es.travelWorld.travelling;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.WindowCompat;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Window;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private boolean isDetailExpand;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_onboarding));
        setContentView(R.layout.onboarding);
        //Referenciar boton
        MaterialButton btn = findViewById(R.id.onboard_button_next);
        //Referenciar ConstraintLayout
        constraintLayout= findViewById(R.id.onboarding_activity);
        // escuchar el boton
        btn.setOnClickListener(view -> actionPulseBtn());
    }
    private void actionPulseBtn() {
        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_home));
        setContentView(R.layout.login);
    }

}