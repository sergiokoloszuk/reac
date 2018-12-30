package br.com.klz.reacnathuris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        btnLogin = findViewById( R.id.btn_goto_login );
        btnRegister = findViewById( R.id.btn_goto_register );

        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuGeral();
            }
        } );

        btnRegister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirRegister();
            }
        } ) ;

    }

    private void abrirMenuGeral(){

        Intent intent = new Intent( getApplicationContext(),MenuGeralActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirRegister(){

        Intent intent = new Intent( getApplicationContext(),RegisterActivity.class );
        startActivity(intent);
        finish();
    }
}
