package DataBase;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import Diminio.Entidades.Colaborador;
import Diminio.Repositorios.Colaborador_Repositorio;
import br.com.avaliaatendiments.Colaborador_Adapter;

public class Conexao {

    private bd_Avalia_OpenHelper AvaliaOpenHelper;
    private SQLiteDatabase conexao;
    private RecyclerView lstDados;
    private Colaborador colaborador;
    private Colaborador_Adapter colaboradorAdapter;
    private Colaborador_Repositorio colaborador_repositorio;

    public Conexao(){}

    public void CriarConexao(){

        try {

            AvaliaOpenHelper = new bd_Avalia_OpenHelper(null);
            conexao = AvaliaOpenHelper.getWritableDatabase();
            Toast.makeText(null, "Conexão bem sucedida", Toast.LENGTH_SHORT).show();
            Log.d("Teste de conexao", "Conexao Bem Sucedida");
            colaborador_repositorio = new Colaborador_Repositorio(conexao);

        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(null);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();

        }

    }
}
