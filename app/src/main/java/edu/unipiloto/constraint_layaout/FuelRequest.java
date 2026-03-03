package edu.unipiloto.constraint_layaout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FuelRequest extends AppCompatActivity {

    EditText etEmpleado, etPlaca, etTipo, etCantidad, etObservaciones;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_request);

        etEmpleado = findViewById(R.id.etEmpleado);
        etPlaca = findViewById(R.id.etPlaca);
        etTipo = findViewById(R.id.etTipo);
        etCantidad = findViewById(R.id.etCantidad);
        etObservaciones = findViewById(R.id.etObservaciones);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(v -> {

            String empleado = etEmpleado.getText().toString().trim();
            String placa = etPlaca.getText().toString().trim();
            String tipo = etTipo.getText().toString().trim();
            String cantidad = etCantidad.getText().toString().trim();
            String observaciones = etObservaciones.getText().toString().trim();

            if(empleado.isEmpty() || placa.isEmpty() || tipo.isEmpty() || cantidad.isEmpty()){
                Toast.makeText(this,
                        "Complete los campos obligatorios",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            EditText inputCorreo = new EditText(this);
            inputCorreo.setHint("Ingrese el correo destino");
            inputCorreo.setInputType(android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Enviar solicitud")
                    .setMessage("Ingrese el correo destino")
                    .setView(inputCorreo)
                    .setPositiveButton("Enviar", (dialog, which) -> {

                        String correo = inputCorreo.getText().toString().trim();

                        if(correo.isEmpty()){
                            Toast.makeText(this,
                                    "Debe ingresar un correo",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                        String subject = "Comprea de gasolina";

                        String body = "Empleado: " + empleado +
                                "\nPlaca: " + placa +
                                "\nTipo de combustible: " + tipo +
                                "\nCantidad: " + cantidad +
                                "\nObservaciones: " + observaciones;

                        Uri uri = Uri.parse("mailto:" + correo +
                                "?subject=" + Uri.encode(subject) +
                                "&body=" + Uri.encode(body));

                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(uri);
                        startActivity(intent);
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });
    }
}