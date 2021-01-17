package hr.dominik.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c){
        this.context = c;
    }

    public DBManager open() throws SQLException{
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public void insert(String name,String desc){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT,name);
        contentValues.put(DatabaseHelper.DESC,desc);
        database.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }

}
