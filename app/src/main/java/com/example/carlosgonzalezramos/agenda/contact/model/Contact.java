package com.example.carlosgonzalezramos.agenda.contact.model;

/**
 * Created by
 *      carlosgonzalezramos on 08/01/18.
 */

public class Contact {

    private int id;
    private String name;
    private String birthday;
    private String phone;

    public Contact(){
        //Empty constructor
    }

    public Contact(String name, String birthday, String phone) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
