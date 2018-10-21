package br.com.avaliaatendiments;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import DataBase.Conexao;
import DataBase.bd_Avalia_OpenHelper;
import Diminio.Entidades.Colaborador;
import Diminio.Repositorios.Colaborador_Repositorio;

public class Cadastro_Func_Activity extends AppCompatActivity {

   EditText edtNome;
   EditText edtSobrenome;
   EditText edtDataNascimento;
   EditText edtOperacao;

   Colaborador_Repositorio colaborador_repositorio;
    private bd_Avalia_OpenHelper AvaliaOpenHelper;
    private SQLiteDatabase conexao;
    private Colaborador colaborador;

    private void Confirmar(){
        colaborador = new Colaborador();
        if (validaCampos() == false){

            try {

            colaborador_repositorio.Inserir(colaborador);
            Toast.makeText(this,R.string.dados_inseridos_com_sucesso, Toast.LENGTH_SHORT).show();

            finish();
        }catch (Exception e){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(e.getMessage());
            dlg.setNeutralButton(R.string.menu_atc_ok, null);
            dlg.show();

            }
        }

    }

    private boolean validaCampos(){

       boolean res = false;
       String nome = edtNome.getText().toString();
       String sobrenome = edtSobrenome.getText().toString();
       String dataNascimento = edtDataNascimento.getText().toString();
       String operacao = edtOperacao.getText().toString();

       colaborador.nome = nome;
       colaborador.sobreNome = sobrenome;
       colaborador.dataNascimento = dataNascimento;
       colaborador.operacao = operacao;

       if(res = isCampoVazio(nome)){

           edtNome.requestFocus();

       }else if(res = isCampoVazio(sobrenome)){

           edtSobrenome.requestFocus();

       }else if (res = isCampoVazio(dataNascimento)){

           edtDataNascimento.requestFocus();

       }else if (res = isCampoVazio(operacao)){

           edtOperacao.requestFocus();
       }

       if(res){

           AlertDialog.Builder dlg = new AlertDialog.Builder(this);
           dlg.setTitle(R.string.dlg_validacao_title);
           dlg.setMessage(R.string.dlg_validacao_message);
           dlg.setNeutralButton(R.string.dlg_validacao_ok, null);
           dlg.show();

       }
        return res;
    }

   private boolean isCampoVazio(String valor){

       boolean resutado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
       return resutado;

   }

   //METODO QUE AVALIA O EMAIL
   private boolean isEmailValido(String email){

       //para validar o email, o campo email não pode ser vazio
       boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());

       return resultado;
   }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__func_);


        edtNome = (EditText)findViewById(R.id.edt_nome_func);
        edtSobrenome = (EditText)findViewById(R.id.edt_sobrenome);
        edtDataNascimento = (EditText)findViewById(R.id.edt_data_nasc);
        edtOperacao = (EditText)findViewById(R.id.edt_operacao);
        CriarConexao();
        }


    private void CriarConexao(){

        try {

            AvaliaOpenHelper = new bd_Avalia_OpenHelper(this);
            conexao = AvaliaOpenHelper.getWritableDatabase();
            Toast.makeText(this, "Conexão bem sucedida", Toast.LENGTH_SHORT);
            Log.d("Teste de conexao", "Conexao Bem Sucedida");
            colaborador_repositorio = new Colaborador_Repositorio(conexao);

        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();

        }

    }
    //metodos do Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_cadastro_func, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.menu_act_ok:
                Confirmar();
                //Toast.makeText(this, "Botão ok selecionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_act_cancel:
               //  Toast.makeText(this,"botão cancelar celecionado", Toast.LENGTH_SHORT).show();
                finish();
                break;
       }
           return super.onOptionsItemSelected(item);
    }
}
