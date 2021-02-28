package sv.edu.udb.menudeejercicios;

public class Empleado {
    private boolean isValidate;

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

}
