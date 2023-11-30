package com.example.maizedotco.ui.jenisjagung;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JenisViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public JenisViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is jenisjagung fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}