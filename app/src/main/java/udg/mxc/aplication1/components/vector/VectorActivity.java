package udg.mxc.aplication1.components.vector;


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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.KeysConstants;
import udg.mxc.aplication1.util.Util;
import udg.mxc.aplication1.ws.oauth.Client;
import udg.mxc.aplication1.ws.oauth.ServiceGenerator;
import udg.mxc.aplication1.ws.wsmodels.LoginOauthResponse;

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

        /*
        udg.mxc.aplication1.ws.oauth.Client client2 = udg.mxc.aplication1.ws.oauth.ServiceGenerator.createService(udg.mxc.aplication1.ws.oauth.Client.class);
        client2.login("hola@uble.mx","sachubab13")
                .enqueue(new Callback<LoginOauthResponse>() {
                    @Override
                    public void onResponse(Call<LoginOauthResponse> call, Response<LoginOauthResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<LoginOauthResponse> call, Throwable t) {

                    }
                });
        */


    }

    @OnClick( R.id.buttonLoggin ) public void loggin( View view ) {
        if( allInputsEmpty() ){
            Util.showSnackBar(mScrollViewVector,"No ha ingresado ningún campo");
        }else{
            if( areValidInput() ){

                Client client = ServiceGenerator.createService(Client.class);
                client.login(mTextEmail.getText().toString(), mTextPassword.getText().toString())
                        .enqueue(new Callback<LoginOauthResponse>() {
                            @Override
                            public void onResponse(Call<LoginOauthResponse> call, Response<LoginOauthResponse> response) {
                                LoginOauthResponse loginOauthResponse = response.body();
                                if( loginOauthResponse.getSuccess() == 1 ){
                                    HashMap<String, String> parameters = new HashMap<>();
                                    parameters.put( KeysConstants.PROFILE, mTextEmail.getText().toString() );
                                    Util.changeActivity(VectorActivity.this, ProfileActivity.class, parameters, true);
                                }
                            }

                            @Override
                            public void onFailure(Call<LoginOauthResponse> call, Throwable t) {

                            }
                        });


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
