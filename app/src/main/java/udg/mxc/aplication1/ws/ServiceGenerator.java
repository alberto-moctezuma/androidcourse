package udg.mxc.aplication1.ws;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class ServiceGenerator {
    private static final String BASE_URL = "https://swapi.co/api/";

    private static HttpLoggingInterceptor loggin = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(loggin);

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl(BASE_URL);

    public static <S> S createService(Class<S> serviceClass){
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
