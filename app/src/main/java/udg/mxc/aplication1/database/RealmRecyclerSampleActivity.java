package udg.mxc.aplication1.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.database.adapter.DogShopAdapter;
import udg.mxc.aplication1.database.adapter.DogShopClick;
import udg.mxc.aplication1.database.adapter.DogShopLongClick;
import udg.mxc.aplication1.database.model.DogShop;
import udg.mxc.aplication1.util.Util;

public class RealmRecyclerSampleActivity extends AppCompatActivity implements DogShopClick, DogShopLongClick {

    private static String TAG = RealmRecyclerSampleActivity.class.getSimpleName();
    private List<DogShop> dogShops = new ArrayList<>();
    private DogShopAdapter dogShopAdapter;

    @BindView(R.id.shopsRecyclerView) RecyclerView mDogShopsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_recycler_sample);
        ButterKnife.bind(this);

        setUpRecyclerView( mDogShopsRecyclerView );
    }

    @OnClick( R.id.floatingActionButton ) public void addDoomie(){
        dogShops.add( createDoomie() );
        dogShopAdapter.notifyDataSetChanged();
    }

    private void setUpRecyclerView(RecyclerView mDogShopsRecyclerView) {
        dogShopAdapter = new DogShopAdapter( dogShops, getApplicationContext(), this, this );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getApplicationContext() );
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDogShopsRecyclerView.setAdapter(dogShopAdapter);
        mDogShopsRecyclerView.setLayoutManager(linearLayoutManager);
        // mDogShopsRecyclerView.setLayoutManager( new GridLayoutManager(this, 2));
    }

    @Override
    public void onDogShopClickListener(DogShop dogShop) {
        Util.showToast(getApplicationContext(),  "Click on:"+dogShop.toString());
    }

    @Override
    public void onDogShopLongClickListener(DogShop dogShop) {
        Util.showToast(getApplicationContext(), "Long click on: "+dogShop.toString());
    }

    public DogShop createDoomie(){
        return new DogShop( "Test", "Calle Vidrio 1792", Util.setRandomImage(), String.valueOf( Util.getRandomID() ) );
    }
}
