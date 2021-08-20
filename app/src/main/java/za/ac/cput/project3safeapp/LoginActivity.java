package za.ac.cput.project3safeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(LoginActivity.this);
                myDB.addLogin(
                        loginFirstName.getText().toString().trim(),
                        loginLastName.getText().toString().trim(),
                        Integer.parseInt(loginPhoneNumber.getText().toString().trim() ) );
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}