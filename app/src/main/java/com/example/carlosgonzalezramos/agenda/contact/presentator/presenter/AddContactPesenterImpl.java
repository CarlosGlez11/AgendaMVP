package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

import com.example.carlosgonzalezramos.agenda.contact.model.Contact;

/**
 * Created by
 *      carlosgonzalezramos on 10/01/18.
 */

public class AddContactPesenterImpl
    implements IAddContact.AddContactViewPresenter,
        IAddContact.AddContactInteractor.OnContactListener,
        IAddContact.AddContactInteractor.OnSaveContactListener {

    private IAddContact.AddContactView mView;
    private IAddContact.AddContactInteractor mInteractor;

    public AddContactPesenterImpl(IAddContact.AddContactView mView,
                                  AddContactInteractorImpl mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;
    }

    @Override
    public void checkInfo(Contact contact) {
       mInteractor.checkInfo(contact, this);
    }


    @Override
    public void onNameError() {
        mView.setNameError();
    }

    @Override
    public void onPhoneError() {
        mView.setPhoneError();
    }

    @Override
    public void onBirthdayError() {
        mView.setBirthdayError();
    }

    @Override
    public void onSuccessful(Contact contact) {
        mInteractor.addContact(contact, this);
    }


    @Override
    public void onSaveSuccess() {

    }

    @Override
    public void onSaveError() {

    }
}
