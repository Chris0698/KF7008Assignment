package com.example.kf7008assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

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
                            fragment = new StepsPresenterFragment();
                            break;
                        }
                        case R.id.fitnessNavCalories:
                        {
                            fragment = new CaloriesFragment();
                            break;
                        }
                        case R.id.fitnessNavSleep:
                        {
                            fragment = new SleepPresenterFragment();
                            break;
                        }
                        case R.id.fitnessNavMyGoals:
                        {
                            fragment = new MyGoalsPresenterFragment();
                            break;
                        }
                        case R.id.fitnessNavMyDevice:
                        {
                            fragment = new MyDevicePresenterFragment();
                            break;
                        }
                        case R.id.healthyNavFoodLog:
                        {
                            fragment = new FoodLogPresenterFragment();
                            break;
                        }
                        case R.id.healthyNavHealthyMeals:
                        {
                            fragment = new HealthyMealsPresenterFragment();
                            break;
                        }
                        default:
                        {
                            fragment = new StepsPresenterFragment();
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

        NavigationView navigationView = findViewById(R.id.navigationView);
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
                            fragment = new MyDevicePresenterFragment();
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.fitness_nav_menu);
                            break;
                        }
                        case R.id.navDrawMyHealth:
                        {
                            fragment = new FoodLogPresenterFragment();
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.health_nav_menu);
                            break;
                        }
                        case R.id.navDrawAbout:
                        {
                            fragment = new AboutFragment();
                            bottomNavigationView.getMenu().clear();
                            bottomNavigationView.inflateMenu(R.menu.fitness_nav_menu);
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
}
