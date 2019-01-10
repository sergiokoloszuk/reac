package br.com.klz.reacnathuris.activities.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.klz.reacnathuris.DAO.ConfigFirebase;
import br.com.klz.reacnathuris.R;
import br.com.klz.reacnathuris.activities.menus.MenuGeralActivity;
import br.com.klz.reacnathuris.model.User;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnRegister;
    private TextInputLayout email;
    private TextInputLayout senha;
    private FirebaseAuth autenticacao;
    private User user;
    public static String id;
    private ProgressBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        initViews();

        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getEditText().getText().toString().equals( "" ) && !senha.getEditText().getText().toString().equals( "" )){

                    user = new User();
                    user.setEmail( email.getEditText().getText().toString());
                    user.setSenha( senha.getEditText().getText().toString() );
                    validarLogin();

                    barra.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(LoginActivity.this,"Preencha seus dados",Toast.LENGTH_SHORT).show();

                    barra.setVisibility(View.GONE);
                }
            }
        } );


        btnRegister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirRegister();
            }
        } );

    }

    private void initViews() {
        btnLogin = findViewById( R.id.btn_goto_login );
        btnRegister = findViewById( R.id.btn_goto_register );
        email = findViewById( R.id.til_user_email_login );
        senha = findViewById( R.id.til_password_login );
        barra = findViewById( R.id.progressBar );
        barra.setVisibility( View.GONE );
    }

    private void abrirMenuGeral() {

        Intent intent = new Intent( getApplicationContext(), MenuGeralActivity.class );
        startActivity( intent );
        finish();
    }

    private void abrirRegister() {

        Intent intent = new Intent( getApplicationContext(), RegisterActivity.class );
        startActivity( intent );
        finish();
    }

    private void validarLogin() {
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword( user.getEmail(), user.getSenha() ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    abrirMenuGeral();
                    if (task.getResult() != null && task.getResult().getUser() != null) {
                        id = task.getResult().getUser().getUid();
                    }

                } else {
                    Toast.makeText( LoginActivity.this, "Deu errado", Toast.LENGTH_SHORT ).show();
                    barra.setVisibility( View.GONE );
                }

            }
        } );
    }
}
