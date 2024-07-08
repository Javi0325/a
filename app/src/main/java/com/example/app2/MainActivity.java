package com.example.app2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nombre,apellido,carnet;
    Spinner listaCursos;
    RadioButton rHombre,rMujer;
    CheckBox chNuevo,chRegular,chOtro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombre=findViewById(R.id.etNombre);
        apellido=findViewById(R.id.etApellidos);
        carnet=findViewById(R.id.etCarnet);

        chNuevo=findViewById(R.id.ckNuevo);
        chRegular=findViewById(R.id.ckRegular);
        chOtro=findViewById(R.id.ckOtro);

        rHombre=findViewById(R.id.rbHombre);
        rMujer=findViewById(R.id.rbMujer);

        listaCursos=findViewById(R.id.spCarrera);

        }
        public void DatosFormulario(View v){
            Toast.makeText(this, "Cosa", Toast.LENGTH_SHORT).show();
        StringBuilder mensaje=new StringBuilder();
        mensaje.append("Nombre: ").append(nombre.getText().toString()).append("\n");
        mensaje.append("Apellido: ").append(apellido.getText().toString()).append("\n");
        mensaje.append("Carnet: ").append(carnet.getText().toString()).append("\n");

        /*String mensaje="";
        mensaje+="Nombre: "+nombre.getText().toString();
        mensaje+="Apellidos: "+apellido.getText().toString();
        mensaje+="CI: "+carnet.getText().toString();
        mensaje+="Tipo de Estudiante: ";*/
     mensaje.append("Tipo de Estudiante: ");
     if (chNuevo.isChecked())
     {
         mensaje.append(chNuevo.getText().toString()).append("");
         //mensaje+=chNuevo.getText().toString();
     }
     if (chRegular.isChecked())
     {
         mensaje.append(chRegular.getText().toString()).append("");
         //mensaje+=chRegular.getText().toString();
     }
     if (chOtro.isChecked())
     {
         mensaje.append(chOtro.getText().toString()).append("");
         //mensaje+=chOtro.getText().toString();
     }
     mensaje.append("\n");
     mensaje.append("Sexo: ");
     if(rHombre.isChecked()){
         mensaje.append(rHombre.getText().toString());
     }
     if(rMujer.isChecked()){
         mensaje.append(rMujer.getText().toString());
     }
     mensaje.append("\n");
     mensaje.append("Carrera: ");
     mensaje.append(listaCursos.getSelectedItem().toString());

     //Ventana tipo alert para mensaje completo
     new AlertDialog.Builder(this).setTitle("Datos Estudiante")
             .setMessage(mensaje).setPositiveButton("OK",null)
             .show();
    //Comentario nuevo
    }
}