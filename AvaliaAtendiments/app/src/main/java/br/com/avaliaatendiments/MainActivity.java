package br.com.avaliaatendiments;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import DataBase.bd_Avalia_OpenHelper;
import Diminio.Entidades.Colaborador;
import Diminio.Repositorios.Colaborador_Repositorio;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;
    private bd_Avalia_OpenHelper AvaliaOpenHelper;
    private RecyclerView lstDados;
    private FloatingActionButton fab;
    private String status;
    private String nome;
    TextView txtNome;
    TextView txtStatus;

    View.OnClickListener TratadordeBotao = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case ( R.id.floatingActionButton):
                    Intent it = new Intent(MainActivity.this, AvaliaActivity.class);
                    startActivity(it);
                    break;
                /*case (R.id.bt_tela_cadastro):
                    Intent it_cadastro = new Intent(MainActivity.this, Cadastro_Func_Activity.class);
                    startActivity(it_cadastro);
                    break;*/
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = (TextView)findViewById(R.id.txtNome);
        txtStatus = (TextView)findViewById(R.id.txtAvaliacao);

        fab = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        findViewById(R.id.floatingActionButton).setOnClickListener(TratadordeBotao);
        //lstDados = (RecyclerView)findViewById(R.id.lstDados);

        Intent intent = getIntent();
        if (intent != null){

            Bundle parametros = intent.getExtras();

            if (parametros != null){

                 txtNome.setText(parametros.getString("NOME"));

                if (parametros.getInt("LIKE") == 0 ){

                   txtStatus.setText("Like");

                }if (parametros.getInt("DESLIKE")== 1){

                    txtStatus.setText("Deslike");

                }if(parametros.getInt("HATEDESLIKE") == 2){

                    txtStatus.setText("Hatedeslike");

                }

            }

        }
    }


        //TRATAMENTO DO BANCO DE DADOS
        private void CriarConexao(){

            try {

                AvaliaOpenHelper = new bd_Avalia_OpenHelper(this);
                conexao = AvaliaOpenHelper.getWritableDatabase();
                Log.d("Teste de conexao", "Conexao Bem Sucedida");

            }catch (SQLException ex){

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("Erro");
                dlg.setMessage(ex.getMessage());
                dlg.setNeutralButton("ok", null);
                dlg.show();

            }

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){

            case ( R.id.actMenu_main_cads_Func):
                Intent it_cadastro = new Intent(MainActivity.this, Cadastro_Func_Activity.class);
                startActivity(it_cadastro);
                break;
            case (R.id.actMenu_main_culsult_Func):
                Intent it_consult = new Intent(MainActivity.this, lstFunc_Activity.class);
                startActivity(it_consult);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
