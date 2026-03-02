package edu.unipiloto.constraint_layaout;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MailActivity extends AppCompatActivity {

    EditText etTo, etSubject, etMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_activity);

        etTo = findViewById(R.id.etTo);
        etSubject = findViewById(R.id.etSubject);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {

            String to = etTo.getText().toString().trim();
            String subject = etSubject.getText().toString().trim();
            String message = etMessage.getText().toString().trim();

            if(to.isEmpty() || subject.isEmpty() || message.isEmpty()){
                Toast.makeText(this,
                        "Complete todos los campos",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);

            startActivity(Intent.createChooser(intent, "Enviar correo..."));
        });
    }
}