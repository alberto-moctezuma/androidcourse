package udg.mxc.aplication1.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.database.adapter.DogShopAdapter;
import udg.mxc.aplication1.database.adapter.DogShopClick;
import udg.mxc.aplication1.database.adapter.DogShopLongClick;
import udg.mxc.aplication1.database.model.DogShop;
import udg.mxc.aplication1.util.KeysConstants;
import udg.mxc.aplication1.util.Util;

public class RealmRecyclerSampleActivity extends AppCompatActivity implements DogShopClick, DogShopLongClick {

    private static String TAG = RealmRecyclerSampleActivity.class.getSimpleName();
    private RealmList<DogShop> dogShops = new RealmList<>();
    private DogShopAdapter dogShopAdapter;

    @BindView(R.id.shopsRecyclerView) RecyclerView mDogShopsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_recycler_sample);
        ButterKnife.bind(this);
        setUpRecyclerView( mDogShopsRecyclerView );
    }

    @Override
    protected void onResume() {
        super.onResume();
        getRealmObjects();
    }

    private void getRealmObjects(){
        dogShops.clear();
        Realm realm = Realm.getDefaultInstance();
        RealmResults<DogShop> dogsShopResults = realm.where( DogShop.class ).findAll();
        dogShops.addAll(dogsShopResults.subList(0, dogsShopResults.size()));
        dogShopAdapter.notifyDataSetChanged();
    }

    @OnClick( R.id.floatingActionButton ) public void addDoomie(){
        HashMap<String, String > parameters = new HashMap<>();
        parameters.put( KeysConstants.MODE_KEY, String.valueOf( KeysConstants.CREATE_MODE ));
        Util.changeActivity( this, EditShopActivity.class, parameters, false );
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
        HashMap< String, String > parameters = new HashMap<>();
        parameters.put( KeysConstants.DOG_SHOP_ID, dogShop.dogShopID );
        parameters.put( KeysConstants.MODE_KEY, String.valueOf( KeysConstants.EDIT_MODE ) );
        Util.changeActivity( this, EditShopActivity.class, parameters, false );
    }

    @Override
    public void onDogShopLongClickListener(DogShop dogShop) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realmTransaction) {
                dogShops.remove(dogShop);
                dogShopAdapter.notifyDataSetChanged();
                RealmResults<DogShop> shops = realmTransaction.where( DogShop.class )
                        .equalTo(KeysConstants.DOG_SHOP_ID, dogShop.dogShopID)
                        .findAll();

                shops.deleteAllFromRealm();
            }
        });
    }

    public DogShop createDoomie(){
        return new DogShop( "Test", "Calle Vidrio 1792", Util.setRandomImage(), String.valueOf( Util.getRandomID() ) );
    }
}
