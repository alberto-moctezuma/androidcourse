package udg.mxc.aplication1.simpsonsActivity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import udg.mxc.aplication1.R;
import udg.mxc.aplication1.components.ComponentsActivity;
import udg.mxc.aplication1.util.Util;

public class ImageComponent extends AppCompatActivity{

    private static final String TAG = ComponentsActivity.class.getSimpleName();
    private TextView mtextViewImage;
    private ImageView mImageViewGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_component);
        mtextViewImage = findViewById( R.id.textViewImage );
        mImageViewGallery = findViewById( R.id.imageViewGallery );
    }

    public void clicked( View view ){
        switch ( view.getId() ){
            case R.id.button1:
                setItem( getString(R.string.moe),  R.drawable.moe, R.color.red );
                break;
            case R.id.button2:
                setItem( getString(R.string.homer),  R.drawable.homer, R.color.yellow );
                break;
            case R.id.linearLayout1:
                setItem( getString(R.string.lisa),  R.drawable.lisa, R.color.green );
                break;
            case R.id.linearLayout2:
                setItem( getString(R.string.bart),  R.drawable.bart, R.color.blue );
                break;
        }
    }

    public void setItem( String message, int imgId, int colorId ){
        Util.showLog( TAG, message);
        mtextViewImage.setText( message  );
        mtextViewImage.setTextColor( getResources().getColor( colorId ) );
        mImageViewGallery.setImageDrawable( ContextCompat.getDrawable( ImageComponent.this,imgId ) );
    }
}
