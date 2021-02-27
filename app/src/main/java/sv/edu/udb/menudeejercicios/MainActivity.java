package sv.edu.udb.menudeejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Josué Villeda        VC170991
    // Chantell Alvarenga   AA170621

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void RedirectTo(View view){

        try {
            Intent i = null;

            switch (view.getId()){
                case R.id.btnExercise1:
                    i = new Intent(MainActivity.this, ecuacionCuadratica.class);
                    startActivity(i);
                    break;
                case R.id.btnExercise2: //i = new Intent(this, ecuacionCuadratica.class);
                    break;
                case R.id.btnExercise3: //i = new Intent(this, ecuacionCuadratica.class);
                    break;
            }

            //startActivity(i);

        } catch (Exception error) {
            Toast.makeText(getApplicationContext(), "Ocurrió un error inesperado...", Toast.LENGTH_SHORT).show();
        }
    }


}