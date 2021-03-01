package sv.edu.udb.menudeejercicios;

public class Empleado {
    private boolean isValidate;
    public String [][] datosEmpleados = new String[3][4];

    protected boolean validarHoras( int horas ){
        try {
            isValidate = false;

            if ( horas > 0 ) {
                isValidate = true;
            }

            return isValidate;

        } catch (Exception error){
            return isValidate;
        }
    }

    public boolean Save( String Nombres, String Apellidos, String Cargo, String Horas, int idEmpleado ){
        try {
                datosEmpleados[idEmpleado][0] = Nombres.toString();
                datosEmpleados[idEmpleado][1] = Apellidos.toString();
                datosEmpleados[idEmpleado][2] = Cargo.toString();
                datosEmpleados[idEmpleado][3] = Horas.toString();
                return true;

            } catch (Exception error){ return  false; }
    }

    public String[][] GetData() {
        String[][] datos = new String[1][2];
        datos[0][0] = "Josue";
        datos[0][1] = "Villeda";
        return datos;
    }

}
