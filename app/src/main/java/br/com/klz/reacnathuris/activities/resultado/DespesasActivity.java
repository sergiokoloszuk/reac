package br.com.klz.reacnathuris.activities.resultado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.klz.reacnathuris.R;
import br.com.klz.reacnathuris.activities.menus.MenuResultadosActivity;

public class DespesasActivity extends AppCompatActivity {

    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_despesas );

        InitViews();

        salvar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuResultados();
            }
        } );
    }

    private void InitViews() {
        salvar = findViewById( R.id.btn_salvar_despesa );
    }
    private void abrirMenuResultados(){

        Intent intent = new Intent( getApplicationContext(),MenuResultadosActivity.class );
        startActivity(intent);
        finish();
    }
}
