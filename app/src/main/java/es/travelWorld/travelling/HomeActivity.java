package es.travelWorld.travelling;

import static es.travelWorld.travelling.Constants.KEY_MAIN_USER;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import es.travelWorld.travelling.databinding.ActivityHomeBinding;
import es.travelWorld.travelling.domain.Usuario;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding bindingHomeActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingHomeActivity= ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(bindingHomeActivity.getRoot());
        getIntentExtras();
        setListeners();
    }
    private void setListeners() {
        bindingHomeActivity.toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_eurodisney:
                    openConditionsWeb("https://www.disneylandparis.com/");
                    break;
                case R.id.menu_car_rental:
                    inflateFragment();
            }
            return false;
        });

    }

    private void inflateFragment() {
        androidx.fragment.app.FragmentManager fragmentmanager= getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction= fragmentmanager.beginTransaction();
        LileFragment lilefragment= new LileFragment();
        transaction.add(R.id.fragment_container, lilefragment);
        transaction.commitAllowingStateLoss();
    }

    private void getIntentExtras() {
        if (getIntent().getExtras()!=null){
            Usuario usuario= getIntent().getExtras().getParcelable(KEY_MAIN_USER);
            String texto="tenemos usuario "+usuario.getNombre()+" "+usuario.getApellido();
            Log.e("Tokio",texto);
        }
       }
    private void openConditionsWeb(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }



}