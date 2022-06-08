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
    private static final int ZERO = 0;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Calcular");
        }

        tvOpcao = findViewById(R.id.tvOpcao);
        spiOpcoes = findViewById(R.id.spiOpcoes);
        edtOperando1 = findViewById(R.id.edtOperando1);
        imgvOperacao = findViewById(R.id.imgvOperacao);
        imgvOperacao.setVisibility(View.INVISIBLE);
        edtOperando2 = findViewById(R.id.edtOperando2);
        imgvIgual = findViewById(R.id.imgvIgual);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);


        ArrayAdapter<String> adapterOperacoesMatematicas = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.operacoes_matematicas));

        adapterOperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterOperacoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Pega a opção selecionada no SPINNER

                String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

                if (opcaoSelecionada.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Escolha uma operação matemática", Toast.LENGTH_SHORT);

                    if (opcaoSelecionada.equals(DIVISAO)) {
                        tvResultado.setText(divisao());
                        edtOperando1.setHint("Dividendo ");
                        edtOperando2.setHint("Divisor ");

                    } else if (opcaoSelecionada.equals(SOMA)) {
                        tvResultado.setText(somar());
                        edtOperando1.setHint("Parcela");
                        edtOperando2.setHint("Parcela");

                    } else if (opcaoSelecionada.equals(MULTIPLICACAO)) {
                        tvResultado.setText(multiplicacao());
                        edtOperando1.setHint("Fator");
                        edtOperando2.setHint("Fator");

                    } else if (opcaoSelecionada.equals(SUBTRACAO)) {
                        tvResultado.setText(subtracao());
                        edtOperando1.setHint("Minuendo");
                        edtOperando2.setHint("Subtraendo");

                    } else {


                    }
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

        if (adapterView.getItemAtPosition(i).toString() == DIVISAO) {
            if (adapterView.getItemAtPosition(i).toString().equals(DIVISAO)) {
                imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_divisao, getTheme()));
                imgvOperacao.setVisibility(View.VISIBLE);

            } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICACAO)) {
                imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_multiplica, getTheme()));
                imgvOperacao.setVisibility(View.VISIBLE);

            } else if (adapterView.getItemAtPosition(i).toString().equals(SOMA)) {
                imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_soma, getTheme()));
                imgvOperacao.setVisibility(View.VISIBLE);

            } else if (adapterView.getItemAtPosition(i).toString().equals(SUBTRACAO)) {
                imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
                imgvOperacao.setVisibility(View.VISIBLE);

            } else {
                Log.d(TAG, "Nenhuma operação matemática foi selecionada");

            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private boolean validarOperacao(String tipoOperacao) {
        boolean n1 = validarTermoVazio(edtOperando1);
        boolean n2 = validarTermoVazio(edtOperando2);

        if (tipoOperacao.equals(DIVISAO)) {
            if (n1) {
                Toast.makeText(this, "Informe o dividendo", Toast.LENGTH_SHORT).show();
                edtOperando1.requestFocus();
                return false;

            } else if (n2) {
                Toast.makeText(this, "Informe o divisor", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;

            }else if(validarDivisor()){
                Toast.makeText(this, "Divisão por ZERO inválida.", Toast.LENGTH_SHORT).show();
            }

        } else if (tipoOperacao.equals(MULTIPLICACAO)) {
            if (n1) {
                Toast.makeText(this, "Informe o fator", Toast.LENGTH_SHORT).show();
                edtOperando1.requestFocus();
                return false;

            } else if (n2) {
                Toast.makeText(this, "Informe o fator", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;

            }


        }else if (tipoOperacao.equals(SOMA)) {
            if (n1) {
                Toast.makeText(this, "Informe a parcela", Toast.LENGTH_SHORT).show();
                edtOperando1.requestFocus();
                return false;

            } else if (n2) {
                Toast.makeText(this, "Informe a parcela", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;

            }

        }else if (tipoOperacao.equals(SUBTRACAO)) {
            if (n1) {
                Toast.makeText(this, "Informe o minuendo", Toast.LENGTH_SHORT).show();
                edtOperando1.requestFocus();
                return false;

            } else if (n2) {
                Toast.makeText(this, "Informe o subtraendo", Toast.LENGTH_SHORT).show();
                edtOperando2.requestFocus();
                return false;

            }
        }

        return n1;
    }

    private boolean validarDivisor() {
        int n2 = Integer.valueOf(edtOperando2.getText().toString());
        if(n2 != ZERO){
            return true;
        }else{
            return false;
        }

    }

    private boolean validarTermoVazio(EditText editText){
        return editText.getText().toString().isEmpty();
    }


    private String somar() {
        String resultado = "";
        int n1 = Integer.parseInt(edtOperando1.getText().toString());
        int n2 = Integer.parseInt(edtOperando2.getText().toString());

        int res = n1 + n2;
        //tvResultado.setText(String.valueOf(n1 + n2));
        return "O resultado da soma é: " + res;
    }

    private String subtracao() {
        String resultado = "";
        int n1 = Integer.parseInt(edtOperando1.getText().toString());
        int n2 = Integer.parseInt(edtOperando2.getText().toString());

        int res = n1 - n2;
        return "O resultado da subtração é: " + res;

    }

    private String multiplicacao() {
        String resultado = "";
        int n1 = Integer.parseInt(edtOperando1.getText().toString());
        int n2 = Integer.parseInt(edtOperando2.getText().toString());

        int res = n1 - n2;
        return "O resultado da subtração é: " + res;

    }

    private String divisao() {
        String resultado = "";
        int n1 = Integer.parseInt(edtOperando1.getText().toString());
        int n2 = Integer.parseInt(edtOperando2.getText().toString());

        int res = n1 / n2;
        return "O resultado da divisão é: " + res;

    }

}


