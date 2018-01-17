package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

import com.example.carlosgonzalezramos.agenda.contact.data.dao.ContactDAO;
import com.example.carlosgonzalezramos.agenda.contact.model.Contact;

import java.util.ArrayList;

/**
 * Created by
 *      carlosgonzalezramos on 16/01/18.
 */

public class ContactInteractorImpl implements IContact.IContactInteractor {
    @Override
    public boolean addedContact() {
        return false;
    }

    @Override
    public boolean removeContact() {
        return false;
    }

    @Override
    public ArrayList<Contact> fetchContacts(ContactPresenter presenter) {
        ContactDAO dao = presenter.getContactDAO();
        return dao.fetchAllContacts();
    }
}
