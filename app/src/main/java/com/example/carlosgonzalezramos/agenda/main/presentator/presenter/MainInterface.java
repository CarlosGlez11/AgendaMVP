package com.example.carlosgonzalezramos.agenda.main.presentator.presenter;

import android.support.v4.app.Fragment;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public interface MainInterface {

    interface MainPresenter{
        void init();
    }

    interface MainView {
        void changeFragment(String typeFragment);
        void changeFragment(String typeFragment, int id);
    }
}
