package udg.mxc.aplication1.components.vector;


import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.KeysConstants;
import udg.mxc.aplication1.util.Util;

public class VectorActivity extends AppCompatActivity {

    @BindView( R.id.scrollViewVector )
    ScrollView mScrollViewVector;

    @BindView( R.id.emailInputVector )
    TextInputLayout mEmailInputVector;

    @BindView( R.id.passwordInputVector )
    TextInputLayout mPasswordInputVector;

    @BindView( R.id.textInputEmail )
    EditText mTextEmail;

    @BindView( R.id.textInputPassword )
    EditText mTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);
        ButterKnife.bind( this );

    }

    @OnClick( R.id.buttonLoggin ) public void loggin( View view ) {
        if( allInputsEmpty() ){
            Util.showSnackBar(mScrollViewVector,"No ha ingresado ningún campo");
        }else{
            if( areValidInput() ){
                HashMap<String, String> parameters = new HashMap<>();
                parameters.put( KeysConstants.PROFILE, mTextEmail.getText().toString() );
                Util.changeActivity(VectorActivity.this, ProfileActivity.class, parameters);
            }
        }

    }

    public boolean areValidInput( ){
        String email = mTextEmail.getText().toString();
        if ( email.isEmpty() ) {
            mEmailInputVector.setError("El email no debe ir vacío");
            return false;
        } else if ( !Util.isValidEmail(email) ) {
            mEmailInputVector.setError("El email debe tener un formato válido.");
            return false;
        }else{
            mEmailInputVector.setError(null);
        }

        if (mTextPassword.getText().toString().isEmpty()){
            mPasswordInputVector.setError("La contraseña no debe ir vacía.");
            return false;
        }else if( mTextPassword.getText().toString().length() < 8 ) {
            mPasswordInputVector.setError("La contraseña no debe contener menos de 8 caracteres.");
            return false;
        }else{
            mPasswordInputVector.setError(null);
        }

        return true;
    }

    public boolean allInputsEmpty(){
        return mTextEmail.getText().toString().isEmpty() && mTextPassword.getText().toString().isEmpty();
    }

}
