package com.training.lequar.trainingfit;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Build;
import com.google.android.gms.maps.MapFragment;

public class FlatMap extends FragmentActivity implements OnMapReadyCallback {
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flat_map);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(FlatMap.this);
    }
    @Override
    public void onMapReady(GoogleMap map) {
        progressDialog.dismiss();
        // Add a marker and move the camera.
        LatLng sydney = new LatLng(4, -74);
        map.addMarker(new MarkerOptions().position(sydney).title("Bogotá"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}