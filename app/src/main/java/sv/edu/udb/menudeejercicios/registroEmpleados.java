package sv.edu.udb.menudeejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import java.util.ArrayList;

public class registroEmpleados extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621

    private EditText txtHoras;
    private TextView tvRegistrarEmpleado;
    public int idEmpleado = 0;
    private  EditText txtNombres;
    private EditText txtApellidos;
    private EditText txtCargo;
    //Clase del empleado para validaciones
    Empleado empleado = new Empleado();
    public ArrayList<String> DataEmpleados = new ArrayList<String>();
    Toast notificacion1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleados);

        txtNombres = (EditText)findViewById(R.id.txtNombres);
        txtApellidos = (EditText)findViewById(R.id.txtApellidos);
        txtCargo = (EditText)findViewById(R.id.txtCargo);
        txtHoras = (EditText)findViewById(R.id.txtHoras);
        tvRegistrarEmpleado = (TextView)findViewById(R.id.tvRegistrarEmpleado);
    }

    public void Siguiente (View v) {

        try {
            tvRegistrarEmpleado.setText("Empleado " + (idEmpleado+1) );

            //Captura de datos
            String Nombres = txtNombres.getText().toString();
            String Apellidos = txtApellidos.getText().toString();
            String Cargo = txtCargo.getText().toString();
            String Horas = txtHoras.getText().toString();

            boolean isValidate = empleado.validarHoras( Integer.parseInt(Horas) );

            if( isValidate ){
                //Guardamos los datos de los empleados
                DataEmpleados.add(Nombres.toString());
                DataEmpleados.add(Apellidos.toString());
                DataEmpleados.add(Cargo.toString());
                DataEmpleados.add(Horas.toString());

                notificacion1 = Toast.makeText(this,"Empleado " + (idEmpleado+1) +" registrado exitosamente",Toast.LENGTH_SHORT);

                //Aumentamos el idEmpleado
                idEmpleado++;

                //Cuando el idEmpleado llega a 3, se reinicia el contador y se redirige al Activity de Resultados
                if (idEmpleado == 3) {
                    idEmpleado = 0;
                    Intent i = new Intent(this, SueldoLiquidoActivity.class);
                    i.putStringArrayListExtra("Data", DataEmpleados); //Enviamos los datos de todos los empleados
                    startActivity(i);

                } else {
                    //Actualizamos el Titulo del empleado a registrar
                    tvRegistrarEmpleado.setText("Empleado " + (idEmpleado+1) );

                    //Limpiamos los EditText
                    txtNombres.setText("");
                    txtApellidos.setText("");
                    txtCargo.setText("");
                    txtHoras.setText("");
                }

            } else {
                notificacion1 = Toast.makeText(this,"Las horas deben ser mayor a cero ( Horas > 0 )",Toast.LENGTH_LONG);
            }
            notificacion1.show();

        } catch (Exception e ){
            Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }

    }

}