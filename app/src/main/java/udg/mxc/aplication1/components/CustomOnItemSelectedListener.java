package udg.mxc.aplication1.components;

import android.view.View;
import android.widget.AdapterView;

import udg.mxc.aplication1.util.Util;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Util.showLog( TAG,"Select "+parent.getItemAtPosition( position ).toString() );
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
