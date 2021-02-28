package sv.edu.udb.menudeejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class ecuacionCuadratica extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621

    private EditText a;
    private EditText b;
    private EditText c;
    private TextView tvX1;
    private TextView tvX2;
    private FrameLayout frameResults;
    Double X1 = 0.0 , X2 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion_cuadratica);


        a = (EditText)findViewById(R.id.valueA);
        b = (EditText)findViewById(R.id.valueB);
        c = (EditText)findViewById(R.id.valueC);
        tvX1 = (TextView)findViewById(R.id.tvX1);
        tvX2 = (TextView)findViewById(R.id.tvX2);
        frameResults = (FrameLayout)findViewById(R.id.frameResults);

    }

    public void ResultadosActividad (View v) {

        //Comenzamos con las validaciones

    }
}