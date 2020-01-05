package com.penta.angri3app;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PuntoStradaDatabase  extends SQLiteOpenHelper {

    private static final String DB_NAME = "puntostrada";
    private static int DB_VERSION = 1;

    public PuntoStradaDatabase(Context context) {
        super(context, DB_NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PUNTOSTRADA ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "MYSELF_PAST TEXT, "
                + "MYSELF_PRESENT TEXT , "
                + "MYSELF_FUTURE TEXT , "
                + "OTHERS_PAST TEXT , "
                + "OTHERS_PRESENT TEXT ,"
                + "OTHERS_FUTURE TEXT ,"
                + "WORLD_PAST TEXT ,"
                + "WORLD_PRESENT TEXT ,"
                + "WORLD_FUTURE TEXT ,"
                + "GOD_PAST TEXT ,"
                + "GOD_PRESENT TEXT ,"
                + "GOD_FUTURE TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
