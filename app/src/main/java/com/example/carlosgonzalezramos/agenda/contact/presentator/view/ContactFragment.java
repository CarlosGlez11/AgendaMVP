package com.example.carlosgonzalezramos.agenda.contact.presentator.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carlosgonzalezramos.agenda.R;
import com.example.carlosgonzalezramos.agenda.contact.data.dao.ContactDAO;
import com.example.carlosgonzalezramos.agenda.contact.presentator.presenter.ContactInteractorInterface;
import com.example.carlosgonzalezramos.agenda.contact.presentator.presenter.ContactPresenter;
import com.example.carlosgonzalezramos.agenda.database.DataBase;
import com.example.carlosgonzalezramos.agenda.main.presentator.presenter.MainInteractorInterface;
import com.example.carlosgonzalezramos.agenda.main.presentator.view.MainActivity;

public class ContactFragment extends Fragment
    implements ContactInteractorInterface.ContactView, View.OnClickListener {


    private ContactPresenter mPresenter;
    private ContactDAO mContactDAO;
    private ContactAdapter mAdapter;
    private RecyclerView mRecyclerMain;
    private MainInteractorInterface.MainView mMainView;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance(MainInteractorInterface.MainView mainView) {
        ContactFragment fragment = new ContactFragment();
        fragment.mMainView = mainView;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        mRecyclerMain = view.findViewById(R.id.rv_contacts);
        view.findViewById(R.id.fab_add).setOnClickListener(this);
        mContactDAO = new ContactDAO(DataBase.getInstance(getContext()));
        mPresenter = new ContactPresenter(this);
        mPresenter.init();
        return view;
    }

    @Override
    public void refreshRecycler() {
    }

    @Override
    public void showContacts() {
        mRecyclerMain.setHasFixedSize(true);
        mRecyclerMain.setItemAnimator(new DefaultItemAnimator());
        mRecyclerMain.setLayoutManager(new GridLayoutManager(getContext(), 1));
        mRecyclerMain.setAdapter(
                new ContactAdapter(this, mContactDAO.fetchAllContacts()));
    }

    @Override
    public void showDialogMenu(final int id) {
        String[] items = new String[]{"Edit", "Delete"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Action to do...")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                mMainView.changeFragment(MainActivity.ADD_CONTACT_FRAGMENT);
                                break;
                            case 1:
                                Toast.makeText(getContext(),
                                        "Contact deleted",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                }).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_add:
                mMainView.changeFragment(MainActivity.ADD_CONTACT_FRAGMENT);
                break;
        }
    }
}
