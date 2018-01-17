package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

import android.view.ViewGroup;

import com.example.carlosgonzalezramos.agenda.contact.data.dao.ContactDAO;
import com.example.carlosgonzalezramos.agenda.contact.model.Contact;
import com.example.carlosgonzalezramos.agenda.contact.presentator.view.adapter.ContactViewHolder;

import java.util.ArrayList;

/**
 * Created by
 *      carlosgonzalezramos on 09/01/18.
 */

public interface IContact {
    interface IContactView {
        void showContacts();
        void refreshRecycler();
        void showDialogMenu(int id);
        ContactDAO getContactDAO();
    }

    interface IContactPresenter{
        void init();
        int getItemCount();
        ContactDAO getContactDAO();
        void onClickContactListener(int position);
        ContactViewHolder newContactViewHolder(ViewGroup parent);
        void setContactBinding(ContactViewHolder holder, int position);
    }

    interface IContactInteractor {
        boolean addedContact();
        boolean removeContact();
        ArrayList<Contact> fetchContacts(ContactPresenter presenter);

    }

}
