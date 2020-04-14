package com.example.kf7008assignment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public abstract class SwipeRefreshFragment extends Fragment
{
    protected SwipeRefreshLayout swipeRefreshLayout;

    public abstract void RefreshUI(@NonNull View view);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        //this is a hack cause if method arguement view is used, then a compiler error happens
        final View view1 = view;

        //This has to be final for some reason
        final SwipeRefreshLayout swipeRefreshLayout = view1.findViewById(R.id.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                RefreshUI(view1);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
