package br.com.klz.reacnathuris;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuGeralActivity extends AppCompatActivity {

    private Button cadastros;
    private Button agenda;
    private Button fila;
    private Button anamnese;
    private Button financeiro;
    private Button follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu_geral );

        initViews();

        cadastros.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuCadastros();
            }
        } );
        agenda.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCalendar();
            }
        } );
    }

    private void initViews() {
        cadastros = findViewById( R.id.btn_goto_cadastros );
        agenda = findViewById( R.id.btn_goto_agenda );
        fila = findViewById( R.id.btn_goto_fila );
        anamnese = findViewById( R.id.btn_goto_anamnese );
        financeiro = findViewById( R.id.btn_goto_financeiro );
        follow = findViewById( R.id.btn_goto_follow );
    }

    private void abrirMenuCadastros(){

        Intent intent = new Intent( getApplicationContext(),MenuCadastrosActivity.class );
        startActivity(intent);
        finish();
    }

    private void abrirCalendar(){

        Intent intent = new Intent( getApplicationContext(),CalendarActivity.class );
        startActivity(intent);
        finish();
    }
}
