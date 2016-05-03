package com.training.lequar.trainingfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Camilo Arias on 29/04/16.
 */

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button btnRegister = (Button)findViewById(R.id.btnFlatMap);
        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        assert btnRegister != null;
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actionRegister = new Intent(Home.this, FlatMap.class);
                startActivity(actionRegister);
            }
        });

        Button btnStart = (Button)findViewById(R.id.btnImagenes);
        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        assert btnStart != null;
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actionLogin = new Intent(Home.this, testImage.class);
                startActivity(actionLogin);
            }
        });
    }
}