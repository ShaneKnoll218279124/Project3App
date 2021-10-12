package za.ac.cput.project3safeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmSosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_sos);

        Button confirmSos = (Button) findViewById(R.id.btnConfirmSos);
        confirmSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(ConfirmSosActivity.this, "Help is on the way", Toast.LENGTH_LONG).show();
            }
        });

        Button cancelSos = (Button) findViewById(R.id.btnSosCancel);
        cancelSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(ConfirmSosActivity.this, "You canceled the SOS", Toast.LENGTH_LONG).show();
            }
        });
    }
}