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

    private static final String TAG = "MainActivity" ;
    private TextView tvOpcao;
    private Spinner spiOpcoes;
    //private TextView tvOperacao;
    private EditText edtOperando1;
    private ImageView imgvOperacao;
    private EditText edtOperando2;
    private ImageView imgvIgual;
    private TextView tvResultado;
    private Button btnCalcular;
    private static final String DIVISAO         = "Divisão";
    private static final String MULTIPLICACAO   = "Multiplicação";
    private static final String SOMA            = "Soma";
    private static final String SUBTRACAO       = "Subtração";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Calcular");
        }

        tvOpcao            = findViewById(R.id.tvOpcao);
        spiOpcoes          = findViewById(R.id.spiOpcoes);
        edtOperando1       = findViewById(R.id.edtOperando1);
        imgvOperacao       = findViewById(R.id.imgvOperacao);
        imgvOperacao.setVisibility(View.INVISIBLE);
        edtOperando2       = findViewById(R.id.edtOperando2);
        imgvIgual          = findViewById(R.id.imgvIgual);
        tvResultado        = findViewById(R.id.tvResultado);
        btnCalcular        = findViewById(R.id.btnCalcular);


        ArrayAdapter<String> adapterOperacoesMatematicas = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.operacoes_matematicas));

        adapterOperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spiOpcoes.setAdapter(adapterOperacoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);

        String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pega a opção selecionada no SPINNER

                if (opcaoSelecionada == DIVISAO) {

                }

                if(opcaoSelecionada == SOMA){

                }

                if(opcaoSelecionada == MULTIPLICACAO){

                }

                if (opcaoSelecionada == SUBTRACAO){

                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this, adapterView.getItemIdAtPosition(i), toString(), Toast.LENGTH_SHORT).show();
        imgvOperacao.setVisibility(View.VISIBLE);

        if(adapterView.getItemAtPosition(i).toString().equals(DIVISAO) ){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_divisao , getTheme()));

        }else if(adapterView.getItemAtPosition(i).toString().equals(MULTIPLICACAO) ){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_multiplica, getTheme()));

        }else if(adapterView.getItemAtPosition(i).toString().equals(SOMA)){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_soma , getTheme()));

        }else if(adapterView.getItemAtPosition(i).toString().equals(SUBTRACAO)){
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));

        }else{
            Log.d(TAG, "Nenhuma operação matemática foi selecionada");

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}