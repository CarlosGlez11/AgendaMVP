package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

/**
 * Created by carlosgonzalezramos on 09/01/18.
 */

public class ContactPresenter
    implements ContactInteractorInterface.ContactInteractor {

    private ContactInteractorInterface.ContactView mView;

    public ContactPresenter(ContactInteractorInterface.ContactView view){
        this.mView = view;
        init();
    }

    @Override
    public void init() {
        mView.showContacts();
    }

    @Override
    public boolean addedContact() {
        return false;
    }

    @Override
    public boolean removeContact() {
        return false;
    }
}
