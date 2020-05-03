package abhishekkumar.moviemania.View;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import abhishekkumar.moviemania.Controler.ApiClient;
import abhishekkumar.moviemania.Controler.ApiInterface;
import abhishekkumar.moviemania.Controler.CastAdapter;
import abhishekkumar.moviemania.Model.CastModel;
import abhishekkumar.moviemania.Model.CastPreModel;
import abhishekkumar.moviemania.Model.TvDetailsPage;
import abhishekkumar.moviemania.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvDetails extends AppCompatActivity {
    private String title,tvPosterpath;
    private int id;
    private final String API_KEY="5a05b0f74b9986a3f1deb838cec732c2";
    private ImageView poster;
    private TextView tvStatus,tvType,tvRating,tvTotalVote,tvOverview,session,episode,firstAir,lastAir,nextAir,language;
    private final String TAG=getClass().getSimpleName();
    private ActionBar actionBar;
    ApiInterface tvapiInterface=ApiClient.getClient().create(ApiInterface.class);
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_details);
        poster=findViewById(R.id.tv_poster);
        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("title");
        tvPosterpath=bundle.getString("posterpath");
        id=bundle.getInt("id");

        actionBar=getSupportActionBar();
        actionBar.setTitle(title);
        Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500"+tvPosterpath)
                .into(poster);
        uiSetup();
        recyclerView=findViewById(R.id.tv_cast);
//        RecyclerView.LayoutManager myrecycler=new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager myrecycler=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(myrecycler);
        tvApiCalling();
        tvCastCalling(id,API_KEY);

    }
    private void uiSetup(){
        tvStatus=findViewById(R.id.status_post_tv);
        tvType=findViewById(R.id.type_post_tv);
        tvRating=findViewById(R.id.rating_post_tv);
        tvTotalVote=findViewById(R.id.vote_post_tv);
        tvOverview=findViewById(R.id.overview_post_tv);
        session=findViewById(R.id.session_post_tv);
        episode=findViewById(R.id.episode_post_tv);
        firstAir=findViewById(R.id.fair_date_post_tv);
        lastAir=findViewById(R.id.lair_date_post_tv);
//        nextAir=findViewById(R.id.nair_date_post_tv);
        language=findViewById(R.id.lang_post_tv);
    }
    private void tvApiCalling(){

        Call<TvDetailsPage> tvDetailsPageCall=tvapiInterface.getTvDetailsbyId(id,API_KEY);
        Log.v("tvapicaling",tvDetailsPageCall.toString());
        tvDetailsPageCall.enqueue(new Callback<TvDetailsPage>() {
            @Override
            public void onResponse( Call<TvDetailsPage> call, Response<TvDetailsPage> response) {
                Log.v("tvapicalling","inside on response");
                tvStatus.setText(response.body().getTvStatus());
//                Log.v("tvapicaling", (String) response.body().getObject());
                if (response.body().getTvStatus().equals("Ended")){
                    tvStatus.setTextColor(getResources().getColor(R.color.colorRed));
                }else {
                    tvStatus.setTextColor(getResources().getColor(R.color.colorgreen));
                }
                tvType.setText(response.body().getTvtype());

                tvRating.setText(String.valueOf(response.body().getRating()));
                tvTotalVote.setText(String.valueOf(response.body().getVotecount()));
                tvOverview.setText(response.body().getOverview());
                session.setText(String.valueOf(response.body().getSeason()));
                episode.setText(String.valueOf(response.body().getEpisode()));
                language.setText(response.body().getLanguage().toUpperCase());
                firstAir.setText(response.body().getFairdate());
                lastAir.setText(response.body().getLairdate());
//                nextAir.setText(response.body().getNairdate());

            }

            @Override
            public void onFailure(Call<TvDetailsPage> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
    private void tvCastCalling(int id,String apikey){
        Call<CastPreModel> tvcast=tvapiInterface.getTVsCast(id,apikey);
        tvcast.enqueue(new Callback<CastPreModel>() {
//            final int index=5;
            @Override
            public void onResponse(Call<CastPreModel> call, Response<CastPreModel> response) {
                List<CastModel> preModelList=response.body().getCastPrelist();
//                Log.v("Castcall", preModelList.get(index).getCharacter());
                recyclerView.setAdapter(new CastAdapter(preModelList));
            }

            @Override
            public void onFailure(Call<CastPreModel> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}
