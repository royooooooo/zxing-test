package com.thoughtworks.test_project.viewmodel;

import com.thoughtworks.test_project.ui.main.MainViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel("Roy");
    }
}
