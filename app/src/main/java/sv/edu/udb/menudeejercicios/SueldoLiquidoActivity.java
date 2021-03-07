package sv.edu.udb.menudeejercicios;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
    private EditText txtDescuentoISS2;
    private EditText txtDescuentoAFP2;
    private EditText txtDescuentoRenta2;
    private EditText txtSueldoLiquido2;

    private EditText txtNombresEmpleado3;
    private EditText txtApellidosEmpleado3;
    private EditText txtDescuentoISS3;
    private EditText txtDescuentoAFP3;
    private EditText txtDescuentoRenta3;
    private EditText txtSueldoLiquido3;

    private  TextView tvResultado;
    private  TextView tvSalarioMayor;
    private  TextView tvSalarioMenor;
    private  TextView tvSalariosMayores300;

    private Double[] SalariosLiquidos = new Double[3];
    private String[] EstadisticasEmpleados = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sueldo_liquido);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNombresEmpleado1 = (EditText)findViewById(R.id.txtNombresEmpleado1);
        txtApellidosEmpleado1 = (EditText)findViewById(R.id.txtApellidosEmpleado1);
        txtDescuentoISS1 = (EditText)findViewById(R.id.txtDescuentoISS1);
        txtDescuentoAFP1 = (EditText)findViewById(R.id.txtDescuentoAFP1);
        txtDescuentoRenta1 = (EditText)findViewById(R.id.txtDescuentoRenta1);
        txtSueldoLiquido1 = (EditText)findViewById(R.id.txtSueldoEmpleado1);

        txtNombresEmpleado2 = (EditText)findViewById(R.id.txtNombresEmpleado2);
        txtApellidosEmpleado2 = (EditText)findViewById(R.id.txtApellidosEmpleado2);
        txtDescuentoISS2 = (EditText)findViewById(R.id.txtDescuentoISS2);
        txtDescuentoAFP2 = (EditText)findViewById(R.id.txtDescuentoAFP2);
        txtDescuentoRenta2 = (EditText)findViewById(R.id.txtDescuentoRenta2);
        txtSueldoLiquido2 = (EditText)findViewById(R.id.txtSueldoEmpleado2);

        txtNombresEmpleado3 = (EditText)findViewById(R.id.txtNombresEmpleado3);
        txtApellidosEmpleado3 = (EditText)findViewById(R.id.txtApellidosEmpleado3);
        txtDescuentoISS3 = (EditText)findViewById(R.id.txtDescuentoISS3);
        txtDescuentoAFP3 = (EditText)findViewById(R.id.txtDescuentoAFP3);
        txtDescuentoRenta3 = (EditText)findViewById(R.id.txtDescuentoRenta3);
        txtSueldoLiquido3 = (EditText)findViewById(R.id.txtSueldoEmpleado3);

        tvResultado = (TextView)findViewById(R.id.tvResultado);
        tvSalarioMayor = (TextView)findViewById(R.id.tvSalarioMayor);
        tvSalarioMenor = (TextView)findViewById(R.id.tvSalarioMenor);
        tvSalariosMayores300 = (TextView)findViewById(R.id.tvSalariosMayores300);

        getData(); //Se reciben los datos y se imprimen los resultados en pantalla
    }

    public void getData() {
        //Obtenemos el arrayList con los datos de todos los empleados
        ArrayList<String> DataEmpleados;
        Bundle bundle = getIntent().getExtras();
        DataEmpleados = bundle.getStringArrayList("Data");
        //Mandamos el arrayList al metodo que hace los descuentos
        ResultadoSalarios( DataEmpleados );
    }

    public void ResultadoSalarios( ArrayList<String> EmpleadosData) {

        String CargoEmpleado1 = EmpleadosData.get(2).toUpperCase();
        String CargoEmpleado2 = EmpleadosData.get(6).toUpperCase();
        String CargoEmpleado3 = EmpleadosData.get(10).toUpperCase();

        int horasEmpleado1 = Integer.parseInt(EmpleadosData.get(3));
        int horasEmpleado2 = Integer.parseInt(EmpleadosData.get(7));
        int horasEmpleado3 = Integer.parseInt(EmpleadosData.get(11));

        //Validando la secuencia (1-Gerente, 2-Asistente, 3-Secretaria) no se aplica bono
        if ( CargoEmpleado1.equals("GERENTE") && CargoEmpleado2.equals("ASISTENTE") && CargoEmpleado3.equals("SECRETARIA") ) {

            Double[] SueldoConDescuentos = GetSueldoLiquido(horasEmpleado1);
            txtDescuentoISS1.setText("ISS: $" + SueldoConDescuentos[0].toString());
            txtDescuentoAFP1.setText("AFP: $" +SueldoConDescuentos[1].toString() );
            txtDescuentoRenta1.setText("Renta: $" +SueldoConDescuentos[2].toString());
            txtSueldoLiquido1.setText("Sueldo líquido: $" +SueldoConDescuentos[3].toString());
            SalariosLiquidos[0] = SueldoConDescuentos[3]; //Para obtener estadísticas

            SueldoConDescuentos = GetSueldoLiquido(horasEmpleado2);
            txtDescuentoISS2.setText("ISS: $" + SueldoConDescuentos[0].toString());
            txtDescuentoAFP2.setText("AFP: $" +SueldoConDescuentos[1].toString() );
            txtDescuentoRenta2.setText("Renta: $" +SueldoConDescuentos[2].toString());
            txtSueldoLiquido2.setText("Sueldo líquido: $" +SueldoConDescuentos[3].toString());
            SalariosLiquidos[1] = SueldoConDescuentos[3]; //Para obtener estadísticas

            SueldoConDescuentos = GetSueldoLiquido(horasEmpleado3);
            txtDescuentoISS3.setText("ISS: $" + SueldoConDescuentos[0].toString());
            txtDescuentoAFP3.setText("AFP: $" +SueldoConDescuentos[1].toString() );
            txtDescuentoRenta3.setText("Renta: $" +SueldoConDescuentos[2].toString());
            txtSueldoLiquido3.setText("Sueldo líquido: $" +SueldoConDescuentos[3].toString());
            SalariosLiquidos[2] = SueldoConDescuentos[3]; //Para obtener estadísticas

            tvResultado.setText("NO HAY BONO");

        } else {
            double SalarioConBonoAplicado = 0.00;

            Double[] SueldoConDescuentos = GetSueldoLiquido(horasEmpleado1);
            txtDescuentoISS1.setText("ISS: $" + SueldoConDescuentos[0].toString());
            txtDescuentoAFP1.setText("AFP: $" + SueldoConDescuentos[1].toString() );
            txtDescuentoRenta1.setText("Renta: $" + SueldoConDescuentos[2].toString());
            SalarioConBonoAplicado = GetSalarioConBono(CargoEmpleado1, SueldoConDescuentos[3]);
            SalarioConBonoAplicado = Math.round(  ( SalarioConBonoAplicado * 100.0)/100.0);
            txtSueldoLiquido1.setText("Sueldo líquido: $" + SalarioConBonoAplicado );
            SalariosLiquidos[0] = SalarioConBonoAplicado; //Para obtener estadísticas

            SueldoConDescuentos = GetSueldoLiquido(horasEmpleado2);
            txtDescuentoISS2.setText("ISS: $" + SueldoConDescuentos[0].toString());
            txtDescuentoAFP2.setText("AFP: $" + SueldoConDescuentos[1].toString() );
            txtDescuentoRenta2.setText("Renta: $" + SueldoConDescuentos[2].toString());
            SalarioConBonoAplicado = GetSalarioConBono(CargoEmpleado2, SueldoConDescuentos[3]);
            SalarioConBonoAplicado = Math.round(  ( SalarioConBonoAplicado * 100.0)/100.0);
            txtSueldoLiquido2.setText("Sueldo líquido: $" + SalarioConBonoAplicado );
            SalariosLiquidos[1] = SalarioConBonoAplicado; //Para obtener estadísticas

            SueldoConDescuentos = GetSueldoLiquido(horasEmpleado3);
            txtDescuentoISS3.setText("ISS: $" + SueldoConDescuentos[0].toString());
            txtDescuentoAFP3.setText("AFP: $" + SueldoConDescuentos[1].toString() );
            txtDescuentoRenta3.setText("Renta: $" + SueldoConDescuentos[2].toString());
            SalarioConBonoAplicado = GetSalarioConBono(CargoEmpleado3, SueldoConDescuentos[3]);
            SalarioConBonoAplicado = Math.round(  ( SalarioConBonoAplicado * 100.0)/100.0);
            txtSueldoLiquido3.setText("Sueldo líquido: $" + SalarioConBonoAplicado);
            SalariosLiquidos[2] = SalarioConBonoAplicado; //Para obtener estadísticas

            tvResultado.setText("BONOS APLICADOS");
        }

        txtNombresEmpleado1.setText( EmpleadosData.get(0).toUpperCase() );
        txtApellidosEmpleado1.setText( EmpleadosData.get(1).toUpperCase() );

        txtNombresEmpleado2.setText( EmpleadosData.get(4).toUpperCase() );
        txtApellidosEmpleado2.setText( EmpleadosData.get(5).toUpperCase() );

        txtNombresEmpleado3.setText( EmpleadosData.get(8).toUpperCase() );
        txtApellidosEmpleado3.setText( EmpleadosData.get(9).toUpperCase() );

        EstadisticasEmpleados = Estadisticas(SalariosLiquidos); //Para obtener estadísticas
        tvSalarioMayor.setText(EstadisticasEmpleados[0]);
        tvSalarioMenor.setText(EstadisticasEmpleados[1]);
        tvSalariosMayores300.setText(EstadisticasEmpleados[2]);
    }

    public Double[] GetSueldoLiquido(int horas){
        Double[] SueldoDescuentos = new Double[4];
        Double SueldoLiquido = 0.00,
                SueldoBase = 0.00,
                ISS = 0.00,
                AFP = 0.00,
                Renta = 0.00;

        if (horas <= 160) {
            SueldoBase = horas * 9.75;

        } else { //horas mayores a 160
            //Las primeras 160 deberán pagarse a $9.75 y las restantes a $11.50.
            Double parte1 = 160 * 9.75;
            Double parte2 = (horas - 160) * 11.50;
            SueldoBase = parte1 + parte2;
        }

        //Descuentos al sueldo base
        ISS = SueldoBase * 0.0525;
        AFP = SueldoBase * 0.0688;
        Renta = SueldoBase * 0.1;

        SueldoLiquido = (SueldoBase - ISS - AFP - Renta);

        SueldoDescuentos[0] = ISS;
        SueldoDescuentos[1] = AFP;
        SueldoDescuentos[2] = Renta;
        SueldoDescuentos[3] = SueldoLiquido;

        return SueldoDescuentos;
    }

    public Double GetSalarioConBono( String cargo, Double SueldoLiquido ){

        Double SueldoConBono = 0.00;

        if (cargo.equals("GERENTE")) {
            SueldoConBono = SueldoLiquido + ( SueldoLiquido * 0.1 );

        } else if (cargo.equals("ASISTENTE")) {
            SueldoConBono = SueldoLiquido + (SueldoLiquido * 0.05);

        } else if (cargo.equals("SECRETARIA")) {
            SueldoConBono = SueldoLiquido + ( SueldoLiquido * 0.03);

        } else { //Otros cargos
            SueldoConBono = SueldoLiquido + ( SueldoLiquido * 0.02);
        }

        return SueldoConBono;
    }

    public String[] Estadisticas( Double[] Salarios) {

        String[] estadisticas = new String[3];
        estadisticas[2] = "";
        Double mayor, menor;
        mayor = menor = Salarios[0];

        for (int i = 0; i < 3; i++) {
            if( Salarios[i] > mayor) {
                mayor = Salarios[i];
            }
            if( Salarios[i]<menor) {
                menor = Salarios[i];
            }
        }

        estadisticas[0] = "Salario Mayor: $" + String.valueOf(mayor);
        estadisticas[1] = "Salario Menor: $" + String.valueOf(menor);

        if ( Salarios[0] > 300 ) {
            estadisticas[2] = "Empleado 1, ";
        }
        if ( Salarios[1] > 300 ) {
            estadisticas[2] = estadisticas[2] + "Empleado 2, ";
        }
        if ( Salarios[2] > 300 ) {
            estadisticas[2] = estadisticas[2] + "Empleado 3, ";
        }

        estadisticas[2] = estadisticas[2] + "gana(n) más de $300";

        return estadisticas;
    }
}