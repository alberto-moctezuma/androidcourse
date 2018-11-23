package udg.mxc.aplication1.components;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import udg.mxc.aplication1.R;

public class MoreComponentActivity extends AppCompatActivity {

    private Spinner mSpinnerCountries;
    private Spinner mSpinerList;
    private Button mButtonSelect;
    private Context context;

    private static final String TAG = ComponentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_component);
        initialize();
        addListenerOnSpinnerItemSelection();
        addItemsOnSpinnerList();
    }

    private void initialize(){
        context = this;
        mSpinnerCountries = findViewById( R.id.spinnerCountries );
        mSpinerList = findViewById( R.id.spinnerList );
        mButtonSelect = findViewById( R.id.buttonSelect );
    }

    public void addListenerOnSpinnerItemSelection(){
        mSpinnerCountries.setOnItemSelectedListener( new CustomOnItemSelectedListener() );
    }

    public void addItemsOnSpinnerList(){
        List<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>( context, R.layout.spinner_item, list );
        dataAdapter.setDropDownViewResource( R.layout.spinner_item );
        mSpinerList.setAdapter(dataAdapter);
    }

    public void clicked( View view  ){
        switch ( view.getId() ){
            case R.id.buttonSelect:
                createSimpleDialog(context);
                break;
        }
    }

    public void createSimpleDialog( Context context ){
        AlertDialog.Builder builder = new AlertDialog.Builder( context );
        builder.setTitle( "Seleccionaste" )
                .setMessage("\nSpinner Countries: "+String.valueOf(mSpinnerCountries.getSelectedItem())+
                    "\nSpinner List: "+String.valueOf(mSpinerList.getSelectedItem()))
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
        builder.show();
    }

}
