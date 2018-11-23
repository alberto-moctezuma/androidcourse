package udg.mxc.aplication1;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import udg.mxc.aplication1.util.Util;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView mImageView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.showLog( TAG, "On Create" );
        mImageView = findViewById( R.id.imageView );
        mTextView = findViewById( R.id.textView );
        setupViews();
        readAssets();
    }

    private void readAssets() {
        try{
            InputStream inputStream = getAssets().open("ejemploTexto.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[ size ];
            inputStream.read( buffer );
            inputStream.close();
            String textoRecibido = new String( buffer );
            Util.showLog( TAG, textoRecibido );
        }catch ( IOException e){
            e.printStackTrace();
        }
    }

    private void setupViews() {
        mTextView.setText( R.string.text_string );
        mTextView.setTextColor( ContextCompat.getColor( MainActivity.this, R.color.colorText ) );
        mTextView.setBackgroundResource( R.color.colorBackgroundText );
        mImageView.setImageDrawable(ContextCompat.getDrawable( MainActivity.this, R.drawable.star ) );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Util.showLog( TAG, "On Start" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Util.showLog( TAG, "On Resume" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Util.showLog( TAG, "On Pause" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Util.showLog( TAG, "On Stop" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Util.showLog( TAG, "On Destroy" );
    }
}
