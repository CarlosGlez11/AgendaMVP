package com.example.carlosgonzalezramos.agenda.main.presentator.presenter;

import android.support.v4.app.Fragment;

/**
 * Created by carlosgonzalezramos on 08/01/18.
 */

public interface MainInteractorInterface {
    interface MainView {
        void changeFragment(String typeFragment);
        void changeFragment(String typeFragment, int id);
    }

    interface MainInteractor{
        void init();
    }
}
