package za.ac.cput.project3safeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class EmergencyServicesActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    private String ambNum, polNum, fireNum, nwNum;
    private static final int REQUEST_CALL = 1;
    private String btnPressed = "";

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
                btnPressed = "Ambulance";
                callAmbulance();
            }
        });

        Button btnPolice = (Button) findViewById(R.id.btnPolice);
        btnPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPressed = "Police";
                callPolice();
            }
        });

        Button btnFire = (Button) findViewById(R.id.btnFire);
        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPressed = "Fire";
                callFire();
            }
        });

        Button btnNeighbourWatch = (Button) findViewById(R.id.btnNeighbourWatch);
        btnNeighbourWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPressed = "Neighbourhood Watch";
                callNeighbourhoodWatch();
            }
        });
    }

    public void callAmbulance() {
        if (ActivityCompat.checkSelfPermission(EmergencyServicesActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EmergencyServicesActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + ambNum));
            startActivity(callIntent);
        }
    }

    public void callPolice() {
        if (ActivityCompat.checkSelfPermission(EmergencyServicesActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EmergencyServicesActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + polNum));
            startActivity(callIntent);
        }
    }

    public void callFire() {
        if (ActivityCompat.checkSelfPermission(EmergencyServicesActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EmergencyServicesActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + fireNum));
            startActivity(callIntent);
        }
    }

    public void callNeighbourhoodWatch() {
        if (ActivityCompat.checkSelfPermission(EmergencyServicesActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EmergencyServicesActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + nwNum));
            startActivity(callIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                switch (btnPressed) {
                    case "Ambulance":
                        callAmbulance();
                        break;
                    case "Police":
                        callPolice();
                        break;
                    case "Fire":
                        callFire();
                        break;
                    case "Neighbourhood Watch":
                        callNeighbourhoodWatch();
                }
            } else {
                Toast.makeText(this, "PERMISSION DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}