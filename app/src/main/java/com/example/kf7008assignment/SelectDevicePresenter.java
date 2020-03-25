package com.example.kf7008assignment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class SelectDevicePresenter
{
    private ISelectDevice iSelectDevice;

    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;

    public SelectDevicePresenter(ISelectDevice iSelectDevice) throws Exception
    {
        if(iSelectDevice == null)
        {
            throw new Exception();
        }

        this.iSelectDevice = iSelectDevice;
    }

    public void InitialiseBluetoothLE(Context context)
    {
        final BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();
        if(bluetoothAdapter == null)
        {
            Log.i("TAG", "Bluetooth adapter is null");
        }
    }

    public Intent EnableBluetoothLEIntent()
    {
        if(bluetoothAdapter == null || !bluetoothAdapter.isEnabled())
        {
            //turn BT on
            return new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        }
        else
        {
            //BT already on or adapter is null
            return  null;
        }
    }

    public void ScanDeviceLE(final boolean enable)
    {
        bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();

        if(enable)
        {
            bluetoothLeScanner.startScan(scanCallback);
        }
        else
        {
            StopScan();
        }
    }

    public void StopScan()
    {
        bluetoothLeScanner.stopScan(scanCallback);
    }

    private ScanCallback scanCallback = new ScanCallback()
    {
        @Override
        public void onScanResult(int callbackType, ScanResult result)
        {
            Log.i("TAG", "Device Found: " + result.getDevice().getName() + " " + result.getDevice().getAddress());
            iSelectDevice.AddDeviceToList(result.getDevice());
        }
    };
}
