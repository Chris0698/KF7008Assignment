package com.example.kf7008assignment;

public class MainActivityPresenter
{
    private IMainActivity iMainActivity;

    public MainActivityPresenter(IMainActivity iMainActivity) throws Exception
    {
        if (iMainActivity == null)
        {
            throw new Exception("IMainActivity is null");
        }

        this.iMainActivity = iMainActivity;


    }


}