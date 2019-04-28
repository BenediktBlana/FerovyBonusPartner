package com.example.ferovybonuspartner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.Button;
import com.example.ferovybonuspartner.ui.HomeFragment;
import com.example.ferovybonuspartner.ui.ItemFragment;
import com.example.ferovybonuspartner.ui.model.DummyContent;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        HomeFragment.OnFragmentInteractionListener,
        ItemFragment.OnListFragmentInteractionListener {

    private FirebaseAuth mAuth;
    private Button signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("My Preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
      Fragment fragment = null;
        switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    System.out.println("FRAGMENT HOME");
                    break;
                case R.id.navigation_scanner:
                    Intent intent = new Intent(this, ScannerActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_items:
                    fragment = new ItemFragment();
                    System.out.println("FRAGMENT ITEM");
                    break;
            }
        return loadFragment(fragment);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onHomeFragmentInteraction(Uri uri) {

    }
}
