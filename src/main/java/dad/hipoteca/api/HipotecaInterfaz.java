package dad.hipoteca.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HipotecaInterfaz {
    //http://localhost:3000/hipoteca?capital=1000&interes=5&a%C3%B1os=2
    @GET("hipoteca")
    Call<SearchResultHipoteca> search(@Query("capital") Double capital, @Query("interes") Double interes, @Query("años") Double años);
}
