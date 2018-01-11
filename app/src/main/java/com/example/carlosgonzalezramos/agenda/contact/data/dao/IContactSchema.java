package com.example.carlosgonzalezramos.agenda.contact.data.dao;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */
public interface IContactSchema {
    String TABLE    = "contact"  ;
    String ID       = "id"       ;
    String NAME     = "name"     ;
    String BIRTHDAY = "birthday" ;
    String PHONE    = "phone"    ;

    String[] ALL_COLUMNS = new String[]{ID,NAME,BIRTHDAY,PHONE};

    String CREATE_TABLE = String.format
            ( "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT)"
                    , TABLE
                    , ID
                    , NAME
                    , BIRTHDAY
                    , PHONE);

    String DROP_TABLE = String.format
            ( "DROP TABLE IF EXISTS %s"
                    , TABLE);

}
