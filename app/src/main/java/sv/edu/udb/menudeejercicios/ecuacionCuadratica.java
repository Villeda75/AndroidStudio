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
        try {
            //Siempre usar un try catch para validar campos vacíos desde la obtención de datos

            Double A = Double.valueOf(a.getText().toString());
            Double B = Double.valueOf(b.getText().toString());
            Double C = Double.valueOf(c.getText().toString());

            if( A == 0 ){ //No se puede dividir entre cero

                Toast notificacion = Toast.makeText(this,"No se puede dividir entre 0. ( a > 0 )",Toast.LENGTH_LONG);
                notificacion.show();

                //Por si no ve el Toast
                tvX1.setText("No se puede dividir entre 0. ( A > 0 )");

            } else {

                if ( B == 0 && C == 0 ) {  // 0 dividido entre cualquier valor de A será igual a cero (0/1)=0
                    X1 = 0.0;
                    X2 = 0.0;

                } else {  //Se calculan las raices
                    Double raiz1 = Math.sqrt( ( B*B - 4*A*C ) );
                    X1 = (-(B)+raiz1)/(2*A);
                    X2 = (-(B)-raiz1)/(2*A);
                }

                if( X1.toString() == "NaN" || X2.toString() == "NaN") {   //Si las raices son imaginarias mostramos mensaje
                    tvX2.setVisibility(View.INVISIBLE);
                    tvX1.setText("Las soluciones X1 y X2 son imaginarias");

                } else {
                    tvX2.setVisibility(View.VISIBLE);
                    tvX1.setText("X1 = " +X1);
                    tvX2.setText("X2 = " +X2);
                }

                frameResults.setVisibility(View.VISIBLE);
            }

        } catch (Exception e ){
            Toast.makeText(getApplicationContext(), "No se permiten campos vacíos", Toast.LENGTH_SHORT).show();
            tvX2.setVisibility(View.INVISIBLE); //Se muestran solamente cuando el frame ya está visible.
            tvX1.setText("No se permiten campos vacíos");
        }
    }
}