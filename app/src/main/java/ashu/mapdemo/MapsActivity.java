package ashu.mapdemo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ViewPager pager;
    private static int on = 0;
    private Marker m1;
    private Marker m2;
    private Marker m3;
    private Marker m4;
    private Marker m5;
    private Marker m6;
    private Marker m7;
    private Marker m8;

    private static int selectedIndex = 0;

    private AdapterPager adapterPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        pager = (ViewPager) findViewById(R.id.pager);
        adapterPager = new AdapterPager(getApplicationContext());
        pager.setAdapter(adapterPager);

        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                selectedIndex = position;
                drawMap();
            }
        });




    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        drawMap();
    }

    private void drawMap(){
        // Add a marker in Sydney and move the camera
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                selectPager(marker);
                return true;
            }
        });

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if(on == 0) {
                    pager.setVisibility(View.GONE);
                    on = 1;
                }
                else {
                    pager.setVisibility(View.VISIBLE);
                    on = 0;
                }
            }
        });
        setLatLong(selectedIndex);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(returnPosition(selectedIndex)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(returnPosition(selectedIndex), 4.0f));
    }

    private LatLng returnPosition(int index){
        LatLng sydney = new LatLng(-34, 151);
        LatLng a1 = new LatLng(-30, 152);
        LatLng a2 = new LatLng(-27, 147);
        LatLng a3 = new LatLng(-25, 149);
        LatLng a4 = new LatLng(-29, 141);
        LatLng a5 = new LatLng(-29, 144);
        LatLng a6 = new LatLng(-29, 131);
        LatLng a7 = new LatLng(-29, 121);
        switch (index){
            case 0: return sydney;
            case 1: return a1;
            case 2: return a2;
            case 3: return a3;
            case 4: return a4;
            case 5: return a5;
            case 6: return a6;
            case 7: return a7;

        }

        return sydney;
    }

    private void setLatLong(int index){
        LatLng sydney = new LatLng(-34, 151);
        LatLng a1 = new LatLng(-30, 152);
        LatLng a2 = new LatLng(-27, 147);
        LatLng a3 = new LatLng(-25, 149);
        LatLng a4 = new LatLng(-29, 141);
        LatLng a5 = new LatLng(-29, 144);
        LatLng a6 = new LatLng(-29, 131);
        LatLng a7 = new LatLng(-29, 121);

        m1 = mMap.addMarker(new MarkerOptions().position(sydney).title("Koramangala"));
        m2 = mMap.addMarker(new MarkerOptions().position(a1).title("Basawangudi"));
        m3 = mMap.addMarker(new MarkerOptions().position(a2).title("Kirana Store"));
        m4 = mMap.addMarker(new MarkerOptions().position(a3).title("Mysmartprice"));
        m5 = mMap.addMarker(new MarkerOptions().position(a4).title("Meghana Biryani"));
        m6 = mMap.addMarker(new MarkerOptions().position(a5).title("Dangal"));
        m7 = mMap.addMarker(new MarkerOptions().position(a6).title("Sultan"));
        m8 = mMap.addMarker(new MarkerOptions().position(a7).title("Cricket"));

        switch (index){
            case 0:
                setIconColor(m1);
                break;
            case 1:
                setIconColor(m2);
                break;
            case 2:
                setIconColor(m3);
                break;
            case 3:
                setIconColor(m4);
                break;
            case 4:
                setIconColor(m5);
                break;
            case 5:
                setIconColor(m6);
                break;
            case 6:
                setIconColor(m7);
                break;
            case 7:
                setIconColor(m8);
                break;

        }
    }

    private void setIconColor(Marker m){
        m1.hideInfoWindow();
        m2.hideInfoWindow();
        m3.hideInfoWindow();
        m4.hideInfoWindow();
        m5.hideInfoWindow();
        m6.hideInfoWindow();
        m7.hideInfoWindow();
        m8.hideInfoWindow();

        m.showInfoWindow();
        m1.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        m2.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        m3.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        m4.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        m5.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        m6.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        m7.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        m8.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        m.setIcon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
    }

    private void selectPager(Marker m){
        if(m.getTitle().contains("Koramangala")) {
            pager.setCurrentItem(0, true);
            selectedIndex = 0;
        }
        if(m.getTitle().contains("Basawangudi")) {
            pager.setCurrentItem(1, true);
            selectedIndex = 1;
        }
        if(m.getTitle().contains("Kirana")) {
            pager.setCurrentItem(2, true);
            selectedIndex = 2;
        }
        if(m.getTitle().contains("Mysmartprice")) {
            selectedIndex = 3;
            pager.setCurrentItem(3,true);
        }
        if(m.getTitle().contains("Meghana")) {
            pager.setCurrentItem(4,true);
            selectedIndex = 4;
        }
        if(m.getTitle().contains("Dangal")) {
            selectedIndex = 5;
            pager.setCurrentItem(5, true);
        }
        if(m.getTitle().contains("Sultan")) {
            selectedIndex = 6;
            pager.setCurrentItem(6, true);
        }
        if(m.getTitle().contains("Cricket")) {
            selectedIndex = 7;
            pager.setCurrentItem(7, true);
        }

    }
}
