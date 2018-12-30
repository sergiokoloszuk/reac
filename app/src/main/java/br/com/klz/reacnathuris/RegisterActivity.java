package br.com.klz.reacnathuris;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        btnRegister = findViewById( R.id.btn_register );

        btnRegister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLogin();
            }
        } );
    }

    private void abrirLogin(){

        Intent intent = new Intent( getApplicationContext(),LoginActivity.class );
        startActivity(intent);
        finish();
    }
}
