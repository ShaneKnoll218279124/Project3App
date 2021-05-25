package za.ac.cput.project3safeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText loginFirstName, loginLastName, loginPhoneNumber;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginFirstName = findViewById(R.id.editTextLoginFirstName);
        loginLastName = findViewById(R.id.editTextLoginLastName);
        loginPhoneNumber = findViewById(R.id.editTextLoginNumber);
        btnLogin = findViewById(R.id.btnLogin);

//        if (!(loginFirstName.getText().equals("")) && !(loginLastName.getText().equals("")) && !(loginPhoneNumber.getText().equals(""))) {
//            btnLogin.setVisibility(View.VISIBLE);
//        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}