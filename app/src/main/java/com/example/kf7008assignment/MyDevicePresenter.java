package com.example.kf7008assignment;

import android.bluetooth.BluetoothDevice;

public class MyDevicePresenter
{
    private IMyDevicePresenter iMyDevicePresenter;

    public MyDevicePresenter(IMyDevicePresenter iMyDevicePresenter) throws Exception
    {
        if(iMyDevicePresenter == null)
        {
            throw new Exception();
        }

        this.iMyDevicePresenter = iMyDevicePresenter;
    }

    public void GetConnectedDeviceStatus()
    {
        BluetoothDevice connectedDevice = ConnectedDevice.GetInstance().GetConnectedDevice();
        if(connectedDevice == null)
        {
            //no device connected
            iMyDevicePresenter.SetButtonText("Connect To Device");
            iMyDevicePresenter.SetDeviceName("Device Name: No Device Connected");
            iMyDevicePresenter.SetDeviceAddress("Device Address: No Device Connected");
        }
        else
        {
            iMyDevicePresenter.SetButtonText("Disconnect From Device");
            iMyDevicePresenter.SetDeviceName("Device Name: " + connectedDevice.getName());
            iMyDevicePresenter.SetDeviceAddress("Device Address: " + connectedDevice.getAddress());
        }
    }

    public BluetoothDevice GetConnectedDevice()
    {
        return ConnectedDevice.GetInstance().GetConnectedDevice();
    }

    public void DisconnectFromDevice()
    {
        ConnectedDevice.GetInstance().SetConnectedDevice(null);
        iMyDevicePresenter.SetButtonText("Connect To Device");
        iMyDevicePresenter.SetDeviceName("Device Name: No Device Connected");
        iMyDevicePresenter.SetDeviceAddress("Device Address: No Device Connected");
    }
}
