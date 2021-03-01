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

    //votos por candidato
    private TextView tvVotosCandidato1;
    private TextView tvVotosCandidato2;
    private TextView tvVotosCandidato3;
    private TextView tvVotosCandidato4;

    //porcentajes por candidato
    private TextView tvPtjeCand1;
    private TextView tvPtjeCand2;
    private TextView tvPtjeCand3;
    private TextView tvPtjeCand4;

    //Totales de votos y porcentajes
    private  TextView tvVotosNulos;
    private  TextView tvTotalVotos;
    private  TextView tvTotalPrctje;

    //Entrada de votos
    private EditText StringVotos;
    private FrameLayout frameResultados;

    String[] votosArray; //Array para votos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votos);

        StringVotos = (EditText)findViewById(R.id.StringVotos);
        tvVotosCandidato1 = (TextView)findViewById(R.id.tvVotosCandidato1);
        tvVotosCandidato2 = (TextView)findViewById(R.id.tvVotosCandidato2);
        tvVotosCandidato3 = (TextView)findViewById(R.id.tvVotosCandidato3);
        tvVotosCandidato4 = (TextView)findViewById(R.id.tvVotosCandidato4);

        tvPtjeCand1 = (TextView)findViewById(R.id.tvPtjeCand1);
        tvPtjeCand2 = (TextView)findViewById(R.id.tvPtjeCand2);
        tvPtjeCand3 = (TextView)findViewById(R.id.tvPtjeCand3);
        tvPtjeCand4 = (TextView)findViewById(R.id.tvPtjeCand4);

        tvVotosNulos = (TextView)findViewById(R.id.tvVotosNulos);
        tvTotalVotos = (TextView)findViewById(R.id.tvTotalVotos);
        tvTotalPrctje = (TextView)findViewById(R.id.tvTotalPrctje);

        frameResultados = (FrameLayout)findViewById(R.id.frameResultados);
    }

    public void ContarVotos (View v) {

        try {
            String VotosText = StringVotos.getText().toString(); //Obtenemos la cadena de votos

            if( VotosText.isEmpty() ) {
                Toast notificacion = Toast.makeText(this,"¡Datos vacíos! Debe ingresar una serie de votos de la forma: 1,2,1,4,4,3",Toast.LENGTH_SHORT);
                notificacion.show();
            } else {

                //Contadores de votos
                int VotosCandidato1 = 0;
                int VotosCandidato2 = 0;
                int VotosCandidato3 = 0;
                int VotosCandidato4 = 0;
                int VotosNulos = 0;
                int TotalVotosValidos = 0;

                //Contadores de porcentajes
                Double PorcntjeCandto1 = 0.00;
                Double PorcntjeCandto2 = 0.00;
                Double PorcntjeCandto3 = 0.00;
                Double PorcntjeCandto4 = 0.00;
                Double totalPorcentaje = 0.00;

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
                        VotosNulos++;  //Si se ingresa un numero que no sea del 1-4
                    }
                }

                if( VotosNulos > 0 ){
                    Toast notificacion = Toast.makeText(this,"Votos anulados: " + VotosNulos + "",Toast.LENGTH_LONG);
                    notificacion.show();
                }

                //TotalVotosValidos
                //Aclaración: Los votos nulos no se toman en cuenta para el calculo del total de votos y porcentajes del sistema.
                //Los votos nulos solo es para saber cuantos votos se descartaron (no validos)
                TotalVotosValidos = VotosCandidato1 + VotosCandidato2 + VotosCandidato3 + VotosCandidato4;

                if( TotalVotosValidos > 0 ) {
                    //Calculo de porcentajes por candidato
                    PorcntjeCandto1 = Math.round(  ((VotosCandidato1*100)/TotalVotosValidos) *100.0)/100.0;
                    PorcntjeCandto2 = Math.round(  ((VotosCandidato2*100)/TotalVotosValidos) *100.0)/100.0;
                    PorcntjeCandto3 = Math.round(  ((VotosCandidato3*100)/TotalVotosValidos) *100.0)/100.0;
                    PorcntjeCandto4 = Math.round(  ((VotosCandidato4*100)/TotalVotosValidos) *100.0)/100.0;
                    totalPorcentaje = PorcntjeCandto1 + PorcntjeCandto2 + PorcntjeCandto3 + PorcntjeCandto4;
                }

                //Impresión de datos
                tvVotosCandidato1.setText( String.valueOf(VotosCandidato1) );
                tvVotosCandidato2.setText( String.valueOf(VotosCandidato2) );
                tvVotosCandidato3.setText( String.valueOf(VotosCandidato3) );
                tvVotosCandidato4.setText( String.valueOf(VotosCandidato4) );

                tvPtjeCand1.setText( PorcntjeCandto1 + "%" );
                tvPtjeCand2.setText( PorcntjeCandto2 + "%" );
                tvPtjeCand3.setText( PorcntjeCandto3 + "%" );
                tvPtjeCand4.setText( PorcntjeCandto4 + "%" );

                tvVotosNulos.setText( "Votos Nulos: " + VotosNulos);
                tvTotalVotos.setText( String.valueOf(TotalVotosValidos));
                tvTotalPrctje.setText( totalPorcentaje + "%");
            }

        } catch (Exception e ){
            Toast notificacion2 = Toast.makeText(this, "Ocurrió un error, vuelva a intentarlo " +e.getMessage(), Toast.LENGTH_SHORT);
            notificacion2.show();
        }
    }
}