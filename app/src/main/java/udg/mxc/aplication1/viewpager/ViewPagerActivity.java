package udg.mxc.aplication1.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import udg.mxc.aplication1.R;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView( R.id.viewPager )
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        mViewPager.setAdapter( new CustomPagerAdapter(this) );
    }
}
