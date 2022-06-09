package vieira.maiara.uno.calcular;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "MainActivity";
    private static final int ZERO   = 0;
    private TextView tvOpcao;
    private Spinner spiOpcoes;
    //private TextView tvOperacao;
    private EditText edtOperando1;
    private ImageView imgvOperacao;
    private EditText edtOperando2;
    private ImageView imgvIgual;
    private TextView tvResultado;
    private Button btnCalcular;
    private Button btnLimpar;
    private static final String DIVISAO         = "Divisão";
    private static final String MULTIPLICACAO   = "Multiplicação";
    private static final String SOMA            = "Soma";
    private static final String SUBTRACAO       = "Subtração";
    private static final String POTENCIADE10    = "Potencia de 10";
    private static final String RAIZQUADRADA    = "Raiz Quadrada";
    private static final String POTENCIACAO     = "Potenciação";
    private static final String LOGARITMO       = "Logaritmo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Calcular");
        }

        tvOpcao         = findViewById(R.id.tvOpcao);
        spiOpcoes       = findViewById(R.id.spiOpcoes);
        edtOperando1    = findViewById(R.id.edtOperando1);
        imgvOperacao    = findViewById(R.id.imgvOperacao);
        imgvOperacao.setVisibility(View.INVISIBLE);
        edtOperando2    = findViewById(R.id.edtOperando2);
        imgvIgual       = findViewById(R.id.imgvIgual);
        tvResultado     = findViewById(R.id.tvResultado);
        btnCalcular     = findViewById(R.id.btnCalcular);
        btnLimpar       = findViewById(R.id.btnLimpar);


        imgvOperacao.setVisibility(View.INVISIBLE);


        ArrayAdapter<String> adapterOperacoesMatematicas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.operacoes_matematicas));

        adapterOperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterOperacoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Pega a opção selecionada no SPINNER

                String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

                if (opcaoSelecionada.equals(DIVISAO)) {

                    if(validarTermosVazios()) {
                        if(validarDivisor()){
                            tvResultado.setText(divisao());
                        }else{
                            Toast.makeText(MainActivity.this, "O divisor não pode ser ZERO!!", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }

                } else if (opcaoSelecionada.equals(SOMA)) {
                    if(validarTermosVazios()) {
                        tvResultado.setText(somar());
                    } else{
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }

                } else if (opcaoSelecionada.equals(MULTIPLICACAO)) {
                    if (validarTermosVazios()){
                        tvResultado.setText(multiplicacao());
                    }else{
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }

                } else if (opcaoSelecionada.equals(SUBTRACAO)) {
                    if (validarDivisor()) {
                        tvResultado.setText(subtracao());
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }

                }else if(opcaoSelecionada.equals(POTENCIADE10)) {
                    if (validarTermosVazios()) {
                        tvResultado.setText(potenciaDe10());
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }

                }else if(opcaoSelecionada.equals(RAIZQUADRADA)) {
                    if (validarTermosVazios()) {
                        tvResultado.setText(raizQuadrada());
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }

                }else if(opcaoSelecionada.equals(POTENCIACAO)) {
                    if (validarTermosVazios()) {
                        tvResultado.setText(potenciacao());
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }

                }else if (opcaoSelecionada.equals(LOGARITMO)){
                    if (validarTermosVazios()){
                        tvResultado.setText(logaritmo());
                    }else{
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(MainActivity.this, "Selecione um número e uma opção matemática!!", Toast.LENGTH_SHORT).show();



                }
            }

        });

        btnLimpar.setOnClickListener(new View.OnClickListener() { //Clic do botão limpar
            @Override
            public void onClick(View view) {
                edtOperando1.setText("");
                edtOperando2.setText("");
                tvResultado.setText("");
                //imgOperacao.setVisibility(View.INVISIBLE);
                //spiOpcoes.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

        if (adapterView.getItemAtPosition(i).toString().equals(DIVISAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_divisao, getTheme()));
            imgvOperacao.setVisibility(View.VISIBLE);
            edtOperando1.setHint("Dividendo");
            edtOperando2.setHint("Divisor");

        } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_multiplica, getTheme()));
            imgvOperacao.setVisibility(View.VISIBLE);
            edtOperando1.setHint("Multiplicando");
            edtOperando2.setHint("Multiplicador");

        } else if (adapterView.getItemAtPosition(i).toString().equals(SOMA)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_soma, getTheme()));
            imgvOperacao.setVisibility(View.VISIBLE);
            edtOperando1.setHint("Parcela");
            edtOperando2.setHint("Parcela");

        } else if (adapterView.getItemAtPosition(i).toString().equals(SUBTRACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
            imgvOperacao.setVisibility(View.VISIBLE);
            edtOperando1.setHint("Minuendo");
            edtOperando2.setHint("Subtraendo");

        } else if (adapterView.getItemAtPosition(i).toString().equals(POTENCIADE10)){
            imgvOperacao.setImageDrawable(getResources().getDrawable());
            imgvOperacao.setVisibility(View.VISIBLE);
            edtOperando1.setHint("Potencia de 10");

        }else if (adapterView.getItemAtPosition(i).toString().equals(RAIZQUADRADA)){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_raiz_quadrada, getTheme()));
            imgvOperacao.setVisibility(View.VISIBLE);
            edtOperando1.setHint("Raiz Quadrada");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private String somar() {

        int n1 = Integer.valueOf(edtOperando1.getText().toString()).intValue();
        int n2 = Integer.valueOf(edtOperando2.getText().toString()).intValue();
        int res = n1 + n2;

        return "O resultado da soma é: " + res;

    }

    private String subtracao() {
        int n1 = Integer.valueOf(edtOperando1.getText().toString()).intValue();
        int n2 = Integer.valueOf(edtOperando2.getText().toString()).intValue();
        int res = n1 - n2;

        return "O resultado da subtração é: " + res;

    }

    private String multiplicacao() {
        int n1 = Integer.valueOf(edtOperando1.getText().toString());
        int n2 = Integer.valueOf(edtOperando2.getText().toString());
        int res = n1 * n2;

        return "O resultado da multiplicação é: " + res;

    }

    private String divisao() {
        int n1 = Integer.valueOf(edtOperando1.getText().toString()).intValue();
        int n2 = Integer.valueOf(edtOperando2.getText().toString()).intValue();
        int res = n1 / n2;

        return "O resultado da divisão é: " + res;

    }

    private boolean validarTermosVazios(){
        if(!edtOperando1.getText().toString().isEmpty()) {
            if (!edtOperando2.getText().toString().isEmpty()) {
                return true;

            } else {
                edtOperando2.requestFocus();
                return false;
            }

        }else{
            edtOperando1.requestFocus();
            return false;
        }
    }

    private boolean validarDivisor() {
        int n2 = Integer.valueOf(edtOperando2.getText().toString());
        if(n2 != ZERO){
            return true;
        }else{
            return false;
        }

    }

    private String potenciaDe10(){
        int n1  = Integer.valueOf(edtOperando1.getText().toString());
        int n2  = Integer.valueOf(edtOperando2.getText().toString());
        int res = n1 * n2;

        return "O resultado da potencia de 10 é: " + res;

    }

    private String raizQuadrada(){
        double n1  = Integer.valueOf(edtOperando1.getText().toString());
        double resultado = Math.sqrt(n1);

        return "O resultado da Raiz Quadrada é: " + resultado;
    }

    private String potenciacao(){
        double n1 = Integer.valueOf(edtOperando1.getText().toString());
        //double resultado = Math.
        return "O resultado da Potenciação é: " + tvResultado;
    }

    private String logaritmo(){
        return "O resultado do Logaritmo é: " + tvResultado;
    }

}


