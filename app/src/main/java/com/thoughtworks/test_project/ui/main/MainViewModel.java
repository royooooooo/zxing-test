package com.thoughtworks.test_project.ui.main;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    String name;

    public MainViewModel(String name) {
        this.name = name;
    }

    private MutableLiveData<List<String>> users;

    public MutableLiveData<List<String>> getUses() {
        if (users == null) {
            List<String> user = new ArrayList<>();
            user.add(name);
            users = new MutableLiveData<>(user);
        }
        return users;
    }
}