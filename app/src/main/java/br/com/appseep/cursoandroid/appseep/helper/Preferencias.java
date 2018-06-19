package br.com.appseep.cursoandroid.appseep.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by rair.angelos on 27/04/2018.
 */
public class Preferencias {

    private Context contexto;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "appseep.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private String CHAVE_NOME = "nome";
    private String CHAVE_TELEFONE = "telefone";
    private String CHAVE_TOKEN = "token";


    public Preferencias (Context contextoParametro){

        contexto = contextoParametro;

        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }

    public void salvarUsuarioPreferencias(String nome, String telefone, String token){

        editor.putString(CHAVE_NOME, nome);
        editor.putString(CHAVE_TELEFONE, telefone);
        editor.putString(CHAVE_TOKEN, token);
        editor.commit();

    }
    public HashMap<String, String> getDadosUsuarios(){

        HashMap<String, String> dadosUsuarios = new HashMap<>();

        dadosUsuarios.put(CHAVE_NOME, preferences.getString(CHAVE_NOME, null));
        dadosUsuarios.put(CHAVE_TELEFONE, preferences.getString(CHAVE_TELEFONE, null));
        dadosUsuarios.put(CHAVE_TOKEN, preferences.getString(CHAVE_TOKEN, null));

        return dadosUsuarios;
    }
}
