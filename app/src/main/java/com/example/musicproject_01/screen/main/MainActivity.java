package com.example.musicproject_01.screen.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.musicproject_01.R;
import com.example.musicproject_01.constant.Constant;
import com.example.musicproject_01.screen.main.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBottomNavigationView;
    private HomeFragment mHomeFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissionStorage();
    }

    private void checkPermissionStorage() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        Constant.MY_PERMISSION_REQUEST_READ_EXTERNAL_STORAGE);
            }
        } else {
            initViews();
            registerListeners();
        }
    }

    private void registerListeners() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initViews() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mToolbar = findViewById(R.id.toolbar);
        String titleHome = getString(R.string.icon_home);
        mToolbar.setTitle(titleHome);
        setSupportActionBar(mToolbar);
        openScreenHome();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_home:
                openScreenHome();
                return true;
            case R.id.nav_library:
                openScreenLibrary();
                return true;
            case R.id.nav_download:
                openScreenDownload();
                return true;
            default:
                return false;
        }
    }

    private void openScreenDownload() {
    }

    private void openScreenLibrary() {

    }

    private void openScreenHome() {
        mHomeFragment = new HomeFragment();
        addFragment(mHomeFragment);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
