package com.example.carlosgonzalezramos.agenda.main.presentator.presenter;

import com.example.carlosgonzalezramos.agenda.main.presentator.view.MainActivity;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public class MainPresenter
        implements MainInteractorInterface.MainInteractor{
    private MainInteractorInterface.MainView mView;

    public MainPresenter(MainInteractorInterface.MainView mView) {
        this.mView = mView;
        init();
    }

    @Override
    public void init() {
        mView.changeFragment(MainActivity.CONTACT_FRAGMENT);
    }
}
