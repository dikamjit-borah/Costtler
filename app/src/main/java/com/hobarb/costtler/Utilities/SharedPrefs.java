package com.hobarb.costtler.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class SharedPrefs {
    Context context;
    SharedPreferences sharedPreferences;

    SharedPrefs(Context context){
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE);
    }






}
