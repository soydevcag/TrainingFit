package com.training.lequar.trainingfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.training.lequar.trainingfit.Model.Utilities.CustomVolleyRequestJson;

public class testJson extends AppCompatActivity  {

    private EditText editTextUrl;
    private JsonObjectRequest getRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_image);

        getRequest = CustomVolleyRequestJson.getInstance(this.getApplicationContext()).getJson();
        TextView a = (TextView)findViewById(R.id.textView);

    }

}