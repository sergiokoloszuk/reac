package br.com.klz.reacnathuris.activities.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.klz.reacnathuris.activities.Calendar.CalendarioActivity;
import br.com.klz.reacnathuris.R;

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
        anamnese.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuAnamnese();
            }
        } );
        financeiro.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuResultados();
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

        Intent intent = new Intent( getApplicationContext(),CalendarioActivity.class );
        startActivity(intent);
        finish();
    }

    private void abrirMenuAnamnese(){

        Intent intent = new Intent( getApplicationContext(),MenuAnamneseActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirMenuResultados(){

        Intent intent = new Intent( getApplicationContext(),MenuResultadosActivity.class );
        startActivity(intent);
        finish();
    }
}
