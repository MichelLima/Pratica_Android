package br.com.praticaemcasa.gasolina;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    public static final String RESULTADO = "resultado";
    EditText edtgasolina;
    EditText edtAlcool;
    TextView txtResultado;
    Button btCalcular;

    public static final int NADA = 0;
    public static final int GAS= 1;
    public static final int ALCOOL = 2;

    private int mResultado;

    View.OnClickListener trataEventos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Double gasolina = Double.parseDouble(edtgasolina.getText().toString());
            Double alcool = Double.parseDouble(edtAlcool.getText().toString());
            String resultados = getString(R.string.resultado);

            if((gasolina * 0.7)> alcool){

                //resultados += getString(R.string.alcool);
                mResultado = ALCOOL;

            }else {

               // resultados += getString(R.string.gasolina );
                mResultado = GAS;

            }
           // txtResultado.setText(resultados);
            atualizarResultado(mResultado);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtgasolina = (EditText)findViewById(R.id.edtGasolina);
        edtAlcool = (EditText)findViewById(R.id.edtAlcool);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

        findViewById(R.id.btCalcular).setOnClickListener(trataEventos);

        if(savedInstanceState != null){

            mResultado = savedInstanceState.getInt(RESULTADO);
            atualizarResultado(mResultado);
        }
    }

    //Salvar o estado da Activity
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(RESULTADO, mResultado);
    }

    private  void atualizarResultado(int resultado){

         if (resultado != NADA){

             String TxtResultado = getString(R.string.resultado);

        if(resultado ==  ALCOOL){

            TxtResultado += getString(R.string.alcool);


        }else if(resultado ==GAS){

            TxtResultado += getString(R.string.gasolina );

        }
        txtResultado.setText(TxtResultado);
       }
    }
};

