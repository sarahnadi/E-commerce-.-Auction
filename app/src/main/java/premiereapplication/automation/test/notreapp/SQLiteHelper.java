package premiereapplication.automation.test.notreapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Sarah on 14/06/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData (String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }

    public void insertData(String name, String price, String date,String nom_vendeur,String desc,byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO PRODUCT VALUES (NULL, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindString(3, date);
        statement.bindString(4, nom_vendeur);
        statement.bindString(5, desc);
        statement.bindBlob(6, image);

        statement.executeInsert();

    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

