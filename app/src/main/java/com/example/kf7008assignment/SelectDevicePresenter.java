package com.example.kf7008assignment;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

public class SelectDevicePresenter
{
    private ISelectDevicePresenter iSelectDevicePresenter;

    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bluetoothLeScanner;
    private BluetoothGatt bluetoothGatt;    //used for device connection

    public SelectDevicePresenter(ISelectDevicePresenter iSelectDevicePresenter)
    {
        if(iSelectDevicePresenter == null)
        {
            throw new IllegalStateException("Select device presenter cant be null.");
        }

        this.iSelectDevicePresenter = iSelectDevicePresenter;
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
        if(!bluetoothAdapter.isEnabled() || bluetoothAdapter == null)
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
            bluetoothLeScanner.stopScan(scanCallback);
        }
    }

    private ScanCallback scanCallback = new ScanCallback()
    {
        @Override
        public void onScanResult(int callbackType, ScanResult result)
        {
            Log.i("TAG", "Device Found: " + result.getDevice().getName() + " " + result.getDevice().getAddress());
            iSelectDevicePresenter.AddDeviceToList(result.getDevice());
        }
    };

    public void ConnectToDevice(final BluetoothDevice bluetoothDevice, Context context)
    {
//        boolean result = iSelectDevice.AlertDialog("Connect to: " + bluetoothDevice.getName()
//                , "Do You want to connect to: " + bluetoothDevice.getName());
//        Log.i("TAG", "Result: " + result);
//        if(result)
//        {
//            ScanDeviceLE(false);
//
//            ConnectedDevice.GetInstance().SetConnectedDevice(bluetoothDevice);
//
//              /*
//            if(bluetoothGatt == null)
//            {
//                bluetoothGatt = bluetoothDevice.connectGatt(context, false, someCallBack)
//            }
//             */
//
//              iSelectDevice.GoToMyDeviceFragment();
//        }
        new AlertDialog.Builder(context).setTitle("Connect to: " + bluetoothDevice.getName())
                .setMessage("Do you want to connect to: " + bluetoothDevice.getName())
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        ScanDeviceLE(false);

                        ConnectedDevice.GetInstance().SetConnectedDevice(bluetoothDevice);

                          /*
                        if(bluetoothGatt == null)
                        {
                            bluetoothGatt = bluetoothDevice.connectGatt(context, false, someCallBack)
                        }
                         */

                        //go to my device
                        iSelectDevicePresenter.GoToMyDeviceFragment();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
