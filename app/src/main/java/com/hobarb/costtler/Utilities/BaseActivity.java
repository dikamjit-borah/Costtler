package com.hobarb.costtler.Utilities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hobarb.costtler.R;

public class BaseActivity  extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = findViewById(R.id.tB_custom_ct1);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextAppearance(this, R.style.setFont_white);
    }



}
