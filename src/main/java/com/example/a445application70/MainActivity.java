package com.example.a445application70;
//package net.bane.a445application70;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
//import android.support.v7.app.AppCompatActivity;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView battery;
    Button refresh;
//    TextView out;
    static final UUID mUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // Bluetooth universal identifier
    public int count2 = 0;
//    public byte full = 92;

//    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        out = (TextView)findViewById(R.id.test);
        battery = (ImageView)findViewById(R.id.battery_icon);
        byte level = 92;

        // Bluetooth Code
//        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
//        BluetoothDevice hc05 = btAdapter.getRemoteDevice("98:D3:91:FD:F5:4F");
////        out.setText(hc05.getName()); // Test
//
//        // Loop to connect phone to HC-05
//        BluetoothSocket btSocket = null;
//        int counter = 0;
//        do {
//            try {
//                btSocket = hc05.createInsecureRfcommSocketToServiceRecord(mUUID);
//                BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
//                btSocket.connect();
//            } catch (IOException e) {}
//            counter++;
//        } while (counter < 3 && btSocket.isConnected() == false);
//
////        if (btSocket.isConnected() == true) {
////            out.setText("Socket Connected");
////        } else {
////            out.setText("Socket Failed");
////        }
//
//        // Communicating Data
//        int count = 0;
//        try {
//            OutputStream outputStream = btSocket.getOutputStream();
//            if (count == 0) {
//                outputStream.write(48);
//            }
//            if (count == 1) {
//                outputStream.write(49);
//            }
//            if (count == 2) {
//                outputStream.write(50);
//            }
//            outputStream.write(51);
//        } catch (IOException e) {}
//
//        InputStream inputStream = null;
//        try {
//            inputStream = btSocket.getInputStream();
//            inputStream.skip(inputStream.available());
//            level = (byte)inputStream.read();
//        } catch (IOException e) {}

        battery.setImageLevel(level);
        battery.setImageResource(R.drawable.battery_icon);

        refresh = (Button)findViewById(R.id.refresh);
        refresh.setOnClickListener(this);

        // Close connection b/w HC-05 & phone
//        try {
//            btSocket.close();
//        } catch (IOException e) {}

        ///////////////////////////////////////////////////////////////////
//         Show Battery Image
//        battery = (ImageView)findViewById(R.id.battery_icon);
//        battery.setImageLevel(level);
//        battery.setImageResource(R.drawable.battery_icon);
//
//        if (level <= 100 && level > 75) {
//            battery.setImageResource(R.drawable.battery100);
//        }
//        else if (level <= 75 && level > 50) {
//            battery.setImageResource(R.drawable.battery75);
//        }
//        else if (level <= 50 && level > 25) {
//            battery.setImageResource(R.drawable.battery50);
//        }
//        else {
//            battery.setImageResource(R.drawable.battery25);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.refresh) {
            byte level2 = 0;
//            count2 = count2 + 1;

            BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
            BluetoothDevice hc05 = btAdapter.getRemoteDevice("98:D3:91:FD:F5:4F");
            BluetoothSocket btSocket = null;
            int counter = 0;
            do {
                try {
                    btSocket = hc05.createInsecureRfcommSocketToServiceRecord(mUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();
                } catch (IOException e) {}
                counter++;
            } while (counter < 3 && btSocket.isConnected() == false);

//            if (btSocket.isConnected() == true) {
//                out.setText("Socket Connected");
//            } else {
//                out.setText("Socket Failed");
//            }

//            try {
//                OutputStream outputStream = btSocket.getOutputStream();
//                if (count2 == 0) {
//                    outputStream.write(48);
//                }
//                if (count2 == 1) {
//                    outputStream.write(49);
//                }
//                if (count2 == 2) {
//                    outputStream.write(50);
//                }
//                if (count2 == 3) {
//                    outputStream.write(51);
//                }
//                else {
//                    outputStream.write(48);
//                }
//            } catch (IOException e) {}

            OutputStream outputStream = null;
            try {
                outputStream = btSocket.getOutputStream();
                outputStream.write(48);
            } catch (IOException e) {}

            InputStream inputStream = null;
            try {
                inputStream = btSocket.getInputStream();
                inputStream.skip(inputStream.available());
                level2 = (byte)inputStream.read();
            } catch (IOException e) {}

            battery.setImageLevel(level2);
            battery.setImageResource(R.drawable.battery_icon);

            try {
                btSocket.close();
            } catch (IOException e) {}
        }
    }
}

