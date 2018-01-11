package com.example.carlosgonzalezramos.agenda.contact.presentator.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlosgonzalezramos.agenda.contact.presentator.presenter.ContactInteractorInterface;
import com.example.carlosgonzalezramos.agenda.databinding.ItemListContactBinding;
import com.example.carlosgonzalezramos.agenda.contact.model.Contact;

import java.util.ArrayList;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private ArrayList<Contact> mContacts;
    private ContactInteractorInterface.ContactView mContactView;

    ContactAdapter(ContactInteractorInterface.ContactView view , ArrayList<Contact> contacts) {
        this.mContacts = contacts;
        this.mContactView = view;
    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListContactBinding binding =
                ItemListContactBinding.inflate
                        (LayoutInflater.from(parent.getContext()), parent, false);
        return new ContactViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.binding.setContact(mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts != null ? mContacts.size() : 0;
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        ItemListContactBinding binding;

        ContactViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mContactView.showDialogMenu(mContacts.get(getAdapterPosition()).getId());
                    return false;
                }
            });
        }
    }
}
