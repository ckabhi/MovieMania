package abhishekkumar.moviemania.View;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import abhishekkumar.moviemania.Controler.ApiClient;
import abhishekkumar.moviemania.Controler.ApiInterface;
import abhishekkumar.moviemania.Controler.HomePageAdapter;
import abhishekkumar.moviemania.Model.HomePage;
import abhishekkumar.moviemania.Model.HomePageRespons;
import abhishekkumar.moviemania.Model.TvPage;
import abhishekkumar.moviemania.Model.tvPageResponse;
import abhishekkumar.moviemania.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView myview;
    private ImageView postrUpcoming1,postrUpcoming2,postrMostrtd1,postrMostrtd2,postrtv1,postrtv2;
    final String API_KEY="5a05b0f74b9986a3f1deb838cec732c2";
    private int index,index1,index2;
    private int flag=0;
//    private CardView cardView;
    ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_error);

        if (checkInternet()){
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
            flag=1;
        }else{
            Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show();
        }
        if (flag==1){
//            setContentView(R.layout.activity_main);
            setMyUI();
            liveMovieHomePage();
            upComingHomePage();
            topRatedHomePage();
            airingTvHomePage();
        }
        if(flag==0){
            //startActivity(new Intent(this,ErrorActivity.class));
            setMyUiInvisible();

             }

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);



//        final ImageView imageView1=findViewById(R.id.upcoming_poster_1);
//        final SpringAnimation springAnimation=new SpringAnimation(imageView1, DynamicAnimation.TRANSLATION_Y,0);
//        springAnimation.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY).setStiffness(SpringForce.STIFFNESS_VERY_LOW);

            /** Attaching the recycler view with adapter and snaphelper **/
//            myview = findViewById(R.id.live_recycle);
//            postrUpcoming1 = findViewById(R.id.upcoming_poster_1);
//            postrUpcoming2 = findViewById(R.id.upcoming_poster_2);
//            postrMostrtd1 = findViewById(R.id.mostrated_poster_1);
//            postrMostrtd2 = findViewById(R.id.mostrated_poster_2);
//            postrtv1 = findViewById(R.id.livetv_poster_1);
//            postrtv2 = findViewById(R.id.livetv_poster_2);

//        cardView=findViewById(R.id.upcoming_cardview_1);
//            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
//            myview.setLayoutManager(layoutManager);
//        final int resId=R.anim.layout_bottom_to_top_animation;
//        LayoutAnimationController animationController=AnimationUtils.loadLayoutAnimation(getApplicationContext(),resId);
//        cardView.setLayoutAnimation(animationController);
//        cardView.scheduleLayoutAnimation();
//        SnapHelper snapHelper=new PagerSnapHelper();
//        snapHelper.attachToRecyclerView(myview);

//        liveMovie=new HomePageAdapter(mylist);
////        myview.setAdapter(liveMovie);
////        myview.setItemAnimator(new DefaultItemAnimator());
////        movieItems();


//        Call<HomePageRespons> call=apiInterface.getLiveMovie(API_KEY);
//        call.enqueue(new Callback<HomePageRespons>() {
//            @Override
//            public void onResponse(Call<HomePageRespons> call, Response<HomePageRespons> response) {
//                int statusCode=response.code();
//                List<HomePage> list=response.body().getResult();
//                myview.setAdapter(new HomePageAdapter(list));
//                runLayoutAnimation(myview);
//            }
//
//            @Override
//            public void onFailure(Call<HomePageRespons> call, Throwable t) {
//                Log.e(TAG, t.toString());
//            }
//        });
//            liveMovieHomePage();
//            upComingHomePage();
//            topRatedHomePage();
//            airingTvHomePage();
            /** Drawer layout attachment **/
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);


        }

        @Override
        public void onBackPressed () {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                finish();
            }
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_search) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_search_movie) {
                callNewGeneresActivity("Movie Genres");
            } else if (id == R.id.nav_search_tvs) {
                callNewGeneresActivity("TV Genres");
            } else if (id == R.id.nav_popular_movie) {

                newIntentCalling("movie", "popular", API_KEY);
            } else if (id == R.id.nav_top_rated_movie) {

                newIntentCalling("movie", "top_rated", API_KEY);
            } else if (id == R.id.nav_upcoming_movie) {

                newIntentCalling("movie", "upcoming", API_KEY);
            } else if (id == R.id.nav_intheater_movie) {

                newIntentCalling("movie", "now_playing", API_KEY);
            }
            /** TVS Shows started from here **/
            else if (id == R.id.nav_popular_tvs) {

                newIntentCalling("tvs", "popular", API_KEY);
            } else if (id == R.id.nav_top_rated_tvs) {

                newIntentCalling("tvs", "top_rated", API_KEY);
            } else if (id == R.id.nav_ontheair_tvs) {

                newIntentCalling("tvs", "on_the_air", API_KEY);
            } else if (id == R.id.nav_airing_today_tvs) {

                newIntentCalling("tvs", "airing_today", API_KEY);
            }
            /** My Favourate list of movies and tvs show **/
            else if (id == R.id.nav_movie_list) {

                newIntentCalling("movie", "top_rated", API_KEY);
            } else if (id == R.id.nav_tvs_list) {

                newIntentCalling("tvs", "top_rated", API_KEY);
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        /**Ui setup for mainActivity layout**/
        private  void setMyUI(){

            /** Attaching the recycler view with adapter and snaphelper **/
            myview = findViewById(R.id.live_recycle);
            postrUpcoming1 = findViewById(R.id.upcoming_poster_1);
            postrUpcoming2 = findViewById(R.id.upcoming_poster_2);
            postrMostrtd1 = findViewById(R.id.mostrated_poster_1);
            postrMostrtd2 = findViewById(R.id.mostrated_poster_2);
            postrtv1 = findViewById(R.id.livetv_poster_1);
            postrtv2 = findViewById(R.id.livetv_poster_2);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
            myview.setLayoutManager(layoutManager);

        }

        private void setMyUiInvisible(){
//            postrUpcoming1 = findViewById(R.id.upcoming_poster_1);
//            postrUpcoming1.setVisibility(View.INVISIBLE);
//            postrUpcoming2 = findViewById(R.id.upcoming_poster_2);
//            postrUpcoming2.setVisibility(View.INVISIBLE);
//            postrMostrtd1 = findViewById(R.id.mostrated_poster_1);
//            postrMostrtd1.setVisibility(View.INVISIBLE);
//            postrMostrtd2 = findViewById(R.id.mostrated_poster_2);
//            postrMostrtd2.setVisibility(View.INVISIBLE);
//            postrtv1 = findViewById(R.id.livetv_poster_1);
//            postrtv1.setVisibility(View.INVISIBLE);
//            postrtv2 = findViewById(R.id.livetv_poster_2);
//            postrtv2.setVisibility(View.INVISIBLE);
            RelativeLayout mylayout=(RelativeLayout) findViewById(R.id.home_layout);
            mylayout.setVisibility(View.INVISIBLE);
        }


        /** This function is used to animat the recycler view only **/
        private void runLayoutAnimation ( final RecyclerView recyclerView){
            final Context context = recyclerView.getContext();
            final LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_recycler);
            recyclerView.setLayoutAnimation(animationController);
            recyclerView.getAdapter().notifyDataSetChanged();
            recyclerView.scheduleLayoutAnimation();
            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);

        }
        private void liveMovieHomePage () {
            Call<HomePageRespons> call = apiInterface.getLiveMovie(API_KEY);
            call.enqueue(new Callback<HomePageRespons>() {
                @Override
                public void onResponse(Call<HomePageRespons> call, Response<HomePageRespons> response) {
                    int statusCode = response.code();
                    List<HomePage> list = response.body().getResult();
                    myview.setAdapter(new HomePageAdapter(list));
                    runLayoutAnimation(myview);
                }

                @Override
                public void onFailure(Call<HomePageRespons> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }
        /** Calling this method for upcoming movies**/
        private void upComingHomePage () {
            index = 0;
            Call<HomePageRespons> callUpcoming = apiInterface.getUpcomingMovie(API_KEY);
            callUpcoming.enqueue(new Callback<HomePageRespons>() {
                @Override
                public void onResponse(Call<HomePageRespons> call, Response<HomePageRespons> response) {
                    int statusCode = response.code();

                    final List<HomePage> list2 = response.body().getResult();
                    final int totalresult = response.body().getTotalResult();
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            while (index < list2.size() - 1) {
                                try {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Picasso.get().load("https://image.tmdb.org/t/p/w500" + list2.get(index).getPosterPath()).into(postrUpcoming1);
                                            postrUpcoming1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    onClicListening("movie", list2.get(index - 2).getPosterPath(), list2.get(index - 2).getTitle(), list2.get(index - 2).getId());
                                                }
                                            });
                                            Picasso.get().load("https://image.tmdb.org/t/p/w500" + list2.get(index + 1).getPosterPath()).into(postrUpcoming2);
                                            postrUpcoming2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    onClicListening("movie", list2.get(index - 1).getPosterPath(), list2.get(index - 1).getTitle(), list2.get(index - 1).getId());
                                                }
                                            });
// Log.v("result",list2.get(index).getPosterPath()+String.valueOf(index));
                                            index = index + 2;
                                        }
                                    });
                                    Thread.sleep(11000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }.start();
                }

                @Override
                public void onFailure(Call<HomePageRespons> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }
        /** TopRated Movie API calling **/
        private void topRatedHomePage () {
            index1 = 0;
            Call<HomePageRespons> topRated = apiInterface.getTopRatedMovie(API_KEY);
            topRated.enqueue(new Callback<HomePageRespons>() {
                @Override
                public void onResponse(Call<HomePageRespons> call, Response<HomePageRespons> response) {
                    int statusCode = response.code();

                    final List<HomePage> list3 = response.body().getResult();
                    final int totalResult = response.body().getTotalResult();
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            while (index1 < list3.size() - 1) {
                                try {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Picasso.get().load("https://image.tmdb.org/t/p/w500" + list3.get(index1).getPosterPath()).into(postrMostrtd1);
                                            postrMostrtd1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
//                                                Toast.makeText(MainActivity.this, "TITLE: "+list3.get(index1-2).getTitle(), Toast.LENGTH_SHORT).show();
//                                                Log.v("Onclick",list3.get(index1).getTitle());
                                                    onClicListening("movie", list3.get(index1 - 2).getPosterPath(), list3.get(index1 - 2).getTitle(), list3.get(index1 - 2).getId());
                                                }
                                            });

                                            Picasso.get().load("https://image.tmdb.org/t/p/w500" + list3.get(index1 + 1).getPosterPath()).into(postrMostrtd2);
                                            postrMostrtd2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
//                                                Toast.makeText(MainActivity.this, "TITLE: "+list3.get(index1-1).getTitle(), Toast.LENGTH_SHORT).show();
                                                    onClicListening("movie", list3.get(index1 - 1).getPosterPath(), list3.get(index1 - 1).getTitle(), list3.get(index1 - 1).getId());
                                                }
                                            });
                                            index1 = index1 + 2;
                                        }
                                    });
                                    Thread.sleep(13000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }.start();
                }

                @Override
                public void onFailure(Call<HomePageRespons> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }
        /** Airing Todays Tv API Calling **/
        private void airingTvHomePage () {
            index2 = 0;
            Call<tvPageResponse> airingTv = apiInterface.getAiringTodayTv(API_KEY);
            airingTv.enqueue(new Callback<tvPageResponse>() {
                @Override
                public void onResponse(Call<tvPageResponse> call, Response<tvPageResponse> response) {
                    final int statusCode = response.code();
                    final List<TvPage> tvlist = response.body().getResult();
                    final int totalResult = response.body().getTotalResult();
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            while (index2 < tvlist.size() - 2) {
                                try {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Picasso.get().load("https://image.tmdb.org/t/p/w500" + tvlist.get(index2).getPosterPath()).into(postrtv1);
                                            postrtv1.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    onClicListening("tv", tvlist.get(index2 - 2).getPosterPath(), tvlist.get(index2 - 2).getTitle(), tvlist.get(index2 - 2).getId());
                                                }
                                            });
                                            Picasso.get().load("https://image.tmdb.org/t/p/w500" + tvlist.get(index2 + 1).getPosterPath()).into(postrtv2);
                                            postrtv2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    onClicListening("tv", tvlist.get(index2 - 2).getPosterPath(), tvlist.get(index2 - 2).getTitle(), tvlist.get(index2 - 2).getId());
                                                }
                                            });
                                            index2 = index2 + 2;
                                        }
                                    });
                                    Thread.sleep(9000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }.start();
                }

                @Override
                public void onFailure(Call<tvPageResponse> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });
        }

        /*Functon call to start new Activity from the navigayion Drawer ,list of different type of movie and tvs*/
        private void newIntentCalling (String type, String path, String apikey){
            Intent i = new Intent(this, MovieAndTVList.class);
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            bundle.putString("path", path);
            bundle.putString("apikey", apikey);
            i.putExtras(bundle);
            startActivity(i);
//        Call<HomePageRespons> call=apiInterface.getMovieOption(path,apikey);
//        index3=0;
//        call.enqueue(new Callback<HomePageRespons>() {
//            @Override
//            public void onResponse(Call<HomePageRespons> call, Response<HomePageRespons> response) {
//                final List<HomePage> list=response.body().getResult();
//                while(index3<list.size()){
//                    Log.v("api",list.get(index3).getTitle());
//                    index3++;
//                }
//            }
//
//            @Override
//            public void onFailure(Call<HomePageRespons> call, Throwable t) {
//                Log.e(TAG,t.toString());
//            }
//        });


        }

        /* Function Call to show the details for upcoming,top_rated and airing_todat wedigts*/
        private void onClicListening (String type, String ppath, String title,int id){
            if (type.equals("movie")) {
                Intent intent = new Intent(this, MovieDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("type", type);
                bundle.putString("posterpath", ppath);
                bundle.putString("title", title);
                bundle.putInt("id", id);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Intent tvintent = new Intent(this, TvDetails.class);
                Bundle tvbundle = new Bundle();
                tvbundle.putString("type", type);
                tvbundle.putString("posterpath", ppath);
                tvbundle.putString("title", title);
                tvbundle.putInt("id", id);
                tvintent.putExtras(tvbundle);
                startActivity(tvintent);
            }
        }

        /*Function call for start Genres Activity from Navigation Drawer */
        private void callNewGeneresActivity (String type){
            Intent intent = new Intent(this, GenresActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    private boolean checkInternet(){
        ConnectivityManager cm=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
    return ni!=null && ni.isConnectedOrConnecting();
    }
}
