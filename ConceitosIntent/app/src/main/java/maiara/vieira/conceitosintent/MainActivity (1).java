package katia.nienow.projetoconceitosintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 5;
    private TextView tvTextoVisível;
    private Button btnDontTouch;
    private EditText edtDigiteUmaPergunta;
    private ImageButton imgClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTextoVisível       = findViewById(R.id.tvTextoVisível);
        btnDontTouch         = findViewById(R.id.btnDontTouch);
        edtDigiteUmaPergunta = findViewById(R.id.edtDigiteUmaPergunta);
        imgClear             = findViewById(R.id.imgbClear);

        Bundle extras = getIntent().getExtras();
        String pergunta = "";
        if(extras!=null) {
            pergunta = extras.getString("Pergunta");
            tvTextoVisível.setText(pergunta);

        }

        btnDontTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtDigiteUmaPergunta.getText().toString().isEmpty()){
                    Intent intent = new Intent(MainActivity.this, RespostaActivity.class);

                    String myString = edtDigiteUmaPergunta.getText().toString();
                    intent.putExtra("Pergunta", myString);

                    startActivityForResult(intent, REQUEST_CODE);

                } else {
                    Toast.makeText(MainActivity.this, "Faça uma pergunta!", Toast.LENGTH_SHORT).show();
                    /*Intent irParaOutraActivity = new Intent(MainActivity.this, RespostaActivity.class);
                    startActivity(irParaOutraActivity);*/
                }
            }
        });
    }
}