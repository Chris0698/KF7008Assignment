package com.example.kf7008assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
{
    private BottomNavigationView bottomNavigationView;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                            fragment = new StepsFragment();
                            break;
                        }
                        case R.id.fitnessNavCalories:
                        {
                            fragment = new CaloriesFragment();
                            break;
                        }
                        case R.id.fitnessNavSleep:
                        {
                            fragment = new SleepFragment();
                            break;
                        }
                        case R.id.fitnessNavMyGoals:
                        {
                            fragment = new MyGoalsFragment();
                            break;
                        }
                        case R.id.fitnessNavMyDevice:
                        {
                            fragment = new MyDeviceFragment();
                            break;
                        }
                    }

                    //needs to go in the presenter possibly
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    if(fragmentManager != null)
                    {
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }

                    return true;
                }
            });
        }

        navigationView = findViewById(R.id.navigationView);
        if(navigationView != null)
        {
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
                {
                    Fragment fragment = null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.navDrawMyDevice:
                        {
                            fragment = new MyDeviceFragment();
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.fitness_nav_menu);
                            break;
                        }
                        case R.id.navDrawMyHealth:
                        {
                            fragment = new MyDeviceFragment();
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.health_nav_menu);
                            break;
                        }
                        case R.id.navDrawAbout:
                        {
                            fragment = new MyDeviceFragment();
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.fitness_nav_menu);
                        }
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    if(fragmentManager != null)
                    {
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }


                    return true;
                }
            });
        }
    }
}
