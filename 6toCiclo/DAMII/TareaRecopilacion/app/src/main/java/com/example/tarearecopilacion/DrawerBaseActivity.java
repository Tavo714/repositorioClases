package com.example.tarearecopilacion;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activity_container);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_navigation_drawer, R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            startActivity(new Intent(this, CurriculumActivity.class));
        } else if (id == R.id.nav_cuentacuentos) {
            startActivity(new Intent(this, CuentacuentosActivity.class));
        } else if (id == R.id.nav_casa_cambios) {
            startActivity(new Intent(this, CasacambiosActivity.class));
        } else if (id == R.id.nav_planillas) {
            startActivity(new Intent(this, PlanillaActivity.class));
        } else if (id == R.id.nav_programador) {
            startActivity(new Intent(this, ProgramaorActivity.class));
        } else if (id == R.id.nav_mapa) {
            startActivity(new Intent(this, MapsActivity.class));
        }

        drawerLayout.closeDrawers();
        return true;
    }
}
