package com.example.kf7008assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
{
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;

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
                        case R.id.healthyNavFoodLog:
                        {
                            fragment = new FoodLogFragment();
                            break;
                        }
                        case R.id.healthyNavHealthyMeals:
                        {
                            fragment = new HealthyMealsFragment();
                            break;
                        }
                        default:
                        {
                            fragment = new StepsFragment();
                            Log.i("TAG", "Unknown nav option");
                        }
                    }

                    //needs to go in the presenter possibly
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                    return true;
                }
            });
        }

        final NavigationView navigationView = findViewById(R.id.navigationView);
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
                            fragment = new StepsFragment();

                            //swap the bottom navigation menu
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.fitness_nav_menu);
                            break;
                        }
                        case R.id.navDrawMyHealth:
                        {
                            fragment = new FoodLogFragment();

                            //swap the bottom navigation menu
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.health_nav_menu);
                            break;
                        }
                        case R.id.navDrawAbout:
                        {
                            fragment = new AboutFragment();

                            //swap the bottom navigation menu
                            bottomNavigationView.getMenu().clear();
                            //bottomNavigationView.inflateMenu(R.menu.fitness_nav_menu);
                        }
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                    drawerLayout.closeDrawer(GravityCompat.START);

                    return true;
                }
            });
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle
                                                         (
                                                             this,
                                                             drawerLayout,
                                                             toolbar,
                                                             R.string.navDrawOpen,
                                                             R.string.navDrawClose);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //goto my device as home screen
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new MyDeviceFragment());
        fragmentTransaction.commit();
        bottomNavigationView.setSelectedItemId(R.id.fitnessNavMyDevice);



//        final ToggleButton themeToggleButton = findViewById(R.id.themeToggle);
//        themeToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
//        {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
//            {
//
//            }
//        });
    }

    @Override
    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.toolbarDark:
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            }
            case R.id.toolbarLight:
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            }
        }

        return true;
    }

}
