package vieira.maiara.uno.conceitofragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextoFragment extends Fragment {

    private TextView tvTextoFormatado;

    public TextoFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_texto, container, false);

        tvTextoFormatado = view.findViewById(R.id.tvTextoFormatado);
        return view;
    }

    public void trocarPropriedadesDoTexto(int tamanhofonte, String texto) {
        tvTextoFormatado.setTextSize(tamanhofonte);
        tvTextoFormatado.setText(texto);

    }
}