package com.example.kf7008assignment;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
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
    private BluetoothGatt bluetoothGatt;    //used for device connection

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

    public boolean IsBluetoothEnabled()
    {
        if(bluetoothAdapter == null)
        {
            //no BT support
            return false;
        }
        else if(!bluetoothAdapter.isEnabled())
        {
            return false;
        }
        else
        {
            //BT enabled
            return true;
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

    public void ConnectToDevice(BluetoothDevice bluetoothDevice, Context context, Activity activity)
    {
        //we going to fake connection here
        StopScan();

          /*
        if(bluetoothGatt == null)
        {
            bluetoothGatt = bluetoothDevice.connectGatt(context, false, someCallBack)
        }
         */

        ConnectedDevice.GetInstance().SetConnectedDevice(bluetoothDevice);

       // new DeviceConnectedAlertScreen().show();
    }
}
