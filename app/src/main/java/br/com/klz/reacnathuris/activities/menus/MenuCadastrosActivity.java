package br.com.klz.reacnathuris.activities.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.klz.reacnathuris.R;
import br.com.klz.reacnathuris.activities.cadastros.CadPacientesActivity;
import br.com.klz.reacnathuris.activities.cadastros.CadProtocolosActivity;
import br.com.klz.reacnathuris.activities.cadastros.CadUnidadesActivity;

public class MenuCadastrosActivity extends AppCompatActivity {

    private Button pacientes;
    private Button unidades;
    private Button protocolos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu_cadastros );

        initViews();

        pacientes.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastroPacientes();
            }
        } );

        unidades.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastroUnidades();
            }
        } );

        protocolos.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastroProtocolos();
            }
        } );
    }

    private void initViews() {
        pacientes = findViewById( R.id.btn_goto_cad_pacientes );
        unidades = findViewById( R.id.btn_goto_cad_unidades );
        protocolos = findViewById( R.id.btn_goto_cad_protocolos );
    }

    private void abrirCadastroPacientes(){

        Intent intent = new Intent( getApplicationContext(),CadPacientesActivity.class );
        startActivity(intent);
        finish();
    }

    private void abrirCadastroUnidades(){

        Intent intent = new Intent( getApplicationContext(),CadUnidadesActivity.class );
        startActivity(intent);
        finish();
    }

    private void abrirCadastroProtocolos(){

        Intent intent = new Intent( getApplicationContext(),CadProtocolosActivity.class );
        startActivity(intent);
        finish();
    }




}
