package com.example.carlosgonzalezramos.agenda.contact.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosgonzalezramos.agenda.database.DataBase;
import com.example.carlosgonzalezramos.agenda.database.DataBaseContentProvider;
import com.example.carlosgonzalezramos.agenda.contact.model.Contact;

import java.util.ArrayList;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public class ContactDAO extends DataBaseContentProvider<Contact>
    implements IContactDAO, IContactSchema {


    @Override
    protected Contact cursorToEntity(Cursor cursor) {
        int index;
        Contact contact = new Contact();
        if(cursor == null) return contact;

        if((index = cursor.getColumnIndex(ID)) >= 0)
            contact.setId(cursor.getInt(index));
        if((index = cursor.getColumnIndex(NAME)) >= 0)
            contact.setName(cursor.getString(index));
        if((index = cursor.getColumnIndex(BIRTHDAY)) >= 0)
            contact.setBirthday(cursor.getString(index));
        if((index = cursor.getColumnIndex(PHONE)) >= 0)
            contact.setPhone(cursor.getString(index));

        return contact;
    }

    public ContactDAO(Context context) {
        super(DataBase.getInstance(context));
    }


    @Override
    public Contact fetchContact(int id) {
        final String selectionArgs[] = { String.valueOf(id) };
        final String selection = ID + " = ?";
        Contact contact = new Contact();
        Cursor cursor = super.query(TABLE, ALL_COLUMNS , selection,
                selectionArgs, ID);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                contact = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return contact;
    }

    @Override
    public ArrayList<Contact> fetchAllContacts() {
        ArrayList<Contact> contactList = new ArrayList<>();
        Cursor cursor = super.query(TABLE, ALL_COLUMNS, null,
                null, ID);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Contact contact = cursorToEntity(cursor);
                contactList.add(contact);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return contactList;
    }

    @Override
    public boolean addContact(Contact contact) {
        return super.insert(TABLE, getContentValues(contact)) > 0;
    }

    @Override
    public boolean deleteContact(int id) {
        return super.delete(TABLE, ID + " = ? ", new String[]{String.valueOf(id)}) > 0;
    }

    @Override
    public boolean updateContact(Contact contact) {
        return super.update
                (TABLE, getContentValues(contact)
                        , ID + "= ?", new String[]{String.valueOf(contact.getId())}) > 0;
    }

    private ContentValues getContentValues(Contact contact){
        ContentValues cv = new ContentValues();
//        cv.put(ID, contact.getId());
        cv.put(NAME, contact.getName());
        cv.put(BIRTHDAY, contact.getBirthday());
        cv.put(PHONE, contact.getPhone());
        return cv;
    }

}
