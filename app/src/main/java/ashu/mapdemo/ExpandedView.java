package ashu.mapdemo;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by apple on 26/12/16.
 */

public class ExpandedView extends AppCompatActivity implements OnMapReadyCallback {

    private Intent intent;
    private GoogleMap mMap;
    private LatLng location;
    private TextView txtView;
    private ImageView imgView;
    private String latlng;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customview);
        intent = getIntent();
        latlng = intent.getExtras().getString("latlng");

        Log.d("value", latlng + "val");
        latlng = latlng.replace("(","");
        latlng = latlng.replace(")", "");
        latlng = latlng.replace("lat/lng: ", "");
        String[] latlong =  latlng.split(",");
        latitude = Double.parseDouble(latlong[0]);
        longitude = Double.parseDouble(latlong[1]);

        location = new LatLng(latitude, longitude);
        txtView = (TextView) findViewById(R.id.textView);

        imgView = (ImageView) findViewById(R.id.imgView);

        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cityName = addresses.get(0).getAddressLine(0);
        String stateName = addresses.get(0).getAddressLine(1);
        String countryName = addresses.get(0).getAddressLine(2);
        mMap.addMarker(new MarkerOptions().position(location).title(cityName + "&&" + stateName)).showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 4.0f));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                imgView.setVisibility(View.GONE);
                txtView.setVisibility(View.GONE);
            }
        });
    }
}
