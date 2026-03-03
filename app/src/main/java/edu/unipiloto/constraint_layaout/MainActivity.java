package edu.unipiloto.constraint_layaout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCorreo, btnSolicitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCorreo = findViewById(R.id.btnCorreo);
        btnSolicitud = findViewById(R.id.btnSolicitud);

        btnCorreo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MailActivity.class);
            startActivity(intent);
        });

        btnSolicitud.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FuelRequest.class);
            startActivity(intent);
        });
    }
}