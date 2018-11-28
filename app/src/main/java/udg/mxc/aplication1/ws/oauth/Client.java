package udg.mxc.aplication1.ws.oauth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import udg.mxc.aplication1.ws.wsmodels.LoginOauthResponse;

public interface Client {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginOauthResponse> login(@Field("email") String email, @Field("password") String password);
}
