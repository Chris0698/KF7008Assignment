package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HealthyMealsFragment extends SwipeRefreshFragment implements IHealthyMealsPresenter
{
    private HealthyMealsPresenter healthyMealsPresenter;

    private ArrayAdapter<FoodItem> healthMealListViewAdapter;
    private ArrayList<FoodItem> foodList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.healthy_meals_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ListView healthyMealList = view.findViewById(R.id.healthyMealsListView);
        if(healthyMealList != null)
        {
            healthyMealList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {

                }
            });

            healthyMealList.setOnScrollListener(new AbsListView.OnScrollListener()
            {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState)
                { /*No Implementation*/}

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
                {

                }
            });
        }

        foodList = new ArrayList<>();

        healthMealListViewAdapter = new ArrayAdapter<FoodItem>(getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1, foodList)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView foodName = view.findViewById(android.R.id.text1);
                TextView foodCalories = view.findViewById(android.R.id.text2);

                foodName.setText(foodList.get(position).GetName());
                foodCalories.setText(foodList.get(position).GetCalories());

                return view;
            }
        };

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Healthy Meals");

            healthyMealsPresenter = new HealthyMealsPresenter(this);

            healthyMealsPresenter.GetNewMeals();
        }
        catch (Exception ex){}
    }

    @Override
    public void RefreshUI(@NonNull View view)
    {
        healthyMealsPresenter.GetNewMeals();
    }

    @Override
    public void AddFoodItem(FoodItem foodItem)
    {
        foodList.add(foodItem);
        healthMealListViewAdapter.notifyDataSetChanged();
    }
}
