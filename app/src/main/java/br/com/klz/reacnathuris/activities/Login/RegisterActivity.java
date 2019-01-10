package br.com.klz.reacnathuris.activities.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import br.com.klz.reacnathuris.DAO.ConfigFirebase;
import br.com.klz.reacnathuris.R;
import br.com.klz.reacnathuris.activities.Login.LoginActivity;
import br.com.klz.reacnathuris.helper.Preferencias;
import br.com.klz.reacnathuris.model.User;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private TextInputLayout email;
    private TextInputLayout senha;
    private TextInputLayout confirme;
    private TextInputLayout unidade;
    private FirebaseAuth autenticacao;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        initViews();


        btnRegister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (senha.getEditText().getText().toString().equals( confirme.getEditText().getText().toString() )) {

                    user = new User();
                    user.setEmail( email.getEditText().getText().toString() );
                    user.setSenha( senha.getEditText().getText().toString() );
                    user.setUnidade( unidade.getEditText().getText().toString() );


                } else {
                    Toast.makeText( RegisterActivity.this, "As senhas precisam ser iguais", Toast.LENGTH_SHORT ).show();

                }

                cadastrarUsuario();

            }
        } );
    }
    private void initViews() {
        btnRegister = findViewById( R.id.btn_register );
        email = findViewById( R.id.textinput_user_email );
        senha = findViewById( R.id.textinput_password_login );
        confirme = findViewById( R.id.textinput_confirm_password );
        unidade = findViewById( R.id.textinput_register_unidade );
    }


    private void abrirLogin() {

        Intent intent = new Intent( getApplicationContext(), LoginActivity.class );
        startActivity( intent );
        finish();
    }

    public void cadastrarUsuario() {

        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getSenha()
        ).addOnCompleteListener( RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText( RegisterActivity.this, "Usuario cadastrado com sucesso", Toast.LENGTH_SHORT ).show();
                    //String identificadorUser = Base64Custom.codificarBase64( user.getEmail() );
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    user.setId( usuarioFirebase.getUid() );
                    user.salvar();

                    Preferencias preferencias = new Preferencias( RegisterActivity.this );
                    preferencias.salvarPreferenciasUsuarios( user.getId(), user.getEmail() );

                    abrirLogin();


                } else {
                    String erroException = "";

                    try {

                        throw task.getException();

                    } catch (FirebaseAuthWeakPasswordException e) {
                        erroException = "Senha muito fraca";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroException = "O e-mail digitado é inválido";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erroException = "E-mail já cadastrado";
                    } catch (Exception e) {
                        erroException = "Erro ao efetuar o cadastro";
                        e.printStackTrace();
                    }
                    Toast.makeText( RegisterActivity.this, "Erro" + erroException, Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
}
