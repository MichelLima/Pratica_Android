package br.com.avaliaatendiments;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import DataBase.bd_Avalia_OpenHelper;
import Diminio.Entidades.Colaborador;
import Diminio.Repositorios.Colaborador_Repositorio;

public class lstFunc_Activity extends AppCompatActivity {


    private bd_Avalia_OpenHelper AvaliaOpenHelper;
    private SQLiteDatabase conexao;
    private RecyclerView lstDados;
    private Colaborador colaborador;
    private Colaborador_Adapter colaboradorAdapter;
    private Colaborador_Repositorio colaborador_repositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_func_);

        lstDados = (RecyclerView)findViewById(R.id.lst_colaboradores);

        CriarConexao();
        lstDados.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstDados.setLayoutManager(linearLayoutManager);
        colaborador_repositorio = new Colaborador_Repositorio(conexao);
        List<Colaborador> dados = colaborador_repositorio.BuscarTodos();
        colaboradorAdapter = new Colaborador_Adapter(dados);
        lstDados.setAdapter(colaboradorAdapter);

       CriarConexao();


    }

    private void CriarConexao(){

        try {

            AvaliaOpenHelper = new bd_Avalia_OpenHelper(this);
            conexao = AvaliaOpenHelper.getWritableDatabase();
            Toast.makeText(this, "Conexão bem sucedida", Toast.LENGTH_SHORT).show();
            //Log.d("Teste de conexao", "Conexao Bem Sucedida");
            colaborador_repositorio = new Colaborador_Repositorio(conexao);

        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();

        }

    }
}
