package edu.unipiloto.constraint_layaout;

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

            if(empleado.isEmpty() || placa.isEmpty() || tipo.isEmpty() || cantidad.isEmpty()){
                Toast.makeText(this,
                        "Complete los campos obligatorios",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this,
                    "Solicitud registrada correctamente",
                    Toast.LENGTH_LONG).show();
        });
    }
}