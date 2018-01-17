package com.example.carlosgonzalezramos.agenda;

/**
 * Created by carlosgonzalezramos on 15/01/18.
 */

public interface BaseInterface<T> {
    void onCreate();
    void onPause();
    void onDestroy();
    T getDAO();
}
