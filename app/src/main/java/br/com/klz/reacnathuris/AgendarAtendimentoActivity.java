package br.com.klz.reacnathuris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgendarAtendimentoActivity extends AppCompatActivity {

    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_agendar_atendimento );

        initViews();

        salvar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCalendar();
            }
        } );
    }

    private void initViews() {
        salvar = findViewById( R.id.btn_salvar_agendamento );
    }

    private void abrirCalendar(){

        Intent intent = new Intent( getApplicationContext(),CalendarActivity.class );
        startActivity(intent);
        finish();
    }
}
