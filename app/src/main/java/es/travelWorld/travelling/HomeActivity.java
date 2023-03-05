package es.travelWorld.travelling;

import static es.travelWorld.travelling.Constants.KEY_MAIN_USER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import es.travelWorld.travelling.databinding.ActivityHomeBinding;
import es.travelWorld.travelling.domain.Usuario;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding bindingHomeActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingHomeActivity= ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(bindingHomeActivity.getRoot());
        getIntentExtras(bindingHomeActivity.getRoot());
        setListeners();
    }

    private void setListeners() {
        bindingHomeActivity.toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_eurodisney:
                    openConditionsWeb("https://www.disneylandparis.com/");
                    break;
                case R.id.menu_face:
                    inflateFragment(new BlueFragment() );
                    break;
                case R.id.menu_car_rental:
                    inflateFragment(new LileFragment());
            }
            return false;
        });
    }

    private void inflateFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(bindingHomeActivity.fragmentContainer.getId(),fragment)
                .commitAllowingStateLoss();

    }

    private void getIntentExtras(View view) {
        if (getIntent().getExtras()!=null){
            Usuario usuario= getIntent().getExtras().getParcelable(KEY_MAIN_USER);
            String texto=getText(R.string.login_data_prefix)+usuario.getNombre()+" "+usuario.getApellido();
            Snackbar loginData = Snackbar.make(view,texto, Snackbar.LENGTH_LONG);
            loginData.show();
        }
       }

    private void openConditionsWeb(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}