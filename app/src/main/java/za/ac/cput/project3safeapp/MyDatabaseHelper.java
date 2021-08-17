package za.ac.cput.project3safeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "DatabaseLibrary.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "LoginLibrary";
    private static final String COLUMN_ID = "_id";

    private static final String COLUMN_NAME = "Username ";
    private static final String COLUMN_SURNAME = "Surname ";
    private static final String COLUMN_NUMBER = "Number ";

    public MyDatabaseHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_NAME +
                " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT," +
                COLUMN_SURNAME + " TEXT," +
                COLUMN_NUMBER + " INTEGER(10)" + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addLogin(String Username, String Surname, int Number){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, Username);
        cv.put(COLUMN_SURNAME, Surname);
        cv.put(COLUMN_NUMBER, Number);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show(); }
    }
}
