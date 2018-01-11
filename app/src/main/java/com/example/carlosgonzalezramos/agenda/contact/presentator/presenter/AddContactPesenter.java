package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

import android.util.Log;

import com.example.carlosgonzalezramos.agenda.contact.data.dao.ContactDAO;

/**
 * Created by
 *      carlosgonzalezramos on 10/01/18.
 */

public class AddContactPesenter
    implements AddContactInterface.AddContactViewPresenter {

    private AddContactInterface.AddContactView mView;

    public AddContactPesenter(AddContactInterface.AddContactView mView) {
        this.mView = mView;
    }

    @Override
    public void checkInfo(String name, String birthday, String phone) {
        if(name == null || name.isEmpty() ){
            mView.onNameError();
            return;
        }
        if(birthday == null || birthday.isEmpty() ){
            mView.onBirthdayError();
            return;
        }
        if(phone == null || phone.isEmpty() ){
            mView.onPhoneError();
            return;
        }

        mView.onSuccessful();
    }


}
