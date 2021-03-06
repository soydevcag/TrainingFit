package com.training.lequar.trainingfit;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.training.lequar.trainingfit.Model.Utilities.Notifications;
import com.training.lequar.trainingfit.Model.Utilities.PermissionGPS;
import android.os.Build;
import android.support.v7.app.NotificationCompat;
import android.app.NotificationManager;

/**
 * Created by Camilo Arias on 29/04/16.
 */

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent service = new Intent(this, Notifications.class);

        startService(service);



        if(Build.VERSION.SDK_INT >= 6.0){
            //Solicitar permisos GPS
            PermissionGPS pGPS = new PermissionGPS();
            pGPS.setContext(this);
            pGPS.setActivity(MainActivity.this);
            pGPS.permissionGPS(pGPS.getContext());
        }


        Button btnRegister = (Button)findViewById(R.id.btnRegister);
        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        assert btnRegister != null;
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(
                        getBaseContext())
                        .setSmallIcon(R.drawable.danger)
                        .setContentTitle("Training")
                        .setContentText("Esto es una notificación")
                        .setWhen(System.currentTimeMillis());
                NotificationManager nManager = (NotificationManager) getSystemService(context.NOTIFICATION_SERVICE);
                nManager.notify(12345, builder.build());
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