package br.com.klz.reacnathuris.activities.menus;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.klz.reacnathuris.R;
import br.com.klz.reacnathuris.activities.Login.LoginActivity;
import br.com.klz.reacnathuris.activities.resultado.DespesasActivity;
import br.com.klz.reacnathuris.activities.resultado.ReceitasActivity;
import br.com.klz.reacnathuris.activities.resultado.ResultadoRateioActivity;

public class MenuResultadosActivity extends AppCompatActivity {

    private Button despesas;
    private Button receitas;
    private Button resultado;
    private Button voltarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu_resultados );

        initViews();

        despesas.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDespesas();

            }
        } );
        receitas.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirReceitas();

            }
        } );
        resultado.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirResultadoRateio();

            }
        } );
        voltarMenu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuGeral();

            }
        } );


    }

    private void initViews() {
        despesas = findViewById( R.id.btn_despesas );
        receitas = findViewById( R.id.btn_receitas );
        resultado = findViewById( R.id.btn_resultado );
        voltarMenu = findViewById( R.id.btn_financeiro_voltar_menu );
    }

    private void abrirDespesas(){

        Intent intent = new Intent( getApplicationContext(),DespesasActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirReceitas(){

        Intent intent = new Intent( getApplicationContext(),ReceitasActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirResultadoRateio(){

        Intent intent = new Intent( getApplicationContext(),ResultadoRateioActivity.class );
        startActivity(intent);
        finish();
    }
    private void abrirMenuGeral(){

        Intent intent = new Intent( getApplicationContext(),MenuGeralActivity.class );
        startActivity(intent);
        finish();
    }
}
