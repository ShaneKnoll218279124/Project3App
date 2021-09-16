package za.ac.cput.project3safeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, "SafeAppDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createUserTable();
//        createCircleTable();
//        createEmergencyServicesTable();
//        createLiveLocationTable();
//        createFakeCallTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Nothing to implement here
    }

    // =============== User Table ==================================================================
    private static final String USER_TABLE_NAME = "user_table";
    private static final String ID = "ID";
    private static final String USER_FIRST_NAME = "firstName";
    private static final String USER_LAST_NAME = "lastName";
    private static final String USER_CELL_NUM = "number";

    public void createUserTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String createTable = "CREATE TABLE " + USER_TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_FIRST_NAME + " TEXT," +
                USER_LAST_NAME + " TEXT," +
                USER_CELL_NUM + " TEXT)";
        db.execSQL(createTable);
    }

    public void dropTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
    }

    public boolean addUser(String fName, String lName, String number) {
        dropTable();
        createUserTable();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_FIRST_NAME, fName);
        contentValues.put(USER_LAST_NAME, lName);
        contentValues.put(USER_CELL_NUM, number);

        Log.d(TAG, "adduser: Adding " + fName + " " + lName + " " + number + " to " + USER_TABLE_NAME);
        long result = db.insert(USER_TABLE_NAME, null, contentValues);

        // -1 if not inserted correctly
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateUser(String fName, String lName, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_FIRST_NAME, fName);
        contentValues.put(USER_LAST_NAME, lName);
        contentValues.put(USER_CELL_NUM, number);

        Log.d(TAG, "updateUser: Updating " + fName + " " + lName + " " + number + " to " + USER_TABLE_NAME);
        long result = db.update(USER_TABLE_NAME, contentValues, "id = ? ", new String[] { Integer.toString(1) } );

        // -1 if not inserted correctly
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor fetchUserDetails() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where id = 1", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    // =============== End User Table ==============================================================

    // =============== Emergency Services Table ====================================================

    // =============== End Emergency Services Table ================================================

    // =============== Circle Table ================================================================

    // =============== End Circle Table ============================================================

    // =============== Live Location Table =========================================================

    // =============== End Live Location Table =====================================================

    // =============== Fake Call Table =============================================================

    // =============== End Fake Call Table =========================================================
}
