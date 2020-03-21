package com.example.kf7008assignment;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private Button backButton;
    private ListView deviceListView;
    private ArrayList<BluetoothDevice> devices;

    private SelectDevicePresenter selectDevicePresenter;

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

        backButton = view.findViewById(R.id.backButtonSelectDeviceFragment);
        if(backButton != null)
        {
            backButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
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
            });
        }

        try
        {
            selectDevicePresenter = new SelectDevicePresenter(this);
        }
        catch (Exception ex)
        {

        }

        deviceListView = view.findViewById(R.id.myDevicesList);
        devices = new ArrayList<>();
        android.widget.ArrayAdapter<BluetoothDevice> listAdapter = new android.widget.ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, devices);
        deviceListView.setAdapter(listAdapter);
    }

    @Override
    public void AddDeviceToList(BluetoothDevice bluetoothDevice)
    {
        devices.add(bluetoothDevice);
    }
}
