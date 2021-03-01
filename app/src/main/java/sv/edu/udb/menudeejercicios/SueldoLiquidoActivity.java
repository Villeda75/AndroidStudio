package sv.edu.udb.menudeejercicios;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SueldoLiquidoActivity extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621

    private EditText txtNombresEmpleado1;
    private EditText txtApellidosEmpleado1;
    private EditText txtDescuentoISS1;
    private EditText txtDescuentoAFP1;
    private EditText txtDescuentoRenta1;
    private EditText txtSueldoLiquido1;

    private EditText txtNombresEmpleado2;
    private EditText txtApellidosEmpleado2;

    private EditText txtNombresEmpleado3;
    private EditText txtApellidosEmpleado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sueldo_liquido);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        //toolBarLayout.setTitle(getTitle());

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {

        //});

        txtNombresEmpleado1 = (EditText)findViewById(R.id.txtNombresEmpleado1);
        txtApellidosEmpleado1 = (EditText)findViewById(R.id.txtApellidosEmpleado1);

        txtNombresEmpleado2 = (EditText)findViewById(R.id.txtNombresEmpleado2);
        txtApellidosEmpleado2 = (EditText)findViewById(R.id.txtApellidosEmpleado2);

        txtNombresEmpleado3 = (EditText)findViewById(R.id.txtNombresEmpleado3);
        txtApellidosEmpleado3 = (EditText)findViewById(R.id.txtApellidosEmpleado3);

        ResultadoSalarios(); //Se imprimen los resultados en pantalla
    }

    public void ResultadoSalarios() {
        //Clase del empleado para registro de datos y validaciones
        Empleado empleado = new Empleado();
        String[][] EmpleadosData = empleado.GetData();

        txtNombresEmpleado1.setText( String.valueOf(EmpleadosData[0][0]) );
        txtApellidosEmpleado1.setText( String.valueOf(EmpleadosData[0][1]));

        txtNombresEmpleado2.setText( empleado.datosEmpleados[1][0] );
        txtApellidosEmpleado2.setText( empleado.datosEmpleados[1][1]);

        txtNombresEmpleado3.setText( empleado.datosEmpleados[2][0] );
        txtApellidosEmpleado3.setText( empleado.datosEmpleados[2][1]);

    }
}