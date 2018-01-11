package com.example.carlosgonzalezramos.agenda.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public abstract class  DataBaseContentProvider<T>{
    public SQLiteDatabase mDb;

    public int delete(String tableName, String where,
                      String[] whereArgs) {
        return mDb.delete(tableName, where, whereArgs);
    }

    public long insert(String tableName, ContentValues values) {
        return mDb.insert(tableName, null, values);
    }

    protected abstract T cursorToEntity(Cursor cursor);

    public DataBaseContentProvider(SQLiteDatabase db) {
        this.mDb = db;
    }

    public Cursor query(String tableName, String[] columns,
                        String selection, String[] selectionArgs, String sortOrder) {

        final Cursor cursor = mDb.query(tableName, columns,
                selection, selectionArgs, null, null, sortOrder);

        return cursor;
    }

    public Cursor query(String tableName, String[] columns,
                        String selection, String[] selectionArgs, String sortOrder,
                        String limit) {

        return mDb.query(tableName, columns, selection,
                selectionArgs, null, null, sortOrder, limit);
    }

    public Cursor query(String tableName, String[] columns,
                        String selection, String[] selectionArgs, String groupBy,
                        String having, String orderBy, String limit) {

        return mDb.query(tableName, columns, selection,
                selectionArgs, groupBy, having, orderBy, limit);
    }

    public int update(String tableName, ContentValues values,
                      String where, String[] whereArgs) {
        return mDb.update(tableName, values, where,
                whereArgs);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return mDb.rawQuery(sql, selectionArgs);
    }
}
