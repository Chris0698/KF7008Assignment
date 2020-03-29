package com.example.kf7008assignment;

import android.bluetooth.BluetoothDevice;

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

    public void GetConnectedDeviceStatus()
    {
        BluetoothDevice connectedDevice = ConnectedDevice.GetInstance().GetConnectedDevice();
        if(connectedDevice == null)
        {
            //no device connected
            iMyDevice.SetButtonText("Connect To Device");
            iMyDevice.SetDeviceName("Device Name: No Device Connected");
            iMyDevice.SetDeviceAddress("Device Address: No Device Connected");
        }
        else
        {
            iMyDevice.SetButtonText("Disconnect From Device");
            iMyDevice.SetDeviceName("Device Name: " + connectedDevice.getName());
            iMyDevice.SetDeviceAddress("Device Address: " + connectedDevice.getAddress());
        }
    }

    public BluetoothDevice GetConnectedDevice()
    {
        return ConnectedDevice.GetInstance().GetConnectedDevice();
    }

    public void DisconnectFromDevice()
    {
        ConnectedDevice.GetInstance().SetConnectedDevice(null);
        iMyDevice.SetButtonText("Connect To Device");
        iMyDevice.SetDeviceName("Device Name: No Device Connected");
        iMyDevice.SetDeviceAddress("Device Address: No Device Connected");
    }
}
