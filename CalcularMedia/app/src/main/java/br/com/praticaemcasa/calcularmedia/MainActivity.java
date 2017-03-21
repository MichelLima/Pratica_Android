package br.com.praticaemcasa.calcularmedia;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtnota1;
    EditText edtnota2;
    TextView txtResultado;
    Button btCalcular;
    String temp;

   View.OnClickListener tratarEventos = new View.OnClickListener() {
       @Override
       public void onClick(View v) {

           Double n1 = Double.parseDouble(edtnota1.getText().toString());
           Double n2 = Double.parseDouble(edtnota2.getText().toString());
           String resultado;

           Double media = (n1 + n2)/2;

           if (media < 7){

               resultado = "Sua Media: " + media + "   Reprovado";
               temp = resultado;

           }else{

               resultado = "Sua Media: " + media + "   Aprovado";
               temp = resultado;

           }

            atualizarTexto();

       }
   };

    private  void atualizarTexto(){

        txtResultado.setText(temp);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnota1 = (EditText)findViewById(R.id.editNota1);
        edtnota2 = (EditText)findViewById(R.id.editNota2);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

        findViewById(R.id.btCalcular).setOnClickListener(tratarEventos);

        if (savedInstanceState != null){

            temp = savedInstanceState.getString("temp");
            atualizarTexto();

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("temp", temp);
    }
}
