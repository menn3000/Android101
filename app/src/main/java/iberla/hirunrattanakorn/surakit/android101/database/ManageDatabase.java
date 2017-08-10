package iberla.hirunrattanakorn.surakit.android101.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Menn on 10/8/2560.
 */

public class ManageDatabase {

    private Context context;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;


    public ManageDatabase(Context context) {
        this.context = context;
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();


    }// constructor

    public long addNewUserToSQLite(String strName, String strUser, String strPassword, String strPath) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",strName);
        contentValues.put("User",strUser);
        contentValues.put("Password",strPassword);
        contentValues.put("PathPicture",strPath);

        return sqLiteDatabase.insert("userTABLE", null,contentValues);

    }//addNewUserToSQLite




}// Main Class
