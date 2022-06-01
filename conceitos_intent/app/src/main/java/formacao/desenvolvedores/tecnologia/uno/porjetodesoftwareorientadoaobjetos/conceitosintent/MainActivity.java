package formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent;



import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent.utils.app.UtilsApp;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private Button btnPerguntar;
    private TextView tvExibirRespota;
    private TextView tvTitulo;
    private EditText edtPergunta;
    private ImageButton btnDelete;
    public static final int REQUEST_CODE = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Activity de Perguntas");
        }


        btnPerguntar    = findViewById(R.id.btnPerguntar);
        tvExibirRespota = findViewById(R.id.tvExibirResposta);
        edtPergunta     = findViewById(R.id.edtPergunta);
        btnDelete       = findViewById(R.id.btnDelete);
        tvTitulo        = findViewById(R.id.tvTitulo);
        tvTitulo.setVisibility(View.INVISIBLE);


        btnPerguntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtPergunta.getText().toString().isEmpty()){
                    Intent irParaOutraActivity = new Intent(MainActivity.this, RespostaActivity.class);

                    String conteudo = edtPergunta.getText().toString();
                    irParaOutraActivity.putExtra("Pergunta", conteudo);

                    startActivityForResult(irParaOutraActivity, REQUEST_CODE);


                } else {
                    Toast.makeText(MainActivity.this, "Insira uma pergunta", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPergunta.setText("");
                tvExibirRespota.setText("");
            }
        });

    UtilsApp utilsApp = new UtilsApp();
    Log.d(TAG, "Valor convertido de tipos primitivos float p/ int: " + utilsApp.convertToInt(5.1987));

    byte b = -27;
    Log.d(TAG, "Valor convertido de tipos primitivos byte p/ int: " + utilsApp.convertToInt(b));

    long valorLong = 9223372036854775800L;
    Log.d(TAG, "Valor convertido de tipos primitivos long p/ int: " + utilsApp.convertToInt(valorLong));




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)){

            String returnString = data.getExtras().getString("returnData");

            if(returnString != null){
                if(!returnString.isEmpty()){
                    tvTitulo.setVisibility(View.VISIBLE);
                    //edtPergunta.setText(returnString);

                }
            }

            tvExibirRespota.setText(returnString);
        }
    }
}