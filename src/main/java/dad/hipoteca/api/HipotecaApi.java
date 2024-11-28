package dad.hipoteca.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HipotecaApi {
    private static final String BASE_URL = "https://calculohipoteca-production.up.railway.app/";

    private final HipotecaInterfaz service;

    public HipotecaApi(){
        ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(pool)
                .build();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        service = retrofit.create(HipotecaInterfaz.class);

    }


    public ResultHipoteca getCuotas(Double capital, Double interes, Double años) throws IOException {
        Response<ResultHipoteca> result = service.search(capital,interes,años).execute();
        if (result.isSuccessful()){
            return result.body();
        }
        return null;
    }
}
