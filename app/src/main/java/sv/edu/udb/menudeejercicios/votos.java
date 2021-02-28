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
        try { //Siempre usar un try catch para validar campos vacíos desde la obtención de datos

            String VotosText = StringVotos.getText().toString(); //Obtenemos la cadena de votos

            if( VotosText.isEmpty() ) {
                Toast notificacion = Toast.makeText(this,"¡Datos vacíos! Debe ingresar una serie de votos de la forma: 1,2,1,4,4,3",Toast.LENGTH_LONG);
                notificacion.show();
            } else {

                votosArray = VotosText.split(",");   //Separamos cada valor del voto de la cadena en una posicion diferente del array por cada ,
                int n = votosArray.length; //cantidad de votos

                for(int i=0; i<n; i++){
                    if( votosArray[i].contains("1") ) {
                        VotosCandidato1++;
                    } else if( votosArray[i].contains("2") ) {
                        VotosCandidato2++;
                    } else if( votosArray[i].contains("3") ) {
                        VotosCandidato3++;
                    } else if( votosArray[i].contains("4") ) {
                        VotosCandidato4++;
                    } else {
                        VotosNulos++;  //Si ingresa un numero que no sea del 1-4
                    }
                }

                if( VotosNulos > 0 ){
                    Toast notificacion = Toast.makeText(this,"Se anularon " + VotosNulos + " votos",Toast.LENGTH_LONG);
                    notificacion.show();
                }

                tvVotosCandidato1.setText(VotosCandidato1);
                tvVotosCandidato2.setText(VotosCandidato2);
                tvVotosCandidato3.setText(VotosCandidato3);
                tvVotosCandidato4.setText(VotosCandidato4);
                tvVotosNulos.setText(VotosNulos);
            }

        } catch (Exception e ){
            Toast notificacion2 = Toast.makeText(this, "Ocurrió un error, vuelva a intentarlo", Toast.LENGTH_SHORT);
            notificacion2.show();
        }
    }
}