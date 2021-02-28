package sv.edu.udb.menudeejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class votos extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621

    private TextView tvVotosCandidato1;
    private TextView tvVotosCandidato2;
    private TextView tvVotosCandidato3;
    private TextView tvVotosCandidato4;
    private  TextView tvVotosNulos;
    private EditText StringVotos;
    private FrameLayout frameResultados;
    //Contadores de votos
    int VotosCandidato1 = 0;
    int VotosCandidato2 = 0;
    int VotosCandidato3 = 0;
    int VotosCandidato4 = 0;
    int VotosNulos = 0;
    String[] votosArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votos);

        StringVotos = (EditText)findViewById(R.id.StringVotos);
        tvVotosCandidato1 = (TextView)findViewById(R.id.tvVotosCandidato1);
        tvVotosCandidato2 = (TextView)findViewById(R.id.tvVotosCandidato2);
        tvVotosCandidato3 = (TextView)findViewById(R.id.tvVotosCandidato3);
        tvVotosCandidato4 = (TextView)findViewById(R.id.tvVotosCandidato4);
        tvVotosNulos = (TextView)findViewById(R.id.tvVotosNulos);
        frameResultados = (FrameLayout)findViewById(R.id.frameResultados);
    }

    public void ContarVotos (View v) {

        //Inicio
    }
}