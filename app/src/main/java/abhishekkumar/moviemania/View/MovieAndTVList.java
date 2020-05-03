package abhishekkumar.moviemania.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.List;

import abhishekkumar.moviemania.Controler.ApiClient;
import abhishekkumar.moviemania.Controler.ApiInterface;
import abhishekkumar.moviemania.Controler.MovieListAdapter;
import abhishekkumar.moviemania.Model.HomePage;
import abhishekkumar.moviemania.Model.HomePageRespons;
import abhishekkumar.moviemania.Model.TvPage;
import abhishekkumar.moviemania.Model.tvPageResponse;
import abhishekkumar.moviemania.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieAndTVList extends AppCompatActivity {
        private String type,path,apiKey;
        private int genre;
        private RecyclerView movieListRecycler;
        MovieListAdapter movieListAdapter;
        List<HomePage> myresponse;
        final String TAG=MovieAndTVList.class.getSimpleName();
        private ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LayoutInflater layoutInflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View contentView=layoutInflater.inflate(R.layout.activity_movie_list,null,false);
//        drawer.add
        setContentView(R.layout.activity_movie_list);
        Bundle bundle=getIntent().getExtras();
        type=bundle.getString("type");
//        if (type.equals("movie")) {
//            path = bundle.getString("path");
//            apiKey = bundle.getString("apikey");
//        }else if (type.equals("tv"))


        movieListRecycler=findViewById(R.id.movie_list_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        movieListRecycler.setLayoutManager(layoutManager);
        if (type.equals("movie")){
            path = bundle.getString("path");
            apiKey = bundle.getString("apikey");
            apiCallingMovie(type,path,apiKey);
        }else if (type.equals("tvs")){
            path = bundle.getString("path");
            apiKey = bundle.getString("apikey");
            apiCallingTvs(path,apiKey);
        }else if (type.equals("Movie Genres")){
            genre=bundle.getInt("genre");
            apiKey=bundle.getString("apikey");
            apiDiscoverMovie(apiKey,genre);

        }else{
            genre=bundle.getInt("genre");
            apiKey=bundle.getString("apikey");
            apiDiscoverTv(apiKey,genre);
        }


    }
    /* Calling this method for movies*/
    private void apiCallingMovie(final String type, String path, String apiKey){
        Call<HomePageRespons> call=apiInterface.getMovieOption(path,apiKey);
        call.enqueue(new Callback<HomePageRespons>() {
            @Override
            public void onResponse(Call<HomePageRespons> call, Response<HomePageRespons> response) {
                final int statusCode=response.code();
                List<HomePage> movieList=response.body().getResult();
                movieListRecycler.setAdapter(new MovieListAdapter(movieList,type));
//                movieListRecycler.getAdapter().notifyDataSetChanged();
                runLayoutAnimation(movieListRecycler);
            }

            @Override
            public void onFailure(Call<HomePageRespons> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
    /*Calling this method for tvs show */
    private void apiCallingTvs(String path,String apiKey){
        Call<tvPageResponse> tvsCall=apiInterface.getTvsOption(path,apiKey);
        tvsCall.enqueue(new Callback<tvPageResponse>() {
            @Override
            public void onResponse(Call<tvPageResponse> call, Response<tvPageResponse> response) {
                final int statusCode=response.code();
                List<TvPage> tvsList=response.body().getResult();
                movieListRecycler.setAdapter(new MovieListAdapter(tvsList));
//                movieListRecycler.getAdapter().notifyDataSetChanged();
                runLayoutAnimation(movieListRecycler);
            }

            @Override
            public void onFailure(Call<tvPageResponse> call, Throwable t) {

            }
        });
    }
    /*Calling this method to find movie by Genres */
    private void apiDiscoverMovie(String apikey,int genre){
        Call<HomePageRespons> discovermovie=apiInterface.getMoviebyGenre(apikey,genre);
        discovermovie.enqueue(new Callback<HomePageRespons>() {
            @Override
            public void onResponse(Call<HomePageRespons> call, Response<HomePageRespons> response) {
                final int statusCode=response.code();
                List<HomePage> movieList=response.body().getResult();
                movieListRecycler.setAdapter(new MovieListAdapter(movieList,type));
                runLayoutAnimation(movieListRecycler);
            }

            @Override
            public void onFailure(Call<HomePageRespons> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
    /*Calling this method to find TVs show by Genres */
    private void apiDiscoverTv(String apikey,int genre){
        Call<tvPageResponse> discovertv=apiInterface.getTvbyGenre(apikey,genre);
        discovertv.enqueue(new Callback<tvPageResponse>() {
            @Override
            public void onResponse(Call<tvPageResponse> call, Response<tvPageResponse> response) {
                final int statusCode=response.code();
                List<TvPage> tvsList=response.body().getResult();
                movieListRecycler.setAdapter(new MovieListAdapter(tvsList));
//                movieListRecycler.getAdapter().notifyDataSetChanged();
                runLayoutAnimation(movieListRecycler);
            }

            @Override
            public void onFailure(Call<tvPageResponse> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });

    }
    /* Method used to run animation LeftIn type animation*/
    private void runLayoutAnimation(final RecyclerView recyclerView){
        final Context context=recyclerView.getContext();
        final LayoutAnimationController animationController=AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_recycler);
        recyclerView.setLayoutAnimation(animationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
