package Diminio.Repositorios;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Diminio.Entidades.Colaborador;

public class Colaborador_Repositorio {

    private SQLiteDatabase conexao;

    public Colaborador_Repositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void Inserir(Colaborador colaborador){

        ContentValues  contentValues = new ContentValues();

        contentValues.put("NOME", colaborador.nome);
        contentValues.put("SOBRENOME", colaborador.sobreNome);
        contentValues.put("DATA_NASCIMENTO", colaborador.dataNascimento);
        contentValues.put("OPERACAO", colaborador.operacao);
        contentValues.put("LIKE", colaborador.like);
        contentValues.put("DESLIKE", colaborador.deslike);
        contentValues.put("HATEDESLIKE", colaborador.hateDeslike);

        conexao.insertOrThrow("COLABORADOR", null, contentValues );
   }

    public void excluir (int codigo){

        String[] parametro = new String[1];
        parametro[0] = String.valueOf(codigo);
        conexao.delete("COLABORADOR", "CODIGO = ?", parametro );
    }

    public void Alterar(Colaborador colaborador){

        ContentValues  contentValues = new ContentValues();

        contentValues.put("NOME", colaborador.nome);
        contentValues.put("SOBENOME", colaborador.sobreNome);
        contentValues.put("DATA_NASCIMENTO", colaborador.dataNascimento);
        contentValues.put("OPERACAO", colaborador.operacao);
        contentValues.put("LIKE", colaborador.like);
        contentValues.put("DESLIKE", colaborador.deslike);
        contentValues.put("HATEDESLIKE", colaborador.hateDeslike);

        String[] parametro = new String[1];
        parametro[0] = String.valueOf(colaborador.codigo);
        conexao.update("COLABORADOR", contentValues, "CODIGO = ?", parametro );
    }

    public List<Colaborador> BuscarTodos(){

        List<Colaborador> colaboradores = new ArrayList<Colaborador>();
        Log.d("Entroi aqui: ", "Metodo Buscar todos");
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, NOME, SOBRENOME, DATA_NASCIMENTO, OPERACAO, LIKE, DESLIKE, HATEDESLIKE");
        sql.append(" FROM COLABORADOR");

        Cursor resultado = conexao.rawQuery(sql.toString(), null);

        if(resultado.getCount() > 0) {

            resultado.moveToFirst();
            do {
                Log.d("Entroi aqui: ", "passou....");
                Colaborador colab = new Colaborador();
                colab.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
                colab.nome = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
                colab.sobreNome = resultado.getString(resultado.getColumnIndexOrThrow("SOBRENOME"));
                colab.dataNascimento = resultado.getString(resultado.getColumnIndexOrThrow("DATA_NASCIMENTO"));
                colab.operacao = resultado.getString(resultado.getColumnIndexOrThrow("OPERACAO"));
                colab.like = resultado.getInt(resultado.getColumnIndexOrThrow("LIKE"));
                colab.deslike = resultado.getInt(resultado.getColumnIndexOrThrow("DESLIKE"));
                colab.hateDeslike = resultado.getInt(resultado.getColumnIndexOrThrow("HATEDESLIKE"));

                colaboradores.add(colab);


            }while (resultado.moveToNext());
        }


        return colaboradores;
    }

    public Colaborador BuscarColaborador(int codigo) {

        Colaborador colaborador = new Colaborador();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, NOME, SOBRENOME, DATA_NASCIMENTO, OPERACAO, LIKE, DESLIKE");
        sql.append("FROM COLABORADOR");
        sql.append("WHERE CODIGO = ?");

        String[] parametro =  new  String[1];
        parametro[0] = String.valueOf(codigo);

        Cursor resultado = conexao.rawQuery(sql.toString(), parametro);

        if (resultado.getCount()> 0) {
            colaborador.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
            colaborador.nome = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
            colaborador.nome = resultado.getString(resultado.getColumnIndexOrThrow("SOBRENOME"));
            colaborador.nome = resultado.getString(resultado.getColumnIndexOrThrow("DATA_NASCIMENTO"));
            colaborador.nome = resultado.getString(resultado.getColumnIndexOrThrow("OPERACAO"));
            colaborador.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("LIKE"));
            colaborador.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("DELIKE"));
            colaborador.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("HATEDELIKE"));

            return colaborador;
        }

        return null;

    }
}
