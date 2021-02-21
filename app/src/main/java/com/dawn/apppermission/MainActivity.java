package com.dawn.apppermission;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dawn.apppermission.permission.PermissionListener;
import com.dawn.apppermission.permission.PermissionUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String[] permissions = new String[]{
            Manifest.permission.CALL_PHONE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_hello_world = findViewById(R.id.tv_hello_world);
        tv_hello_world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission();
            }
        });
    }

    public void requestPermission(){
        PermissionUtil permissionUtil = new PermissionUtil(this);
        permissionUtil.requestPermissions(permissions, new PermissionListener() {
            @Override
            public void onGranted() {
                Toast.makeText(MainActivity.this,"onGranted",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDenied(List<String> deniedPermission) {
                Toast.makeText(MainActivity.this,"onDenied",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShouldShowRationale(List<String> deniedPermission) {
                Toast.makeText(MainActivity.this,"onShouldShowRationale",Toast.LENGTH_SHORT).show();
            }
        });
    }
}