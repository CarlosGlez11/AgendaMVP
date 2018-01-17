package com.example.carlosgonzalezramos.agenda.contact.presentator.presenter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.carlosgonzalezramos.agenda.contact.data.dao.ContactDAO;
import com.example.carlosgonzalezramos.agenda.contact.model.Contact;
import com.example.carlosgonzalezramos.agenda.contact.presentator.view.adapter.ContactViewHolder;
import com.example.carlosgonzalezramos.agenda.databinding.ItemListContactBinding;

import java.util.ArrayList;

/**
 * Created by
 *      carlosgonzalezramos on 09/01/18.
 */

public class ContactPresenter
    implements IContact.IContactPresenter {

    private IContact.IContactView mView;
    private IContact.IContactInteractor mInteractor;
    private ArrayList<Contact> mListContact;

    public ContactPresenter(IContact.IContactView view, ContactInteractorImpl interactor){
        this.mView = view;
        this.mInteractor = interactor;
    }

    @Override
    public void init() {
        mListContact = mInteractor.fetchContacts(this);
        mView.showContacts();
    }

    @Override
    public int getItemCount() {
        return mListContact != null ? mListContact.size() : 0 ;
    }

    @Override
    public ContactDAO getContactDAO() {
        return mView.getContactDAO();
    }

    @Override
    public void onClickContactListener(int position) {
        mView.showDialogMenu(position);
    }

    @Override
    public ContactViewHolder newContactViewHolder(ViewGroup parent) {
        ItemListContactBinding binding = ItemListContactBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ContactViewHolder(binding.getRoot(), this);
    }

    @Override
    public void setContactBinding(ContactViewHolder holder, int position) {
        holder.binding.setContact(mListContact.get(position));
    }
}
