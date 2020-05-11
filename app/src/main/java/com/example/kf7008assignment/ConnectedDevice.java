package com.example.kf7008assignment;

import android.bluetooth.BluetoothDevice;

/**
 * Used to "store" the connected bluetooth device.
 */
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

    /**
     * Set the connected device
     * @param bluetoothDevice is the device, can be null to allow a disconnect
     */
    public void SetConnectedDevice(BluetoothDevice bluetoothDevice)
    {
        connectedDevice = bluetoothDevice;
    }

    public BluetoothDevice GetConnectedDevice()
    {
        return connectedDevice;
    }

}
