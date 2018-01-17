package com.example.carlosgonzalezramos.agenda.contact.presentator.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.carlosgonzalezramos.agenda.R;
import com.example.carlosgonzalezramos.agenda.contact.data.dao.ContactDAO;
import com.example.carlosgonzalezramos.agenda.contact.model.Contact;
import com.example.carlosgonzalezramos.agenda.contact.presentator.presenter.AddContactInteractorImpl;
import com.example.carlosgonzalezramos.agenda.contact.presentator.presenter.IAddContact;
import com.example.carlosgonzalezramos.agenda.contact.presentator.presenter.AddContactPesenterImpl;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment
    implements IAddContact.AddContactView, View.OnClickListener{

    private AddContactPesenterImpl mPresenter;
    private ContactDAO mContactDAO;
    private EditText mEtName, mEtBirthday, mEtPhone;

    public AddContactFragment() {
        // Required empty public constructor
    }

    public static AddContactFragment newInstance() {
        Bundle args = new Bundle();

        AddContactFragment fragment = new AddContactFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =
                inflater.inflate(R.layout.fragment_add_contact, container, false);
        mEtName     = view.findViewById(R.id.et_name);
        mEtPhone    = view.findViewById(R.id.et_phone);
        mEtBirthday = view.findViewById(R.id.et_birthday);

        view.findViewById(R.id.fab_save).setOnClickListener(this);

        mPresenter = new AddContactPesenterImpl(this, new AddContactInteractorImpl());
        mContactDAO = new ContactDAO(getContext());
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_save:
                Contact contact = new Contact(mEtName.getText().toString().trim(),
                        mEtBirthday.getText().toString().trim(),
                        mEtPhone.getText().toString().trim());
                mPresenter.checkInfo(contact);
                break;
        }
    }

    @Override
    public void setNameError() {
        mEtName.setError("Name can not be empty");
    }

    @Override
    public void setPhoneError() {
        mEtPhone.setError("Phone can not be empty");
    }

    @Override
    public void setBirthdayError() {
        mEtBirthday.setError("Birthday can not be empty");
    }

    @Override
    public void setSuccessful() {
        mContactDAO.addContact(new Contact(
                mEtName.getText().toString().trim(),
                mEtBirthday.getText().toString().trim(),
                mEtPhone.getText().toString().trim()));
        getActivity().onBackPressed();

    }
}
