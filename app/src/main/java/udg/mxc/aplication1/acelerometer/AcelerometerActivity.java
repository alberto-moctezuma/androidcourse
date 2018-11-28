package udg.mxc.aplication1.acelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import udg.mxc.aplication1.R;

public class AcelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private float lastX, lastY, lastZ;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private float deltaXMax = 0;
    private float deltaYMax = 0;
    private float deltaZMax = 0;

    private float deltaX = 0;
    private float deltaY = 0;
    private float deltaZ = 0;

    private TextView currentX, currentY, currentZ, maxX, maxY, maxZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometer);
        initializeViews();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null ){
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, sensorManager.SENSOR_DELAY_NORMAL);
        }else{

        }
    }

    private void initializeViews() {
        currentX = findViewById(R.id.currentX);
        currentY = findViewById(R.id.currentY);
        currentZ = findViewById(R.id.currentZ);

        maxX = findViewById(R.id.maxX);
        maxY = findViewById(R.id.maxY);
        maxZ = findViewById(R.id.maxZ);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // clean current values
        displayCleanValues();
        // display the current x, y, z accelerometer values
        displayCurrentValues();
        // display the max x,y,z accelerometer values
        displayMaxValues();

        deltaX = Math.abs(lastX - event.values[0]);
        deltaY = Math.abs(lastY - event.values[1]);
        deltaZ = Math.abs(lastZ - event.values[2]);

        if(deltaX < 2)
            deltaX = 0;
        if(deltaY < 2)
            deltaY = 0;
        if(deltaZ < 2)
            deltaZ = 0;

        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];
    }

    private void displayCleanValues() {
        currentX.setText("0.0");
        currentY.setText("0.0");
        currentZ.setText("0.0");
    }

    private void displayCurrentValues() {
        currentX.setText(String.valueOf(deltaX));
        currentY.setText(String.valueOf(deltaY));
        currentZ.setText(String.valueOf(deltaZ));
    }

    public void displayMaxValues(){
        if(deltaX > deltaXMax){
            deltaXMax = deltaX;
            maxX.setText(String.valueOf(deltaXMax));
        }
        if(deltaY > deltaYMax){
            deltaYMax = deltaY;
            maxY.setText(String.valueOf(deltaYMax));
        }
        if(deltaZ > deltaZMax){
            deltaZMax = deltaZ;
            maxZ.setText(String.valueOf(deltaZMax));
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
