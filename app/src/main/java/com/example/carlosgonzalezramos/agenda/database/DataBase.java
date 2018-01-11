package com.example.carlosgonzalezramos.agenda.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carlosgonzalezramos.agenda.contact.data.dao.IContactSchema;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */
public class DataBase extends SQLiteOpenHelper {

    private static DataBase db ;
    private static final int VERSION = 1;
    private static final String NAME = "agenda.db";

    private DataBase(Context context) {
        super(context, NAME, null, VERSION);
    }

    public static SQLiteDatabase getInstance(Context context){
        return (db = (db != null ? db : new DataBase(context)))
                .getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(IContactSchema.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
