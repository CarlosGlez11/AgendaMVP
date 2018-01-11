package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

/**
 * Created by carlosgonzalezramos on 09/01/18.
 */

public interface ContactInteractorInterface {
    interface ContactView {
        void refreshRecycler();
        void showContacts();
        void showDialogMenu(int id);
    }

    interface ContactInteractor {
        void init();
        boolean addedContact();
        boolean removeContact();
    }

}
