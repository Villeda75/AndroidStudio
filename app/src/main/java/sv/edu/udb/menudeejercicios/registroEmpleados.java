package sv.edu.udb.menudeejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class registroEmpleados extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621

    private EditText Horas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleados);

        Horas = (EditText)findViewById(R.id.txtHoras);
    }

    public void Siguiente (View v) {

        try {
            int Horas = 2;
            Toast notificacion1 = null;

            Empleado empleado = new Empleado();
            boolean isValidate = empleado.validarHoras( Horas );

            if( isValidate ){
                //notificacion1 = Toast.makeText(this,"Las horas deben ser mayor a cero ( Horas > 0 )",Toast.LENGTH_LONG);
                Intent GoNext = new Intent(this, SueldoLiquidoActivity.class);
                startActivity(GoNext);

            } else {
                notificacion1 = Toast.makeText(this,"Las horas deben ser mayor a cero ( Horas > 0 )",Toast.LENGTH_LONG);
            }
            notificacion1.show();

        } catch (Exception e ){
            Toast.makeText(getApplicationContext(), "Todos los campos obligatorios", Toast.LENGTH_SHORT).show();
        }

    }

}