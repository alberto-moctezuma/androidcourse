package udg.mxc.aplication1.notificationssample;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.KeysConstants;
import udg.mxc.aplication1.util.Util;

public class FirstActivity extends AppCompatActivity {

    @BindView( R.id.editTextMessage )
    EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    @OnClick( R.id.buttonSend ) public void sendMessage(View view){
        if( !mEditTextMessage.getText().toString().isEmpty() ){
            HashMap<String, String> parameters = new HashMap<>();
            parameters.put(KeysConstants.message, mEditTextMessage.getText().toString());
            Util.changeActivity( this, NotificationsActivity.class, parameters, true );
        }else{
            createSimpleDialog( FirstActivity.this );
        }
    }

    private void createSimpleDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.empty_input_message)
                .setMessage(getString(R.string.insert_a_message_to_send))
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.show();
    }
}
