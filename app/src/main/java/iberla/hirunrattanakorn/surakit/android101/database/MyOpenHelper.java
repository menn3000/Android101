package iberla.hirunrattanakorn.surakit.android101.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Menn on 10/8/2560.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    //Middle man between Application and Root folder where DB is

    //Explicit
    private Context context;
    public static final String database_name = "menn.db";
    private static final int database_version = 1;
    private static final String database_table = "create table userTABLE (" +
            "id integer primary key," +
            "Name text, " +
            "User text," +
            "Password," +
            "PathPicture text);";



    public MyOpenHelper(Context context) {
        super(context,database_name,null,database_version);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // only fire on device if run first time
        // if no DB is created on the device
        sqLiteDatabase.execSQL(database_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}//Main Class
