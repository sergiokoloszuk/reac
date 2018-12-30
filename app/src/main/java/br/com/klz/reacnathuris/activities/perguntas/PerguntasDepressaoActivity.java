package br.com.klz.reacnathuris.activities.perguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.klz.reacnathuris.activities.menus.MenuAnamneseActivity;
import br.com.klz.reacnathuris.activities.menus.MenuGeralActivity;
import br.com.klz.reacnathuris.R;

public class PerguntasDepressaoActivity extends AppCompatActivity {

    private Button salvar;
    private Button menuAnamnese;
    private Button menuGeral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_perguntas_depressao );

        initViews();

        salvar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuAnamnese();

            }
        } );
        menuAnamnese.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuAnamnese();

            }
        } );
        menuGeral.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenu();

            }
        } );
    }

    private void initViews() {
        salvar = findViewById( R.id.btn_depressao_salvar );
        menuAnamnese =findViewById( R.id.btn_depressao_voltar_anamnese );
        menuGeral =findViewById( R.id.btn_depressao_voltar_menu );
    }
    private void abrirMenuAnamnese(){

        Intent intent = new Intent( getApplicationContext(),MenuAnamneseActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirMenu(){

        Intent intent = new Intent( getApplicationContext(),MenuGeralActivity.class );
        startActivity(intent);
        finish();
    }
}
