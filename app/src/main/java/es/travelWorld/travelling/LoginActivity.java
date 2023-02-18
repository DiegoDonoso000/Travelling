package es.travelWorld.travelling;

import static es.travelWorld.travelling.Constants.KEY_MAIN_USER;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;
import es.travelWorld.travelling.databinding.ActivityLoginBinding;
import es.travelWorld.travelling.domain.Usuario;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding bindingLoginActivity;
    Usuario userFromServer;
    private ActivityResultLauncher<Intent> resultActivity=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode()== Activity.RESULT_OK){
            if(result.getData()!=null && result.getData().getExtras()!=null){
                userFromServer=result.getData().getExtras().getParcelable(KEY_MAIN_USER);
                Log.e("Tokio",userFromServer.getApellido());
            }
        }else if (result.getResultCode()== Activity.RESULT_CANCELED) {
            Log.e("Tokio","NO VINO NADA");
        }
        bindingLoginActivity.loginUsuari.setText(null);
        bindingLoginActivity.loginPassword.setText(null);
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingLoginActivity= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bindingLoginActivity.getRoot());
        setListeners();
    }

    private void setListeners() {
        bindingLoginActivity.pwdForgotActionText.setOnClickListener(view -> showSnackContruction(view));
        bindingLoginActivity.getAccountActionText.setOnClickListener(view -> actionNewAccountBtn(NewAccountActivity.class));
        bindingLoginActivity.loginButton.setOnClickListener(view -> actionLoginBtn(view));
        bindingLoginActivity.loginUsuari.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                  setButtonstatus();
            }
        });
        bindingLoginActivity.loginPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                setButtonstatus();
            }
        });
    }

    private void setButtonstatus() {
        boolean btnEnabled=!(bindingLoginActivity.loginUsuari.length()==0| bindingLoginActivity.loginPassword.length()==0);
        bindingLoginActivity.loginButton.setEnabled(btnEnabled);
    }

    private void actionLoginBtn(View view) {
        Usuario userLogin=provideFromLayout();
//        Intent intent = new Intent(this, HomeActivity.class).putExtra(KEY_MAIN_USER, userLogin);
//        startActivity(intent);
        if(userLogin!=null && userFromServer!=null && comparaUsuarios(userLogin,userFromServer)) {
            Intent intent = new Intent(this, HomeActivity.class).putExtra(KEY_MAIN_USER, userLogin);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
        }
    }

    private void actionNewAccountBtn(Class cls) {
        Intent intent= new Intent(this,cls);
        resultActivity.launch(intent);
    }

    private void showSnackContruction(View view) {
        Snackbar.make(view,R.string.in_construction_text,Snackbar.LENGTH_LONG).show();
    }

    private Usuario provideFromLayout(){
        Usuario user= new Usuario();
        user.setNombre(bindingLoginActivity.loginUsuari.getText().toString());
        user.setApellido(bindingLoginActivity.loginPassword.getText().toString());
        return user;
    }

    private boolean comparaUsuarios(Usuario user1,Usuario user2){
        return (Objects.equals(user1.getApellido(), user2.getApellido()) && (Objects.equals(user1.getNombre(), user2.getNombre())));
    }

}