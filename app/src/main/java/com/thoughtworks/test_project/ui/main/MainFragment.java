package com.thoughtworks.test_project.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtworks.scanner.android.CaptureActivity;
import com.thoughtworks.scanner.common.Constant;
import com.thoughtworks.test_project.databinding.MainFragmentBinding;
import com.thoughtworks.test_project.viewmodel.UserViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class MainFragment extends Fragment {

    private MainFragmentBinding mainFragmentBinding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater);
        mainFragmentBinding.scanBtn.setOnClickListener(view -> {
            Intent intent = new Intent(requireActivity(), CaptureActivity.class);
            startActivity(intent);
        });
        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainViewModel mViewModel = new ViewModelProvider(this, new UserViewModelFactory()).get(MainViewModel.class);
        mViewModel.getUses().observe(getViewLifecycleOwner(), users -> mainFragmentBinding.message.setText(users.get(0)));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1111) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);

                mainFragmentBinding.message.setText("扫描结果为：" + content);
            }
        }
    }
}