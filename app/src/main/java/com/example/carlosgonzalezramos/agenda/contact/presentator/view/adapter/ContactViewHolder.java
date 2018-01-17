package com.example.carlosgonzalezramos.agenda.contact.presentator.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.carlosgonzalezramos.agenda.contact.presentator.presenter.ContactPresenter;
import com.example.carlosgonzalezramos.agenda.databinding.ItemListContactBinding;

/**
 * Created by
 *      carlosgonzalezramos on 16/01/18.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {
    public ItemListContactBinding binding;
    public ContactViewHolder(View itemView, final ContactPresenter presenter) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickContactListener(getAdapterPosition());
            }
        });
    }
}
