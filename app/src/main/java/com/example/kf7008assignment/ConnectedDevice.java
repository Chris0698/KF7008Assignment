package com.example.kf7008assignment;

import android.bluetooth.BluetoothDevice;

public class ConnectedDevice
{
    private static ConnectedDevice instance = null;

    private BluetoothDevice connectedDevice;

    private ConnectedDevice()
    {

    }

    public static ConnectedDevice GetInstance()
    {
        if(instance == null)
        {
            instance = new ConnectedDevice();
        }

        return instance;
    }

    public void SetConnectedDevice(BluetoothDevice bluetoothDevice)
    {
        connectedDevice = bluetoothDevice;
    }

    public BluetoothDevice GetConnectedDevice()
    {
        return connectedDevice;
    }

}
