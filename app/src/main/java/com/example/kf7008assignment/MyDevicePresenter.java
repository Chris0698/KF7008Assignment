package com.example.kf7008assignment;

public class MyDevicePresenter
{
    private IMyDevice iMyDevice;

    public MyDevicePresenter(IMyDevice iMyDevice) throws Exception
    {
        if(iMyDevice == null)
        {
            throw new Exception();
        }

        this.iMyDevice = iMyDevice;
    }
}
