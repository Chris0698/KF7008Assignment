package com.example.kf7008assignment;

public class SelectDevicePresenter
{
    private ISelectDevice iSelectDevice;

    public SelectDevicePresenter(ISelectDevice iSelectDevice) throws Exception
    {
        if(iSelectDevice == null)
        {
            throw new Exception();
        }

        this.iSelectDevice = iSelectDevice;
    }

    public void ScanForDevices()
    {

    }
}
