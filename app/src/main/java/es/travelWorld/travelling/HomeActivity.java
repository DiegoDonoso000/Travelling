package es.travelWorld.travelling;

import static es.travelWorld.travelling.Constants.KEY_MAIN_USER;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import es.travelWorld.travelling.databinding.ActivityHomeBinding;
import es.travelWorld.travelling.domain.Usuario;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding bindingHomeActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingHomeActivity= ActivityHomeBinding.inflate(getLayoutInflater());
        Window window = this.getWindow();
        window.setStatusBarColor(this.getColor(R.color.status_bar_home));
        setContentView(bindingHomeActivity.getRoot());
        getIntentExtras();
    }

    private void getIntentExtras() {
        if (getIntent().getExtras()!=null){
            Usuario usuario= getIntent().getExtras().getParcelable(KEY_MAIN_USER);
            String texto="tenemos usuario "+usuario.getNombre()+" "+usuario.getApellido();
            Log.e("Tokio",texto);
        }
       }


}