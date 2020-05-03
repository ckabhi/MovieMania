package abhishekkumar.moviemania.Controler;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/* This class is used to create the api client which will be used while calling api interface */
public class ApiClient {
    public static final String BASE_URL="https://api.themoviedb.org/3/";
    private static Retrofit retrofit=null;
    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                                    .baseUrl(BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
        }
        return retrofit;
    }
}
