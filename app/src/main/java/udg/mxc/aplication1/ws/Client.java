package udg.mxc.aplication1.ws;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import udg.mxc.aplication1.ws.wsmodels.StarWarsCharacterResponse;

public interface Client {

    @GET(ClientEndPoints.getPeople)
    Call<StarWarsCharacterResponse> getCharacter(@Path("id") String id);
}
