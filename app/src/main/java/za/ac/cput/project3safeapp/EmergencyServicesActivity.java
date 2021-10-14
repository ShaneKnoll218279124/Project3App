package za.ac.cput.project3safeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class EmergencyServicesActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    private String ambNum, polNum, fireNum, nwNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_services);

        mDatabaseHelper = new DatabaseHelper(this);

        Cursor amb = mDatabaseHelper.fetchAmbulanceDetails();
        Cursor pol = mDatabaseHelper.fetchPoliceDetails();
        Cursor fir = mDatabaseHelper.fetchFireRescueDetails();
        Cursor nWa = mDatabaseHelper.fetchNeighbourhoodWatchDetails();

        ambNum = amb.getString(2);
        polNum = pol.getString(2);
        fireNum = fir.getString(2);
        nwNum = nWa.getString(2);

        ImageButton backBtn = (ImageButton) findViewById(R.id.btnBack);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnAmbulance = (Button) findViewById(R.id.btnAmbulance);
        btnAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+ ambNum));
                startActivity(callIntent);
            }
        });

        Button btnPolice = (Button) findViewById(R.id.btnPolice);
        btnPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+ polNum));
                startActivity(callIntent);
            }
        });

        Button btnFire = (Button) findViewById(R.id.btnFire);
        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+ fireNum));
                startActivity(callIntent);
            }
        });

        Button btnNeighbourWatch = (Button) findViewById(R.id.btnNeighbourWatch);
        btnNeighbourWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+ nwNum));
                startActivity(callIntent);
            }
        });
    }
}