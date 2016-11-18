package sbl.com.alarmmngrnetwrkoprations.webservice;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import sbl.com.alarmmngrnetwrkoprations.pojos.CurrencyValuePOJO;

/**
 * Created by sandeep on 9/27/2016.
 */
public interface WebAPI {

    @GET("quote")
    public Call<CurrencyValuePOJO> getCurrencyValues(@Query("format") String macAddress);

    @GET("quote?format=json")
    public Call<CurrencyValuePOJO> getCurrencyValues();

}
