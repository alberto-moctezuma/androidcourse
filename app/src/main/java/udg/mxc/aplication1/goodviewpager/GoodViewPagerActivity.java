package udg.mxc.aplication1.goodviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.goodviewpager.fragments.FragmentOne;
import udg.mxc.aplication1.goodviewpager.fragments.FragmentThree;
import udg.mxc.aplication1.goodviewpager.fragments.FragmentTwo;
import udg.mxc.aplication1.util.Util;

public class GoodViewPagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    public static final String TAG = GoodViewPagerActivity.class.getSimpleName();

    @BindView( R.id.viewGoodPager )
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_view_pager);
        ButterKnife.bind(this);
        setUpViewPager();
    }

    public void setUpViewPager(){
        GoodPageAdapter goodPageAdapter = new GoodPageAdapter( getSupportFragmentManager() );
        goodPageAdapter.addFragment(FragmentOne.newInstance(), FragmentOne.TAG);
        goodPageAdapter.addFragment(FragmentTwo.newInstance("Prueba de enviar datos a fragments"), FragmentTwo.TAG);
        goodPageAdapter.addFragment(FragmentThree.newInstance(), FragmentThree.TAG);

        viewPager.setAdapter( goodPageAdapter );
        viewPager.addOnPageChangeListener( this );

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Util.showLog( TAG, "Page selected: "+i );
    }

    @Override
    public void onPageScrollStateChanged(int i) {
        Util.showLog( TAG, "On page scroll: "+i );
    }
}
