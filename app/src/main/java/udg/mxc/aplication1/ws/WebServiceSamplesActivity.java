package udg.mxc.aplication1.ws;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.Util;

public class WebServiceSamplesActivity extends AppCompatActivity {

    @BindView( R.id.textViewPokemon )
    TextView mTextViewPokemon;

    @BindView( R.id.editTextPokemonId )
    TextInputEditText mTextInputEditTextPokemonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_samples);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonPokemon) public void getCharacter(View view){
        String input = mTextInputEditTextPokemonId.getText().toString();
        if( !input.isEmpty() ){
            Client client = ServiceGenerator.createService(Client.class);
            client.getCharacter(input)
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try{
                                Util.showLog("JSON", response.body().string());
                                mTextViewPokemon.setText("Respuesta: "+response.body().string());
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            mTextViewPokemon.setText("ERROR!!!!!!!!");
                            t.printStackTrace();
                        }
                    });
        }
    }
}
