package com.example.maizedotco.ui.artikel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArtikelViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ArtikelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is artikel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}