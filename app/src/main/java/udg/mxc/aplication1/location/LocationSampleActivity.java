package udg.mxc.aplication1.location;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import butterknife.BindView;
import butterknife.ButterKnife;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.KeysConstants;
import udg.mxc.aplication1.util.Util;

public class LocationSampleActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    public static String TAG = LocationSampleActivity.class.getSimpleName();

    @BindView( R.id.textViewLocation ) TextView textViewLocation;
    @BindView( R.id.progressBarLocation ) ProgressBar progressBarLocation;

    FusedLocationProviderClient mFusedLocationProviderClient;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_sample);
        ButterKnife.bind(this);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        buildGoogleApiClient();
    }

    private void buildGoogleApiClient() {

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.reconnect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int response = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if( response != ConnectionResult.SUCCESS ){
            Util.showLog(TAG, "Google Play Service Not Available");
            GoogleApiAvailability.getInstance().getErrorDialog( LocationSampleActivity.this, response, 1 ).show();
        }else{
            if( mGoogleApiClient != null && mFusedLocationProviderClient != null ){
                requestLocationUpdates();
            }else{
                buildGoogleApiClient();
            }
            Util.showLog(TAG, "Google play services available");
        }
    }

    public void requestLocationUpdates(){
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(2000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mFusedLocationProviderClient.requestLocationUpdates(mLocationRequest, mLocationCallBack, Looper.myLooper());
        }else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, KeysConstants.LOCATION_PERMISION_ID);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if( mFusedLocationProviderClient != null ){
            mFusedLocationProviderClient.removeLocationUpdates(mLocationCallBack);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    LocationCallback mLocationCallBack = new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location : locationResult.getLocations()){
                Util.showLog(TAG, "Location: "+location.getLatitude()
                        +" "+location.getLongitude());
                textViewLocation.setText(Util.getEmojiByUnicode(0x1F680)
                        +Util.getEmojiByUnicode(0x1F680)+"Location: "
                        +location.getLatitude()+location.getLongitude());
                progressBarLocation.setVisibility(View.GONE);
            }
        }
    };

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Util.showLog(TAG, "onConnected");
        requestLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Util.showLog(TAG, "onConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Util.showLog(TAG, "onConnectionFailed");
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case KeysConstants.LOCATION_PERMISION_ID:{
                if( grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ) {
                    if( ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ){
                        onResume();
                    }else{
                        showPopup();
                    }
                }

                return;
            }
        }
    }

    private void showPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Permiso necesario" )
                .setMessage("Es necesario seleccionar el permiso para que funcione la aplicación")
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
        builder.show();
    }
}
