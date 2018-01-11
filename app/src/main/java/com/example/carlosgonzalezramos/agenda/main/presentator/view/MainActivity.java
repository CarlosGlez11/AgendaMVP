package com.example.carlosgonzalezramos.agenda.main.presentator.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carlosgonzalezramos.agenda.R;
import com.example.carlosgonzalezramos.agenda.contact.presentator.view.AddContactFragment;
import com.example.carlosgonzalezramos.agenda.contact.presentator.view.ContactFragment;
import com.example.carlosgonzalezramos.agenda.main.presentator.presenter.MainInteractorInterface;
import com.example.carlosgonzalezramos.agenda.main.presentator.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity
        implements MainInteractorInterface.MainView {

    public static final String CONTACT_FRAGMENT = "contacts";
    public static final String ADD_CONTACT_FRAGMENT = "add";
    public static final String EDIT_CONTACT_FRAGMENT = "edit";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPresenter presenter = new MainPresenter(this);

    }

    @Override
    public void changeFragment(String typeFragment) {
        changeFragment(typeFragment, 0);
    }

    @Override
    public void changeFragment(String typeFragment, int id) {
        Fragment fragment = null;
        switch (typeFragment){
            case CONTACT_FRAGMENT:
                fragment = ContactFragment.newInstance(this);
                break;
            case ADD_CONTACT_FRAGMENT:
                fragment = AddContactFragment.newInstance();
                break;
            case EDIT_CONTACT_FRAGMENT:
                fragment = AddContactFragment.newInstance();
                break;
        }

        if (fragment == null) return;

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

}
