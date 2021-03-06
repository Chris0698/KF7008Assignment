package com.example.kf7008assignment;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyDeviceFragment extends Fragment implements IMyDevicePresenter
{
    private TextView deviceNameTextView;
    private TextView deviceAddressTextView;
    private Button connectButton;

    private MyDevicePresenter myDevicePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.my_device_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState)
    {
        deviceNameTextView = view.findViewById(R.id.deviceNameTextView);
        deviceAddressTextView = view.findViewById(R.id.deviceAddressTextView);

        connectButton = view.findViewById(R.id.deviceButton);
        if(connectButton != null)
        {
            connectButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    BluetoothDevice connectedDevice = myDevicePresenter.GetConnectedDevice();
                    if(connectedDevice == null)
                    {
                        FragmentManager fragmentManager = getFragmentManager();
                        if(fragmentManager != null)
                        {
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragmentContainer, new SelectDeviceFragment());
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    }
                    else
                    {
                        myDevicePresenter.DisconnectFromDevice();
                    }
                }
            });
        }

        try
        {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("My Device");

            myDevicePresenter = new MyDevicePresenter(this);

            myDevicePresenter.GetConnectedDeviceStatus();
        }
        catch (Exception ex)
        {
            Log.i("TAG", "Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void SetDeviceName(String name)
    {
        deviceNameTextView.setText(name);
    }

    @Override
    public void SetDeviceAddress(String address)
    {
        deviceAddressTextView.setText(address);
    }

    @Override
    public void SetButtonText(String text)
    {
        connectButton.setText(text);
    }
}
