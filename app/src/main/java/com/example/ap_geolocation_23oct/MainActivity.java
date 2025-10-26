package com.example.ap_geolocation_23oct;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap myMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady (GoogleMap googleMap){
        myMap = googleMap;
        LatLng miCasa=new LatLng(-17.715139133386796, -63.175946759898714);
        //myMap.addMarker(new MarkerOptions().position(santacCruz).title("Mi casita"));
        MarkerOptions markerOptions = new MarkerOptions()
                .position(miCasa)
                .title("Mi Casa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.casaic));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(miCasa));
        MarkerOptions options = new MarkerOptions().position(miCasa).title("Mi Casita");
        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        myMap.addMarker(options);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture){
        super.onPointerCaptureChanged(hasCapture);
    }
}