package com.training.lequar.trainingfit;

import android.app.ProgressDialog;
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
import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {
    Urls urls = new Urls();
    Context context = this;
    String message = null;
    boolean valid = true;

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
                assert name != null;
                final EditText lastName = (EditText) findViewById(R.id.lastName);
                assert lastName != null;
                final EditText phone = (EditText) findViewById(R.id.phone);
                assert phone != null;
                final EditText email = (EditText) findViewById(R.id.email);
                assert email != null;
                final EditText pass = (EditText) findViewById(R.id.pass);
                assert pass != null;
                if (name.getText().toString().length() == 0) {
                    name.setError("Ingresa tu nombre");
                    valid = false;
                }else{
                    valid = true;
                }
                if (lastName.getText().toString().length() == 0){
                    lastName.setError("Ingresa tu apellido");
                    valid = false;
                }else{
                    valid = true;
                }
                if (phone.getText().toString().length() == 0){
                    phone.setError("Ingresa tu número");
                    valid = false;
                }else{
                    valid = true;
                }
                if (email.getText().toString().length() == 0){
                    email.setError("Ingresa tu correo electrónico");
                    valid = false;
                }else{
                    valid = true;
                }
                if (pass.getText().toString().length() == 0){
                    pass.setError("Ingresa un contraseña");
                    valid = false;
                }else{
                        valid = true;
                        }
                Log.d("Error", String.valueOf(valid));
                if (valid) {
                    final ProgressDialog progressDialog;
                    progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage("Registrando...");
                    progressDialog.show();
                    String url = urls.getRegisterUser();
                    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    progressDialog.dismiss();
                                    try {
                                        JSONObject jsonObject = new JSONObject(response.toString());
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
                                            Intent actionRegister = new Intent(Register.this, Login.class);
                                            startActivity(actionRegister);
                                        }
                                    }.start();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    progressDialog.dismiss();
                                    // error
                                    //Log.d("Error.Response", response);
                                }
                            }
                    ) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
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
            }
        });
    }

}