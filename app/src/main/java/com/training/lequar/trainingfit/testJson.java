package com.training.lequar.trainingfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Request;
import android.util.Log;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import com.android.volley.VolleyError;
import com.training.lequar.trainingfit.Model.Utilities.Urls;
import android.app.ProgressDialog;

import org.json.JSONException;

public class testJson extends AppCompatActivity  {

    private JsonObjectRequest getRequest;
    Urls urls = new Urls();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_image);
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();

        final TextView txtDisplay = (TextView)findViewById(R.id.textView);
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = urls.getUsers();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                try {
                    Log.d("JsonArray",response.toString());
                    for(int i=0;i<response.length();i++){
                        JSONObject jresponse = response.getJSONObject("content");
                        JSONArray resultado = jresponse.getJSONArray("result");
                        String resultado1 = resultado.getString(i);
                        txtDisplay.append(resultado1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });

        queue.add(jsObjRequest);

        }
    }

