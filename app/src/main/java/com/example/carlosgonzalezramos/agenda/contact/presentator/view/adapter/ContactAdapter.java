package com.example.carlosgonzalezramos.agenda.contact.presentator.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.carlosgonzalezramos.agenda.contact.presentator.presenter.ContactPresenter;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{

    private ContactPresenter mPresenter;

    public ContactAdapter(ContactPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mPresenter.newContactViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        mPresenter.setContactBinding(holder, position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getItemCount();
    }


}
