package com.example.carlosgonzalezramos.agenda.contact.data.dao;

import com.example.carlosgonzalezramos.agenda.contact.model.Contact;

import java.util.ArrayList;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public interface IContactDAO {
    Contact fetchContact(int id);
    ArrayList<Contact> fetchAllContacts();
    boolean addContact(Contact contact);
    boolean deleteContact(int id);
    boolean updateContact(Contact contact);

}
