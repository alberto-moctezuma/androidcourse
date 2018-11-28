package udg.mxc.aplication1.ws.starwars;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import udg.mxc.aplication1.ws.ClientEndPoints;
import udg.mxc.aplication1.ws.wsmodels.StarWarsCharacterResponse;

public interface Client {

    @GET(ClientEndPoints.getPeople)
    Call<StarWarsCharacterResponse> getCharacter(@Path("id") String id);

}
