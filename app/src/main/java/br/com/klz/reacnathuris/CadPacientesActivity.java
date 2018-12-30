package br.com.klz.reacnathuris;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadPacientesActivity extends AppCompatActivity {

    private Button complemento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cad_pacientes );

        initViews();

        complemento.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrirComplemento();

            }
        } );
    }

    private void initViews() {
        complemento = findViewById( R.id.btn_complemento );
    }

    private void abrirComplemento(){

        Intent intent = new Intent( getApplicationContext(),CadComplementoPacientesActivity.class );
        startActivity(intent);
        finish();
    }
}
