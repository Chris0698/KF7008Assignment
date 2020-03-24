package com.example.kf7008assignment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SelectDevicePresenter
{
    private ISelectDevice iSelectDevice;
    private BluetoothAdapter bluetoothAdapter;

    public SelectDevicePresenter(ISelectDevice iSelectDevice) throws Exception
    {
        if(iSelectDevice == null)
        {
            throw new Exception();
        }

        this.iSelectDevice = iSelectDevice;
    }

    public Intent EnableBluetooth()
    {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter != null)
        {
            if (!bluetoothAdapter.isEnabled())
            {
                return new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            }
        }

        return null;
    }

    public final BroadcastReceiver broadcastReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
            if(action.equals(BluetoothDevice.ACTION_FOUND))
            {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceAddress = device.getAddress();

                Log.i("TAG", "Found Device: " + deviceName + " " + deviceAddress);
                iSelectDevice.AddDeviceToList(device);
            }
        }
    };
}
