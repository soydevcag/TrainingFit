package com.training.lequar.trainingfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnRegister = (Button)findViewById(R.id.inBtn);
        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        assert btnRegister != null;
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actionRegister = new Intent(Login.this, Home.class);
                startActivity(actionRegister);
            }
        });

    }
}
