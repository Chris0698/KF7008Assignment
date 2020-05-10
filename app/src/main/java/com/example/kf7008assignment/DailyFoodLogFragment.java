package com.example.kf7008assignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class DailyFoodLogFragment extends Fragment implements IDailyFoodLogPresenter
{
    private int day;
    private int month;
    private int year;

    private TextView totalCaloriesTextView;

    private DailyFoodLogPresenter dailyFoodLogPresenter;
    private ArrayList<FoodItem> foodList;
    private ArrayAdapter<FoodItem> foodItemArrayAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.daily_food_log_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        totalCaloriesTextView = view.findViewById(R.id.foodLogTotalCaloriesTextView);
        ListView foodListView = view.findViewById(R.id.foodLogFoodList);
        foodList = new ArrayList<>();

        TextView foodLogDateTextView = view.findViewById(R.id.foodLogDateTextView);
        if(foodLogDateTextView != null)
        {
            foodLogDateTextView.setText("Food Log for: " + day + "-" + month + "-" + year);
        }

        Button backButton = view.findViewById(R.id.foodLogBackButton);
        if(backButton != null)
        {
            backButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, new FoodLogFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }

        final Button addFoodButton = view.findViewById(R.id.foodLogAddButton);
        if(addFoodButton != null)
        {
            addFoodButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    dailyFoodLogPresenter.AddFoodItemButtonClick(getActivity());
                }
            });
        }

        foodItemArrayAdapter = new ArrayAdapter<FoodItem>(getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1, foodList)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView foodName = view.findViewById(android.R.id.text1);
                TextView caloriesLabel = view.findViewById(android.R.id.text2);

                foodName.setText(foodList.get(position).GetName());
                caloriesLabel.setText("Calories: " + foodList.get(position).GetCalories());

                return view;
            }
        };

        if(foodListView != null)
        {
            foodListView.setAdapter(foodItemArrayAdapter);

            foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
                {
                    final FoodItem foodItem = foodList.get(position);
                    new AlertDialog.Builder(getContext())
                                            .setTitle("Delete Entry")
                                            .setMessage("Are you sure you want to delete " + foodItem.GetName())
                                            .setIcon(android.R.drawable.ic_dialog_alert)
                                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
                                            {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which)
                                                {
                                                    dailyFoodLogPresenter.RemoveItem(position);
                                                }
                                            })
                                            .setNegativeButton(android.R.string.cancel, null)
                                            .show();
                }
            });
        }

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Food Log");

            dailyFoodLogPresenter = new DailyFoodLogPresenter(this);

            //populate the food list here and get total calories if there a record for the DMY
            dailyFoodLogPresenter.GetFoodItems(day, month, year);
        }
        catch (Exception ex)
        {
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Called before onViewCreated, not sure why though
     */
    public void PopulateValues(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public void AddFoodItem(FoodItem foodItem)
    {
        foodList.add(foodItem);
        foodItemArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void SetCaloriesTextView(String text)
    {
        totalCaloriesTextView.setText(text);
    }

    @Override
    public void RemoveFoodItem(FoodItem foodItem)
    {
        foodList.remove(foodItem);
        foodItemArrayAdapter.notifyDataSetChanged();
    }
}
