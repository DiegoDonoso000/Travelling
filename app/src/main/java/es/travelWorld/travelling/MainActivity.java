package es.travelWorld.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import es.travelWorld.travelling.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    public static final String DESTINY="para enviar el destino";
    ActivityMainBinding bindingMainActivity;
    private String[] destinations;
    private String destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMainActivity= ActivityMainBinding.inflate(getLayoutInflater());
        Window window=getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_main));
        setContentView(bindingMainActivity.getRoot());
        setValues();
        setListeners();
        bindingMainActivity.homeButton.setEnabled(false);
        bindingMainActivity.newAccountButton.setEnabled(false);
    }

    private void setValues() {
        destinations= new String[]{"","Mendoza", "San Luis", "La Pampa"," Tarragona","Barcelona"};
        ArrayAdapter arrayList=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,destinations);
        bindingMainActivity.mainSpinner.setAdapter(null);
        bindingMainActivity.mainSpinner.setAdapter(arrayList);
    }

    private void setListeners() {
        bindingMainActivity.homeButton.setOnClickListener(view -> actionPulseBtn(HomeActivity.class));
        bindingMainActivity.loginButton.setOnClickListener(view -> actionPulseBtn(LoginActivity.class));
        bindingMainActivity.onboardingButton.setOnClickListener(view -> actionPulseBtn(OnboardingActivity.class));
        bindingMainActivity.newAccountButton.setOnClickListener(view -> actionPulseBtn(NewAccountActivity.class));
    }

    private void actionPulseBtn(Class cls) {
        Intent intent= new Intent(this,cls);
        intent.putExtra(DESTINY,destination);
        startActivity(intent);
    }


}