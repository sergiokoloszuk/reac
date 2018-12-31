package br.com.klz.reacnathuris.activities.Calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.klz.reacnathuris.R;
import br.com.klz.reacnathuris.activities.Calendar.AgendarAtendimentoActivity;
import br.com.klz.reacnathuris.activities.menus.MenuGeralActivity;

public class CalendarioActivity extends AppCompatActivity {

    private Button agendar;
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_calendario );

        initViews();

        agendar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAgendarAtendimento();
            }
        } );

        menu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuGeral();
            }
        } );
    }

    private void initViews() {
        agendar = findViewById( R.id.btn_agendar_paciente );
        menu = findViewById( R.id.btn_voltar_menu );
    }

    private void abrirAgendarAtendimento(){

        Intent intent = new Intent( getApplicationContext(),AgendarAtendimentoActivity.class );
        startActivity(intent);
        finish();
    }

    private void abrirMenuGeral(){

        Intent intent = new Intent( getApplicationContext(),MenuGeralActivity.class );
        startActivity(intent);
        finish();
    }
}
