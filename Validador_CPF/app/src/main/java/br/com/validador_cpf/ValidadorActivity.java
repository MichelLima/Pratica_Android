package br.com.validador_cpf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ValidadorActivity extends AppCompatActivity {

    public static final String RESULTADO = "resultado";
    EditText numCPF;
    Button btValidar;
    TextView txtResultado;
    String txt;

    public static final int eCPF = 0;
    public static final int naoCPF = 1;

    private  int mResultado;
    private View.OnClickListener tratadorBotao = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String cpf = numCPF.getText().toString();

            if (cpf != null){

                if (ValidaCpf.isCpf(cpf)== true){

                    mResultado = eCPF;

                }else{

                    mResultado = naoCPF;
                }

                atualizarTexto(mResultado);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        numCPF = (EditText)findViewById(R.id.numCPF);
        numCPF.setHint("Digite um CPF");
        btValidar = (Button)findViewById(R.id.btCPF);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

        findViewById(R.id.btCPF).setOnClickListener(tratadorBotao);

        if (savedInstanceState != null){

            mResultado =  savedInstanceState.getInt(RESULTADO);
            atualizarTexto(mResultado);

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(RESULTADO, mResultado);
    }

    private  void atualizarTexto(int resultado){

        String cpf = numCPF.getText().toString();

        if (resultado == eCPF){

            txtResultado.setText( ValidaCpf.imprimeCPF(cpf));


        }if (resultado == naoCPF){

            txtResultado.setText("CPF Invalido");
        }



    }
}
