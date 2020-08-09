package com.thoughtworks.test_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.thoughtworks.scanner.common.Constant;
import com.thoughtworks.test_project.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment = MainFragment.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] permissions = new String[]{Manifest.permission.
                WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            requestPermissions(permissions, 1);
        }
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, mainFragment)
                    .commitNow();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1111) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);

                Log.i("TAG", "onActivityResult: result is: "+content);
            }
        }
    }
}