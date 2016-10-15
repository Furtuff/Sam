package fr.axa.hackathon.axalink.database;

/**
 * Created by tuffery on 15/10/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.axa.hackathon.axalink.model.Line;



public class DBHandler extends SQLiteOpenHelper implements Serializable {

    public static final String DBNAME = "database.sqlite";
    public static final String DBLOCATION = "/data/data/fr.axa.hackathon.axalink/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DBHandler(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    // get all database
    public List<Line> getListLine() {

        Line contenant = null;
        ArrayList<Line> contenantList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM database_axa", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            contenant = new Line(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            contenantList.add(contenant);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return contenantList;
    }
}