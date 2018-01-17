package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

import com.example.carlosgonzalezramos.agenda.contact.model.Contact;

/**
 * Created by
 *      carlosgonzalezramos on 10/01/18.
 */

public interface IAddContact {
    interface AddContactView{
        void setNameError();
        void setPhoneError();
        void setBirthdayError();
        void setSuccessful();
    }

    interface AddContactViewPresenter{
        void checkInfo(Contact contact);
    }

    interface AddContactInteractor {
        interface OnContactListener {
            void onNameError();

            void onPhoneError();

            void onBirthdayError();

            void onSuccessful(Contact contact);
        }

        interface OnSaveContactListener{
            void onSaveSuccess();
            void onSaveError();
        }

        void checkInfo(Contact contact, OnContactListener listener);
        void addContact(Contact contact, OnSaveContactListener listener);
    }

}
