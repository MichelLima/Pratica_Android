package Diminio.Entidades;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class Colaborador implements Serializable{

   public void colaborador(String nome, int codido){
      this.codigo = codido;
      this.nome = nome;
   }

   public int codigo;
   public String nome;
   public String sobreNome;
   public String dataNascimento;
   public String telefone;
   public String operacao;
   public int like;
   public int deslike;
   public int hateDeslike;

   /*public ArrayList<Colaborador>getColaborador(){
      SQLiteDatabase db = null;
      ArrayList<Colaborador> colaboradores = new ArrayList<>();
      Cursor cursor = db.query("COLABORADOR","NOME");
      }*/
}
