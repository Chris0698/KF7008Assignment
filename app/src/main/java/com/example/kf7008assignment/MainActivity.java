package com.example.kf7008assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements IMainActivity
{
    private MainActivityPresenter mainActivityPresenter;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            mainActivityPresenter = new MainActivityPresenter(this);
        }
        catch (Exception exception)
        {

        }

        bottomNavigationView = findViewById(R.id.navBottom);
        if(bottomNavigationView != null)
        {
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
                {
                    Fragment fragment = null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.fitnessNavFootsteps:
                        {
                            //fragment = new
                        }
                        case R.id.fitnessNavMyDevice:
                        {
                            fragment = new MyDeviceFragment();
                        }
                    }
                    return true;
                }
            });
        }

        //needs to go in the presenter
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager != null)
        {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, new MyDeviceFragment());
            fragmentTransaction.commit();
        }
    }
}
