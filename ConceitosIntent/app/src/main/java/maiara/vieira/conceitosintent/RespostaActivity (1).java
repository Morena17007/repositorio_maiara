package katia.nienow.projetoconceitosintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RespostaActivity extends AppCompatActivity {
    private Button btnResposta;
    private TextView tvOutroTexto;
    private EditText edtDigiteOutraResposta;
    private ImageButton imgbLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        btnResposta            = findViewById(R.id.btnResposta);
        tvOutroTexto           = findViewById(R.id.tvOutroTexto);
        edtDigiteOutraResposta = findViewById(R.id.edtDigiteOutraResposta);
        imgbLimpar             = findViewById(R.id.imgbLimpar);

        btnResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtDigiteOutraResposta.getText().toString().isEmpty()) {
                } else {
                    Toast.makeText(RespostaActivity.this, "Faça outra pergunta!", Toast.LENGTH_SHORT).show();
                    Intent irParaOutraActivity = new Intent(RespostaActivity.this, RespostaActivity.class);
                    startActivity(irParaOutraActivity);
                }
            }
        });
    }
}