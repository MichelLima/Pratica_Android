package br.com.avaliaatendiments;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import DataBase.bd_Avalia_OpenHelper;
import Diminio.Entidades.Colaborador;

public class CardColab extends AppCompatActivity {

    private bd_Avalia_OpenHelper AvaliaOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_colab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        CriarConexao();
        verificaParametro();
    }

    private void verificaParametro(){

        Bundle bundle = getIntent().getExtras();

        if ((bundle != null)&& (bundle.containsKey("COLABORADOR"))){

            Colaborador colaborador = (Colaborador)bundle.getSerializable("COLABORADOR");

        }
    }

    //TRATAMENTO DO BANCO DE DADOS
    private void CriarConexao(){

        try {

            AvaliaOpenHelper = new bd_Avalia_OpenHelper(this);
            SQLiteDatabase conexao = AvaliaOpenHelper.getWritableDatabase();
            Log.d("Teste de conexao", "Conexao Bem Sucedida");

        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();

        }

    }

}
