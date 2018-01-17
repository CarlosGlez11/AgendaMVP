package com.example.carlosgonzalezramos.agenda.main.presentator.presenter;


import com.example.carlosgonzalezramos.agenda.main.presentator.view.MainActivity;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public class MainPresenter
        implements MainInterface.MainPresenter{

    private MainInterface.MainView mView;

    public MainPresenter(MainInterface.MainView mView) {
        this.mView = mView;
    }

    @Override
    public void init() {
        mView.changeFragment(MainActivity.CONTACT_FRAGMENT);
    }
}
