package za.ac.cput.project3safeapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper myDB;
    ArrayList<String> _id, Username, Surname, Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Database ->
        myDB = new MyDatabaseHelper(MainActivity.this);
        _id = new ArrayList<>();
        Username = new ArrayList<>();
        Surname = new ArrayList<>();
        Number = new ArrayList<>();

        storedArrayData();
        //End ->

        ImageButton settingsBtn = (ImageButton) findViewById(R.id.btnSetting);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        Button sosButton = (Button) findViewById(R.id.btnSos);
        sosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConfirmSosActivity.class);
                startActivity(intent);
            }
        });

        Button fakeCallButton = (Button) findViewById(R.id.btnFakeCall);
        fakeCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FakeCallActivity.class);
                startActivity(intent);
            }
        });

        Button liveLocationButton = (Button) findViewById(R.id.btnLiveLocation);
        liveLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LiveLocationActivity.class);
                startActivity(intent);
            }
        });

        Button emergencyServButton = (Button) findViewById(R.id.btnEmerServices);
        emergencyServButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmergencyServicesActivity.class);
                startActivity(intent);
            }
        });
    }

    //Database
    void storedArrayData(){
        Cursor cursor = myDB.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data.", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()){
                _id.add(cursor.getString(0));
                Username.add(cursor.getString(1));
                Surname.add(cursor.getString(2));
                Number.add(cursor.getString(3));
            }
        }
    }

    @Override
    public void onBackPressed() {
    }


}