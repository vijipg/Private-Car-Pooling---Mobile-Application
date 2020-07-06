package com.example.samee.carpooling;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("sp");
        String text1 = bundle.getString("dp");
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%s&daddr=%s", text, text1);//Uri.parse("google.navigation:q=Velachery");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void onpanic(View view) {
        if (view.getId() == R.id.panic) {
            Intent intent = new Intent(Intent.ACTION_DIAL);

            intent.setData(Uri.parse("tel:100"));
            startActivity(intent);

        }
    }

    public void onalert(View view) {
        if (view.getId() == R.id.alert) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:7904298391"));
            Intent intent1 = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:9677266590"));
            intent.putExtra("sms_body", "i am late");
            intent1.putExtra("sms_body", "i am late");
            startActivity(intent1);
            startActivity(intent);
        }


    }


    public void onalarm(View view) {
        if (view.getId() == R.id.alarm) {

            Intent intent2 = new Intent(Intent.ACTION_DIAL);
            intent2.setData(Uri.parse("tel:108"));
            startActivity(intent2);


        }}
        public void onfeedback (View view){
            if (view.getId() == R.id.feedback) {

                Intent intent3 = new Intent(MapsActivity.this, feedback.class);
                startActivity(intent3);


            }
        }
    public void onview (View view){
        if (view.getId() == R.id.view) {

            Intent intent3 = new Intent(MapsActivity.this, details.class);
            startActivity(intent3);


        }
    }


}