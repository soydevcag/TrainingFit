package com.training.lequar.trainingfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.toolbox.JsonObjectRequest;
import com.training.lequar.trainingfit.Model.DTO.RegisterDTO;
import com.training.lequar.trainingfit.Model.Utilities.CustomVolleyRequestJson;

public class testJson extends AppCompatActivity  {

    private JsonObjectRequest getRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_image);
        TextView a = (TextView)findViewById(R.id.textView);
        RegisterDTO r = new RegisterDTO();
        a.setText(r.getName());

        getRequest = CustomVolleyRequestJson.getInstance(this.getApplicationContext()).getJson();


    }

}