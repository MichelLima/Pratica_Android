package br.com.validador_cpf;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity{

    private int mEstado;

    Button mbtValidadorCPF;
    Button mbtListaCPF;
    Button mbtCuriosidades;
    Button mbtSobre;


    View.OnClickListener tratadordebotao = new View.OnClickListener(){
        @Override
        public void onClick(View v) {


                switch (v.getId()){

                    case (R.id.btValidaCpf):

                        Intent it = new Intent(MainActivity.this, ValidadorActivity.class);
                        startActivity(it);
                        break;

                    case (R.id.btListaConsultados):

                        Intent inte = new Intent(MainActivity.this, ListaCpf.class);
                        startActivity(inte);
                        break;

                    case (R.id.btSobre):

                        Intent sobreIntent = new Intent(MainActivity.this, Sobre.class);
                        startActivity(sobreIntent);
                        break;

                    case (R.id.BtCuriosidade):

                        Intent curiosidadeIt = new Intent(MainActivity.this, CuriosidadeCpf.class);
                        startActivity(curiosidadeIt);
                        break;
                }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mbtValidadorCPF = (Button) findViewById(R.id.btValidaCpf);
        mbtListaCPF = (Button) findViewById(R.id.btListaConsultados);
        mbtCuriosidades = (Button) findViewById(R.id.BtCuriosidade);
        mbtSobre = (Button) findViewById(R.id.btSobre);

        findViewById(R.id.btValidaCpf).setOnClickListener(tratadordebotao);
        findViewById(R.id.btListaConsultados).setOnClickListener(tratadordebotao);
        findViewById(R.id.BtCuriosidade).setOnClickListener(tratadordebotao);
        findViewById(R.id.btSobre).setOnClickListener(tratadordebotao);


    }


}