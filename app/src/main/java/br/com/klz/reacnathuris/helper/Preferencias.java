package br.com.klz.reacnathuris.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {
    public Context context;
    private SharedPreferences preferences;
    private String EMAIL = "ReacPreferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "Usuario_Logado";
    private final String CHAVE_EMAIL = "Email_Usuario_Logado";

    public Preferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(EMAIL,MODE);

        editor = preferences.edit();
    }
    public void salvarPreferenciasUsuarios (String identificadorUsuario, String emailUsuario){
        editor.putString( CHAVE_IDENTIFICADOR,identificadorUsuario );
        editor.putString( CHAVE_EMAIL, emailUsuario );
        editor.commit();
    }
    public String getIdentificador (){
        return preferences.getString(CHAVE_IDENTIFICADOR,null);
    }
    public String getEMAIL (){
        return preferences.getString( CHAVE_EMAIL,null );
    }
}
