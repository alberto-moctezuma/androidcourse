package udg.mxc.aplication1.components.vector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.KeysConstants;
import udg.mxc.aplication1.util.Util;

public class ProfileActivity extends AppCompatActivity {

    @BindView( R.id.textViewProfile )
    TextView mTextViewProfile;

    @BindView( R.id.profileImage )
    CircleImageView mCircleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind( this );
        Intent intent = getIntent();
        Glide.with( this )
                .load( "https://i1.wp.com/collectible506.com/wp-content/uploads/2018/03/20180309_100753.jpg?zoom=2.625&resize=412%2C228&ssl=1" )
                .centerCrop()
                .override(120,120)
                .crossFade(2500)
                .into( mCircleImageView );

        if( intent!= null ){
            String mail = intent.getStringExtra(KeysConstants.PROFILE);
            mTextViewProfile.setText(mail);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (  item.getItemId() ){
            case R.id.menuUser:
                Util.showToast(this, "Item 1 Selected" );
                return true;
            case R.id.menuSettings:
                Util.showToast(this, "Item 2 Selected" );
                return true;
            case R.id.menuLogout:
                Util.showToast(this, "Logout" );
                Util.changeActivity(ProfileActivity.this, VectorActivity.class, null);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
