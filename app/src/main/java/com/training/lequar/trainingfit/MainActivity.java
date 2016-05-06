package com.training.lequar.trainingfit;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.training.lequar.trainingfit.Model.Utilities.PermissionGPS;

import java.security.Permission;

/**
 * Created by Camilo Arias on 29/04/16.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionGPS pGPS = new PermissionGPS();
        pGPS.setContext(this);
        pGPS.setActivity(MainActivity.this);
        pGPS.permissionGPS(pGPS.getContext());

        Button btnRegister = (Button)findViewById(R.id.btnRegister);
        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        assert btnRegister != null;
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent actionRegister = new Intent(MainActivity.this, Register.class);
                    startActivity(actionRegister);
            }
        });

        Button btnStart = (Button)findViewById(R.id.btnStart);
        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        assert btnStart != null;
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actionLogin = new Intent(MainActivity.this, Login.class);
                startActivity(actionLogin);
            }
        });
    }
}