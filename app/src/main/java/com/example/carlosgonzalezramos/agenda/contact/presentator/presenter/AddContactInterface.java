package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

/**
 * Created by
 *      carlosgonzalezramos on 10/01/18.
 */

public interface AddContactInterface {
    interface AddContactView{
        void onNameError();
        void onPhoneError();
        void onBirthdayError();
        void onSuccessful();
    }

    interface AddContactViewPresenter{
        void checkInfo(String name, String birthday, String phone);
    }
}
