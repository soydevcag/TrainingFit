package com.training.lequar.trainingfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.Map;
import java.util.HashMap;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.training.lequar.trainingfit.Model.Utilities.Urls;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.content.Context;
import android.os.CountDownTimer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {
    Urls urls = new Urls();
    Context context = this;
    String message = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button btnRegister = (Button)findViewById(R.id.registerBtn);
        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        assert btnRegister != null;
        final RequestQueue queue = Volley.newRequestQueue(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText name = (EditText) findViewById(R.id.name);
                final EditText lastName = (EditText) findViewById(R.id.lastName);
                final EditText phone = (EditText) findViewById(R.id.phone);
                final EditText email = (EditText) findViewById(R.id.email);
                final EditText pass = (EditText) findViewById(R.id.pass);

                String url = urls.getRegisterUser();
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject= new JSONObject(response.toString());
                                    JSONObject objt = jsonObject.getJSONObject("content");
                                    message = objt.getString("status");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                final AlertDialog.Builder dialog = new AlertDialog.Builder(context)
                                        .setTitle("Genial").setMessage(
                                                message);
                                dialog.setPositiveButton("Ok",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                dialog.dismiss();

                                            }
                                        });
                                final AlertDialog alert = dialog.create();
                                alert.show();

                                new CountDownTimer(3000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        name.setText("");
                                        lastName.setText("");
                                        pass.setText("");
                                        email.setText("");
                                        phone.setText("");
                                    }

                                    @Override
                                    public void onFinish() {
                                        alert.dismiss();
                                    }
                                }.start();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                //Log.d("Error.Response", response);
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("name", name.getText().toString());
                        params.put("user", lastName.getText().toString());
                        params.put("password", pass.getText().toString());
                        params.put("city", email.getText().toString());
                        params.put("phone", phone.getText().toString());

                        return params;
                    }
                };
                queue.add(postRequest);
            }
        });
    }

}