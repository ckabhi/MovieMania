package abhishekkumar.moviemania.Controler;

import abhishekkumar.moviemania.Model.CastModel;
import abhishekkumar.moviemania.Model.CastPreModel;
import abhishekkumar.moviemania.Model.MovieDetailsPage;
import abhishekkumar.moviemania.Model.HomePageRespons;
import abhishekkumar.moviemania.Model.TvDetailsPage;
import abhishekkumar.moviemania.Model.tvPageResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
/* This Class is used to provide the End point for Api calling function "path" is used for changing the variable
* inside "{..}" bracket and "query"  is used for the passing the api Key and extra query like as sord or genre_with */
public interface ApiInterface {
    @GET("movie/now_playing")
    Call<HomePageRespons> getLiveMovie(@Query("api_key") String apiKey);
    @GET("movie/upcoming")
    Call<HomePageRespons> getUpcomingMovie(@Query("api_key") String apiKey);
    @GET("movie/top_rated")
    Call<HomePageRespons> getTopRatedMovie(@Query("api_key") String apiKey);
    @GET("tv/airing_today")
    Call<tvPageResponse> getAiringTodayTv(@Query("api_key") String apiKey);

    /* These methodes are used in the navigation drawer */
    @GET("movie/{path}")
    Call<HomePageRespons>  getMovieOption(@Path("path") String path,@Query("api_key") String apiKey);
    @GET("tv/{path}")
    Call<tvPageResponse> getTvsOption(@Path("path") String path,@Query("api_key") String apiKey);

    /* These methods are used in details activity for details view of particular Movie or TVs Show with an ID */
    @GET("movie/{path}")
    Call<MovieDetailsPage> getMoviebyId(@Path("path") int path, @Query("api_key") String apiKey);
    @GET("tv/{path}")
    Call<TvDetailsPage> getTvDetailsbyId(@Path("path") int path,@Query("api_key")String apiKey);

    /* This method is used to call the genres based discover movie/tv api with genres*/
    @GET("discover/movie")
    Call<HomePageRespons> getMoviebyGenre(@Query("api_key") String apiKey, @Query("with_genres") int genre);
    @GET("discover/tv")
    Call<tvPageResponse> getTvbyGenre(@Query("api_key") String apiKey, @Query("with_genres") int genre);

    /*This method is used to call the credits and crew of a Movie or TVs show*/
    @GET("movie/{path}/credits")
    Call<CastPreModel> getMovieCast(@Path("path") int path,@Query("api_key") String apiKey);
    @GET("tv/{path}/credits")
    Call<CastPreModel> getTVsCast(@Path("path") int path, @Query("api_key") String apiKey);


}
