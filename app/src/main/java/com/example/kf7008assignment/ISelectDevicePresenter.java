package com.example.kf7008assignment;

import android.bluetooth.BluetoothDevice;

public interface ISelectDevicePresenter
{
    void AddDeviceToList(BluetoothDevice bluetoothDevice);

    void GoToMyDeviceFragment();

    boolean AlertDialog(String title, String message);
}
