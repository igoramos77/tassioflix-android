package com.example.tassioflix.ui.topRated;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TopRatedViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TopRatedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}