package com.training.lequar.trainingfit.Model.Utilities;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.Request;
import android.util.Log;

import org.json.JSONObject;
import com.android.volley.VolleyError;
import com.training.lequar.trainingfit.Model.DTO.RegisterDTO;

import org.json.JSONException;
/**
 * Created by Belal on 10/8/2015.
 */

public class CustomVolleyRequestJson {
    public interface VolleyCallback {
        void onSuccessResponse(String result);
    }

    private static CustomVolleyRequestJson customVolleyRequestJson;
    private static Context context;
    private RequestQueue requestQueue;
    private JsonObjectRequest getRequest;

    private CustomVolleyRequestJson(Context context) {
        final VolleyCallback callback = null;
        this.context = context;
        this.requestQueue = getRequestQueue();
        final String url = "http://appslequar.com/crud_api/app/controller/php/petitions/users.php";


// prepare the Request
        getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        try {
                            Log.d("JsonArray",response.toString());
                            for(int i=0;i<response.length();i++){
                                JSONObject jresponse = response.getJSONObject("headers");
                                String resultado = jresponse.getString("Direccion ip");
                                Log.d("nickname",resultado);
                                callback.onSuccessResponse(resultado);
                                RegisterDTO s = new RegisterDTO();
                                s.setName(resultado);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        );
        requestQueue.add(getRequest);
    }




    public static synchronized CustomVolleyRequestJson getInstance(Context context) {
        if (customVolleyRequestJson == null) {
            customVolleyRequestJson = new CustomVolleyRequestJson(context);
        }
        return customVolleyRequestJson;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            Cache cache = new DiskBasedCache(context.getCacheDir(), 10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            requestQueue = new RequestQueue(cache, network);
            requestQueue.start();
        }
        return requestQueue;
    }
    public JsonObjectRequest getJson() {
        return getRequest;
    }

}