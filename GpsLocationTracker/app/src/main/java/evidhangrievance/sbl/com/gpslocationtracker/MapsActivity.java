package evidhangrievance.sbl.com.gpslocationtracker;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        LocationListener {

    private static final int RUNTIME_PERMISSION_LOCATION = 1312;

    private GoogleMap mMap;

    @BindView(R.id.tvStatus)
    TextView tvStatus;

    @BindView(R.id.btnGetLocation)
    Button btnGetLocation;

    String message = "";

    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);

        tvStatus = (TextView) findViewById(R.id.tvStatus);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        requestLocationServicePermission();
    }

    @Override
    public void onLocationChanged(Location location) {
        if(mMap == null) return;
        LatLng currentLocation = new LatLng( location.getLatitude(), location.getLongitude());
        mMap.addMarker(new MarkerOptions().position(currentLocation).title("" + count++));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,17.0f ));
//        mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
        setStatus("onLocationChanged");
    }

    private void requestLocationServicePermission() {
        setStatus("requestLocationServicePermission");
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            requestLocationService();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    RUNTIME_PERMISSION_LOCATION);
        }


    }

    private void requestLocationService() {
        setStatus("requestLocationService");
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(locationProvider, 0, 0, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RUNTIME_PERMISSION_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestLocationService();
                } else {
                }
                return;
            }
        }
    }

    private void setStatus( String message) {
//        appendStatus(message);
        this.message = message;
        tvStatus.setText(this.message);
    }

    private void appendStatus(String message) {
        this.message = this.message + message + "\n";
        tvStatus.setText(this.message);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        setStatus("onStatusChanged");
    }

    @Override
    public void onProviderEnabled(String provider) {
        setStatus("onProviderEnabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        setStatus("onProviderDisabled");
    }

}
