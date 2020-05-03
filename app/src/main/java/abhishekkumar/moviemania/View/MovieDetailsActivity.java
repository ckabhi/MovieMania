package abhishekkumar.moviemania.View;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import abhishekkumar.moviemania.Controler.ApiClient;
import abhishekkumar.moviemania.Controler.ApiInterface;
import abhishekkumar.moviemania.Controler.CastAdapter;
import abhishekkumar.moviemania.Model.CastModel;
import abhishekkumar.moviemania.Model.CastPreModel;
import abhishekkumar.moviemania.Model.MovieDetailsPage;
import abhishekkumar.moviemania.Model.HomePage;
import abhishekkumar.moviemania.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {
private String type,title,newTitle,videoname,posterpath;
private int movieid;
private HomePage homePage;
private final String API_KEY="5a05b0f74b9986a3f1deb838cec732c2";
private final String TAG=getClass().getSimpleName();
private TextView statusPre,statusPost,budgetPre,budgetPost,revenuePre,revenuePost,overviewPre,overviewPost,runtimePre,runtimePost;
private TextView ratingPre,ratingPost,totalRatingPre,totalRatingPost;
private ImageView poster;
private RecyclerView castRecycler;
    ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        setContentView(R.layout.activity_details);

        Bundle bundle=getIntent().getExtras();
        type=bundle.getString("type");
        title=bundle.getString("title");
        movieid=bundle.getInt("id");
        posterpath=bundle.getString("posterpath");
//        Log.v("posterPathDetails",posterpath);
        actionBar.setTitle(title);
        viewSetup();

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500"+posterpath)
                .into(poster);
        castRecycler=findViewById(R.id.movie_cast);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        castRecycler.setLayoutManager(layoutManager);
        onDetailsCall();
        castApi(movieid,API_KEY);

    }

    private void viewSetup(){
        statusPre=findViewById(R.id.status_pre);
        statusPost=findViewById(R.id.status_post);
        budgetPre=findViewById(R.id.budget_pre);
        budgetPost=findViewById(R.id.budget_post);
        revenuePre=findViewById(R.id.revenue_pre);
        revenuePost=findViewById(R.id.revenue_post);
        overviewPre=findViewById(R.id.overview_pre);
        overviewPost=findViewById(R.id.overview_post);
        runtimePre=findViewById(R.id.runtime_pre);
        runtimePost=findViewById(R.id.runtime_post);
        ratingPre=findViewById(R.id.rating_pre);
        ratingPost=findViewById(R.id.rating_post);
        totalRatingPre=findViewById(R.id.total_review_pre);
        totalRatingPost=findViewById(R.id.total_review_post);
        poster=findViewById(R.id.image_view);
    }

    private void onDetailsCall(){
        Call<MovieDetailsPage> call=apiInterface.getMoviebyId(movieid,API_KEY);
        call.enqueue(new Callback<MovieDetailsPage>() {
            @Override
            public void onResponse(Call<MovieDetailsPage> call, Response<MovieDetailsPage> response) {
//                Log.v("detailslog",response.body())
                statusPost.setText(response.body().getStatus());
                if (response.body().getStatus().equals("Released")){
                    statusPost.setTextColor(getResources().getColor(R.color.colorgreen));
                }else {
                    statusPost.setTextColor(getResources().getColor(R.color.colorRed));
                }
                runtimePost.setText(String.valueOf(response.body().getRunTime())+" min.");
                budgetPost.setText("$ "+String.valueOf(response.body().getBudget()));
                revenuePost.setText("$ "+String.valueOf(response.body().getRevenue()));
                overviewPost.setText(response.body().getOverview());
                ratingPost.setText(String.valueOf(response.body().getVoteAverage())+"/ 10");
                totalRatingPost.setText(String.valueOf(response.body().getVoteCount()));
            }

            @Override
            public void onFailure(Call<MovieDetailsPage> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }

    private void castApi(int id,String apiKey){
        Call<CastPreModel> movieCast=apiInterface.getMovieCast(id,apiKey);
        movieCast.enqueue(new Callback<CastPreModel>() {
            @Override
            public void onResponse(Call<CastPreModel> call, Response<CastPreModel> response) {
                List<CastModel> castList=response.body().getCastPrelist();
                castRecycler.setAdapter(new CastAdapter(castList));
            }

            @Override
            public void onFailure(Call<CastPreModel> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}
