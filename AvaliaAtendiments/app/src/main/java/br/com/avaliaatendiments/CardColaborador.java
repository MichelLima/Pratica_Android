package br.com.avaliaatendiments;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import DataBase.bd_Avalia_OpenHelper;
import Diminio.Entidades.Colaborador;

public class CardColaborador extends AppCompatActivity {

    TextView txtNome, txtSobrenome, txtTelefone, txtOperacao, txtLike, txtDeslike, txtHatedeslike;
    private bd_Avalia_OpenHelper AvaliaOpenHelper;
    ImageView imgViewCardFunf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_colaborador);

        txtNome         = (TextView)findViewById(R.id.txtNome);
        txtSobrenome    = (TextView)findViewById(R.id.txtSobrenome);
        txtTelefone     = (TextView)findViewById(R.id.txtTelefone);
        txtOperacao     = (TextView)findViewById(R.id.txtOperacao);
        txtLike         = (TextView)findViewById(R.id.txtLike);
        txtDeslike      = (TextView)findViewById(R.id.txtDeslike);
        txtHatedeslike  = (TextView)findViewById(R.id.txtHateDeslike);
        imgViewCardFunf = (ImageView)findViewById(R.id.imgView_cardFunc);


        CriarConexao();
        verificaParametro();
    }

    private void verificaParametro(){

        Bundle bundle = getIntent().getExtras();

        if ((bundle != null)&& (bundle.containsKey("COLABORADOR"))){

            Colaborador colaborador = (Colaborador)bundle.getSerializable("COLABORADOR");

            String like = String.valueOf(colaborador.like);
            String desLike = String.valueOf(colaborador.deslike);
            String hateDeslike = String.valueOf(colaborador.hateDeslike);


            txtNome.setText(colaborador.nome);
            txtSobrenome.setText(colaborador.sobreNome);
            txtTelefone.setText(colaborador.telefone);
            txtOperacao.setText(colaborador.operacao);
           if ((like == null)|| (like == "")){

               txtLike.setText("0");
           }else {
            txtLike.setText(like);}

            if ((desLike == null)|| (desLike == "")){

                txtDeslike.setText("0");
            }else {
                txtDeslike.setText(desLike);}

            //txtDeslike.setText(colaborador.deslike);

            if ((hateDeslike == null)|| (hateDeslike == "")){

                txtHatedeslike.setText("0");
            }else {
                txtHatedeslike.setText(hateDeslike);}
            //txtHatedeslike.setText(colaborador.hateDeslike);

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
