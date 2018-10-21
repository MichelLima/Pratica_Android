package br.com.avaliaatendiments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import Diminio.Entidades.Colaborador;

public class AvaliaActivity extends AppCompatActivity {

    ImageView img1;
    private static String nome = null;
    ImageView img2;
    ImageView img3;
    Boolean estado = true;
    Spinner spinner_Avalia;
    String listaNomes[] = new String[]{" ", "MICHEL", "JULIAN", "NETO", "ERICK", "DARLAN"};
    Bundle parametros = new Bundle();

    final View.OnClickListener TratadordeCliks = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case (R.id.img01):
                    Log.v("Click", "Imagem 1 Clicada");
                    Intent itImg01 = new Intent(AvaliaActivity.this, MainActivity.class);
                    parametros.putInt("LIKE", 0);
                    parametros.putString("NOME", nome);
                    itImg01.putExtras(parametros);
                    startActivity(itImg01);
                    break;
                case (R.id.img02):
                    Log.v("Click", "Imagem 2 Clicada");
                    Intent itImg02 = new Intent(AvaliaActivity.this, MainActivity.class);
                    parametros.putInt("DESLIKE", 1);
                    parametros.putString("NOME", nome);
                    itImg02.putExtras(parametros);
                    startActivity(itImg02);
                    break;
                case (R.id.img03):
                    Log.v("Click", "Imagem 3 Clicada");
                    Intent itImg03 = new Intent(AvaliaActivity.this, MainActivity.class);
                    parametros.putInt("HATEDESLIKE", 2);
                    parametros.putString("NOME", nome);
                    itImg03.putExtras(parametros);
                    startActivity(itImg03);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalia);

       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        if (savedInstanceState == null){

            img1 = (ImageView) findViewById(R.id.img01);
            img2 = (ImageView) findViewById(R.id.img02);
            img3 = (ImageView) findViewById(R.id.img03);

            img1.setOnClickListener(TratadordeCliks);
            img2.setOnClickListener(TratadordeCliks);
            img3.setOnClickListener(TratadordeCliks);

            //TRATAMENTO DO SPINER

            spinner_Avalia = (Spinner)findViewById(R.id.spinner_Avalia);
            ArrayAdapter<String> nomes_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaNomes);
           // ArrayAdapter<String> colaboradorArrayAdapter = ArrayAdapter.createFromResource(this,listaNomes,android.R.layout.simple_spinner_dropdown_item);
            nomes_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_Avalia.setAdapter(nomes_Adapter);

            spinner_Avalia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                    Log.d("SELECIONADO: ", listaNomes[position]);
                    nome = listaNomes[position];



                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            //TRATAMENTO DO SPINER
        }else {

            savedInstanceState.getBoolean("estado");

        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("estado", estado);


    }


}
