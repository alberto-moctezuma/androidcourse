package udg.mxc.aplication1.ws;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Client {

    @GET(ClientEndPoints.getPeople)
    Call<ResponseBody> getCharacter(@Path("id") String id);
}
