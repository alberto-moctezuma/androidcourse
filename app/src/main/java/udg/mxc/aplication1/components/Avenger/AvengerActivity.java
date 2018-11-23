package udg.mxc.aplication1.components.Avenger;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import udg.mxc.aplication1.R;
import udg.mxc.aplication1.components.ComponentsActivity;
import udg.mxc.aplication1.model.Avenger;
import udg.mxc.aplication1.util.Util;

public class AvengerActivity extends AppCompatActivity {

    private Context context;
    private ImageView mImgAvengerLogo;
    private ImageView mImgAvengerLogo2;
    private Spinner mSpinnerListAvengers;
    private ArrayList<Avenger> avengersList;
    private TextInputEditText avengerPhrase;
    private ScrollView mScrollView;
    private RadioGroup mRgGema;
    private boolean hasGem;
    private Switch swIsAlive;
    private boolean isAlive;

    private TextView avengerPhraseInfo;
    private TextView avengerNameInfo;
    private CheckBox avengerIsAliveInfo;
    private CheckBox avengerhasGemInfo;

    private ConstraintLayout mFormEdit;
    private ConstraintLayout mFormInfo;

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avenger);
        initialize();
        setupImageViewLogo();
        addItemsOnSpinnerList();
        setUpRadioGroup();
        setUpSwitch();
    }

    private void initialize(){
        context = this;
        mImgAvengerLogo = findViewById( R.id.imageAvengerLogo );
        mImgAvengerLogo2 = findViewById( R.id.imageAvengerLogo2 );
        mSpinnerListAvengers = findViewById( R.id.spinnerListAvengers );
        avengerPhrase = findViewById( R.id.txtPhrase );
        mScrollView = findViewById( R.id.avengerScrollView );
        mRgGema = findViewById( R.id.rgGema );
        swIsAlive = findViewById( R.id.swIsAlive );
        mFormEdit = findViewById( R.id.formEdit );
        mFormInfo = findViewById( R.id.formInfo );
        avengerPhraseInfo = findViewById( R.id.textViewInfoPhrase );
        avengerNameInfo = findViewById( R.id.textViewInfoNombre );
        avengerIsAliveInfo = findViewById( R.id.chkbIsAlive );
        avengerhasGemInfo = findViewById( R.id.chkbHasGemInfo );

        Avenger rocket = new Avenger("rocket", "https://i1.wp.com/collectible506.com/wp-content/uploads/2018/03/20180309_100753.jpg?zoom=2.625&resize=412%2C228&ssl=1");
        Avenger spiderman = new Avenger("spiderman", "https://emptylighthouse-production.s3-us-west-2.amazonaws.com/s3fs-public/styles/728x_hero/public/field/image/30740878_10155432528682344_9083589659031764992_n.jpg?itok=-Jn0xdbw");
        Avenger ironman = new Avenger("ironman","http://mouse.latercera.com/wp-content/uploads/2017/10/avengers-ironman.jpg");
        Avenger gamora = new Avenger("gamora","https://cde.laprensa.e3.pe/ima/0/0/1/9/2/192183.jpg");
        Avenger scarletwitch = new Avenger("scarletwitch","https://i.ytimg.com/vi/eyhz6MImCvA/maxresdefault.jpg");
        Avenger blackwidow = new Avenger("blackwidow","https://m.media-amazon.com/images/M/MV5BN2E2NDVhYmItNWUyMS00NjkzLTgzZjgtN2UyNDc2OTQ5Y2U1XkEyXkFqcGdeQXVyNjczOTE0MzM@._V1_.jpg");
        Avenger hulk = new Avenger("hulk","https://img.chilango.com/2018/04/mark-ruffalo-vendr%C3%A1-a-M%C3%A9xico.jpg");
        Avenger americancaptain = new Avenger("americancaptian","https://i0.wp.com/codigoespagueti.com/wp-content/uploads/2018/10/chris-evans-capitan-america.jpg?resize=1080%2C600&quality=80&ssl=1");
        Avenger thor = new Avenger("thor","https://imgc.allpostersimages.com/img/print/posters/avengers-infinity-war-thor-and-stormbreaker_a-G-15605542-13372582.jpg");
        Avenger mantis = new Avenger("mantis","https://imgc.allpostersimages.com/img/print/posters/avengers-infinity-war-mantis_a-G-15605558-13198931.jpg");
        Avenger nebula = new Avenger("nebula","https://imgc.allpostersimages.com/img/print/posters/avengers-infinity-war-nebula_a-G-15605551-13198931.jpg");

        avengersList = new ArrayList<>();

        avengersList.add(rocket);
        avengersList.add(spiderman);
        avengersList.add(ironman);
        avengersList.add(gamora);
        avengersList.add(scarletwitch);
        avengersList.add(blackwidow);
        avengersList.add(hulk);
        avengersList.add(americancaptain);
        avengersList.add(thor);
        avengersList.add(mantis);
        avengersList.add(nebula);

    }

    private void setupImageViewLogo(){
        changeImage( mImgAvengerLogo, "https://i.ytimg.com/vi/L2d1izag-Bg/maxresdefault.jpg" );
    }

    public void addItemsOnSpinnerList(){
        List<String> list = new ArrayList<>();

        for( Avenger avenger : avengersList ){
            list.add(avenger.getNombre());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>( context, R.layout.spinner_item, list );
        dataAdapter.setDropDownViewResource( R.layout.spinner_item );
        mSpinnerListAvengers.setAdapter(dataAdapter);
    }

    private void setUpRadioGroup(){
        mRgGema.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Util.showLog( TAG, "Enta al listener");
                switch ( checkedId ) {
                    case R.id.rbSiGema:
                        Util.showLog( TAG, "Si");
                        hasGem = true;
                        break;
                    case R.id.rbNoGema:
                        Util.showLog( TAG, "No");
                        hasGem = false;
                        break;
                }

            }
        });
    }

    private void setUpSwitch(){
        swIsAlive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isAlive = isChecked;
            }
        });
    }

    public void clicked(View view){

        switch (view.getId()){
            case R.id.buttonShowInfo:
                    String avengerName = String.valueOf( mSpinnerListAvengers.getSelectedItem() );
                    Util.showLog( TAG,  "Avenger: "+avengerName );
                    Util.showLog( TAG,  "Gema: "+hasGem );
                    Util.showLog( TAG,  "Is alive: "+isAlive );
                    if( avengerPhrase.getText().toString().isEmpty() ){
                        showSnackBar( "No puede dejar el campo de frase vacío" );
                    }else{
                        Util.showLog( TAG, String.valueOf( avengerPhrase.getText().toString() ) );
                        avengerPhraseInfo.setText(avengerPhrase.getText().toString());
                        avengerNameInfo.setText(avengerName);
                        avengerIsAliveInfo.setChecked(isAlive);
                        avengerhasGemInfo.setChecked(hasGem);

                        for( Avenger avenger : avengersList ){
                            if( avenger.getNombre().equals(avengerName) ){
                                changeImage( mImgAvengerLogo2, avenger.getImagenUrl() );
                            }
                        }

                        mFormEdit.setVisibility( view.GONE );
                        mFormInfo.setVisibility( view.VISIBLE );
                    }
                break;
            case R.id.buttonEdit:
                mFormEdit.setVisibility( view.VISIBLE );
                mFormInfo.setVisibility( view.GONE );
                break;

        }


    }

    public void showSnackBar( String message ){
        Snackbar.make( mScrollView, message, Snackbar.LENGTH_LONG )
                .show();
    }

    public void showToast( Context context, String message ){
        Toast.makeText( context, message, Toast.LENGTH_LONG ).show();
    }

    public void changeImage( ImageView imageView, String url ){
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable( context );
        circularProgressDrawable.setStrokeWidth( 20f );
        circularProgressDrawable.setCenterRadius( 60f );
        circularProgressDrawable.setColorFilter(ContextCompat.getColor( context, R.color.colorAccent ), PorterDuff.Mode.SRC_ATOP );
        circularProgressDrawable.start();
        Glide.with( context )
                .load( url )
                .centerCrop()
                .crossFade(5000)
                .placeholder( circularProgressDrawable )
                .into( imageView );
    }
}
