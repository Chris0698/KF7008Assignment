package com.example.kf7008assignment;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class SelectDeviceFragment extends Fragment implements ISelectDevice
{
    private ArrayList<BluetoothDevice> devices;
    private ArrayAdapter<BluetoothDevice> deviceListAdapter;
    private SelectDevicePresenter selectDevicePresenter;

    private final int ENABLE_BLUETOOTH = 1;     //need a positivite int

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.select_device_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        TextView fragmentHeader = view.findViewById(R.id.fragmentHeading);
        if(fragmentHeader != null)
        {
            fragmentHeader.setText("Select Device");
        }

        devices = new ArrayList<>();

        Button backButton = view.findViewById(R.id.backButtonSelectDeviceFragment);
        if(backButton != null)
        {
            backButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    selectDevicePresenter.StopScan();
                    FragmentManager fragmentManager = getFragmentManager();
                    if(fragmentManager != null)
                    {
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainer, new MyDeviceFragment());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                }
            });
        }

        try
        {
            selectDevicePresenter = new SelectDevicePresenter(this);
        }
        catch (Exception ex)
        {

        }

        ListView deviceListView = view.findViewById(R.id.myDevicesList);
        if(deviceListView != null)
        {
            deviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    BluetoothDevice bluetoothDevice = devices.get(position);
                    selectDevicePresenter.ConnectToDevice(bluetoothDevice, getContext());
                }
            });
        }


        deviceListAdapter = new ArrayAdapter<BluetoothDevice>(getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1 ,devices)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView deviceName = view.findViewById(android.R.id.text1);
                TextView deviceAddress = view.findViewById(android.R.id.text2);

                deviceName.setText(devices.get(position).getName());
                deviceAddress.setText(devices.get(position).getAddress());

                return view;
            }
        };

        deviceListView.setAdapter(deviceListAdapter);

        selectDevicePresenter.InitialiseBluetoothLE(getContext());
        boolean bluetoothEnabled = selectDevicePresenter.IsBluetoothEnabled();
        if(!bluetoothEnabled)
        {
            Intent enableBluetoothIntent = selectDevicePresenter.EnableBluetoothLEIntent();
            if(enableBluetoothIntent != null)
            {
                //bluetooth is not enabled, turn it on here
                //A request message will appear to enable BT,
                //check onActivityResult
                startActivityForResult(enableBluetoothIntent, ENABLE_BLUETOOTH);
            }
        }
        else
        {
            selectDevicePresenter.ScanDeviceLE(true);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        //pop up box will appear to enable BT
        if(requestCode == ENABLE_BLUETOOTH)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                selectDevicePresenter.ScanDeviceLE(true);
            }
        }
    }

    @Override
    public void AddDeviceToList(BluetoothDevice bluetoothDevice)
    {
        devices.add(bluetoothDevice);
        deviceListAdapter.notifyDataSetChanged();
    }

    @Override
    public void GoToMyDeviceFragment()
    {
        FragmentManager fragmentManager = getFragmentManager();
        if(fragmentManager != null)
        {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, new MyDeviceFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
