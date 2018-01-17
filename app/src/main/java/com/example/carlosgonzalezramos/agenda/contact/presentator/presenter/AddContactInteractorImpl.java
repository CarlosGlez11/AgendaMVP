package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;


import android.os.Handler;

import com.example.carlosgonzalezramos.agenda.contact.data.dao.ContactDAO;
import com.example.carlosgonzalezramos.agenda.contact.model.Contact;

/**
 * Created by
 *      carlosgonzalezramos on 15/01/18.
 */

public class AddContactInteractorImpl
    implements IAddContact.AddContactInteractor {
    @Override
    public void checkInfo(final Contact contact,
                          final OnContactListener listener) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                if(contact.getName() == null || contact.getName().isEmpty() ){
                    listener.onNameError();
                    return;
                }
                if(contact.getBirthday() == null || contact.getBirthday().isEmpty() ){
                    listener.onBirthdayError();
                    return;
                }
                if(contact.getPhone() == null || contact.getPhone().isEmpty() ){
                    listener.onPhoneError();
                    return;
                }

                listener.onSuccessful();
            }
        });
    }

    @Override
    public void addContact(Contact contact, OnSaveContactListener listener) {
        ContactDAO dao = lis
    }
}
