package br.com.klz.reacnathuris.activities.cadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.klz.reacnathuris.activities.menus.MenuGeralActivity;
import br.com.klz.reacnathuris.R;

public class CadUnidadesActivity extends AppCompatActivity {

    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cad_unidades );

        initViews();

        salvar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMenuGeral();
            }
        } );
    }

    private void initViews() {
        salvar = findViewById( R.id.btn_salvar_unidade );
    }

    private void abrirMenuGeral(){

        Intent intent = new Intent( getApplicationContext(),MenuGeralActivity.class );
        startActivity(intent);
        finish();
    }
}
