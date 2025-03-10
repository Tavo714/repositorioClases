package com.example.clase06;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import com.example.clase06.databinding.ActivityInicioBinding;

public class InicioActivity extends DrawerBaseActivity {
    ActivityInicioBinding activityInicioBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInicioBinding = ActivityInicioBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(activityInicioBinding.getRoot());

    }
}