package udg.mxc.aplication1.components;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.Util;

public class ComponentsActivity extends AppCompatActivity{

    private static final String TAG = ComponentsActivity.class.getSimpleName();
    private ImageView mImageView;
    private TextInputEditText mPasswordInput;
    private CheckBox mChkCondiciones;
    private RadioGroup mRgSexo;
    private Switch mSwAutodestruccion;
    private ProgressBar mProgressBar;
    private ScrollView mScrollView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);
        initialize();
        setupImageView();
        setupCheckbox();
        setUpRadioGroup();
        setUpSwitch();
    }

    public void clicked( View view ){
        switch ( view.getId() ){
            case R.id.firstButton:
                Util.showLog( TAG, "First button click" );
                if( !mPasswordInput.toString().isEmpty() ){
                    showSnackBar( "La contraseña: "+mPasswordInput.getText().toString() );
                }
                break;
            case R.id.secondButton:
                Util.showLog( TAG, "Second button click" );
                break;
            case R.id.thirdButton:
                Util.showLog( TAG, "Third button click" );
                break;
        }
    }

    private void initialize(){
        mImageView = findViewById( R.id.imageView );
        mPasswordInput = findViewById( R.id.textInputEdit );
        mChkCondiciones = findViewById( R.id.chkbCondiciones );
        mRgSexo = findViewById( R.id.rgSexo);
        mSwAutodestruccion = findViewById( R.id.swAutodestruccion);
        mProgressBar = findViewById( R.id.progressBar );
        mScrollView = findViewById( R.id.scrollViewComponents );
        context = this;
    }

    // También se puede usar picasso pero es mas robusto
    private void setupImageView(){
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable( this );
        circularProgressDrawable.setStrokeWidth( 20f );
        circularProgressDrawable.setCenterRadius( 60f );
        circularProgressDrawable.setColorFilter(ContextCompat.getColor( context, R.color.colorAccent ), PorterDuff.Mode.SRC_ATOP );
        circularProgressDrawable.start();
        Glide.with( context )
                .load( "https://media.giphy.com/media/xT77XKlezDkZXq7a2k/giphy.gif" )
                .centerCrop()
                .crossFade(5000)
                .placeholder( circularProgressDrawable )
                .into( mImageView );
    }

    private void setupCheckbox(){
        mChkCondiciones.setOnCheckedChangeListener( onCheckedChangeListener  );
    }

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener= new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            showSnackBar( "Check the box: "+isChecked );
        }
    };

    private void setUpRadioGroup(){
        mRgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch ( checkedId ) {
                    case R.id.rbHombre:
                        showToast( context, "Your selected Hombre" );
                        break;
                    case R.id.rbMujer:
                        showToast( context, "Your selected Mujer" );
                        break;
                }

            }
        });
    }

    private void setUpSwitch(){
        mSwAutodestruccion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked ){
                    showToast( context, "Switch has turn on" );
                }else{
                    showToast( context, "Switch has turn off" );
                }
                showHideProgressBar();
            }
        });
    }

    private void showHideProgressBar(){
        if( mProgressBar.getVisibility() == View.VISIBLE ){
            mProgressBar.setVisibility( View.GONE );
        }else{
            mProgressBar.setVisibility( View.VISIBLE );
        }
    }

    public void showSnackBar( String message ){
        Snackbar.make( mScrollView, message, Snackbar.LENGTH_LONG )
                .show();
    }

    public void showToast( Context context, String message ){
        Toast.makeText( context, message, Toast.LENGTH_LONG ).show();
    }
}
