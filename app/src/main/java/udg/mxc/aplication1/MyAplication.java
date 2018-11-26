package udg.mxc.aplication1;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
