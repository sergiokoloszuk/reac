package br.com.klz.reacnathuris.activities.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.klz.reacnathuris.R;
import br.com.klz.reacnathuris.activities.perguntas.PerguntasAutismoActivity;
import br.com.klz.reacnathuris.activities.perguntas.PerguntasDepressaoActivity;
import br.com.klz.reacnathuris.activities.perguntas.PerguntasDorActivity;
import br.com.klz.reacnathuris.activities.perguntas.PerguntasOutrosActivity;
import br.com.klz.reacnathuris.activities.perguntas.PerguntasPanicoActivity;

public class MenuAnamneseActivity extends AppCompatActivity {

    private Button depressao;
    private Button panico;
    private Button autismo;
    private Button dor;
    private Button outros;
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu_anamnese );

        initViews();

        menu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuGeral();
            }
        } );
        depressao.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) { abrirPerguntasDepressao(); }} );
        panico.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {abrirPerguntasPanico();

            }
        } );
        autismo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {abrirPerguntasAutismo();

            }
        } );
        dor.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {abrirPerguntasDor();

            }
        } );
        outros.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {abrirPerguntasOutros();

            }
        } );



    }

    private void initViews() {
        depressao = findViewById( R.id.btn_anamnese_depressão );
        panico = findViewById( R.id.btn_anamnese_panico );
        autismo = findViewById( R.id.btn_anamnese_autismo );
        dor = findViewById( R.id.btn_anamnese_dor_cronica );
        outros = findViewById( R.id.btn_anamnese_outros );
        menu = findViewById( R.id.btn_anamnese_voltar_menu );
    }

    private void abrirMenuGeral(){

        Intent intent = new Intent( getApplicationContext(),MenuGeralActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirPerguntasDepressao(){

        Intent intent = new Intent( getApplicationContext(),PerguntasDepressaoActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirPerguntasPanico(){

        Intent intent = new Intent( getApplicationContext(),PerguntasPanicoActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirPerguntasAutismo(){

        Intent intent = new Intent( getApplicationContext(),PerguntasAutismoActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirPerguntasDor(){

        Intent intent = new Intent( getApplicationContext(),PerguntasDorActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirPerguntasOutros(){

        Intent intent = new Intent( getApplicationContext(),PerguntasOutrosActivity.class );
        startActivity(intent);
        finish();
    }
}
