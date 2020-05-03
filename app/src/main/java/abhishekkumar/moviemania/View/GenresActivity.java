package abhishekkumar.moviemania.View;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import abhishekkumar.moviemania.Controler.GenresListAdapter;
import abhishekkumar.moviemania.Model.GenresModel;
import abhishekkumar.moviemania.R;

public class GenresActivity extends AppCompatActivity {
private String type;
private List<GenresModel> list=new ArrayList<>();
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);
        ActionBar actionBar=getSupportActionBar();
        recyclerView=findViewById(R.id.genres_recyclerview);
        Bundle bundle=getIntent().getExtras();
        type=bundle.getString("type");
        actionBar.setTitle(type);

        if (type.equals("Movie Genres")){
            movielistSetup();
        }else {
            tvlistSetup();
        }
//        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);
//        RecyclerView.LayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new GenresListAdapter(list,type));


    }
    private void movielistSetup(){
        GenresModel genresModel=new GenresModel(28,"Action","/AuA50D7T7S7OEVcGo0ZKaMhERn0.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(12,"Adventure","/aw4FOsWr2FY373nKSxbpNi3fz4F.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(35,"Comedy","/b7Q0uX4Tcd6lXWItJEMxYk9XBbc.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(16,"Animation","/88poTBTafMXaz73vYi3c74g0y2k.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(80,"Crime","/gqemVzi13T4oB95EBufIxqafSCl.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(99,"Documentary","/55Anuv1GtRUr8LZS0lkxtKMtl3W.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(18,"Drama","/tmsddF6G7vIbJ2Lg6DZDVbnhBxs.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10751,"Family","/wDN3FIcQQ1HI7mz1OOKYHSQtaiE.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(14,"Fantasy","/b6ZJZHUdMEFECvGiDpJjlfUWela.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(36,"History","/tT59Hcfj4Jb3qlTsJDuT0Sn7COl.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(27,"Horror","/fgsHxz21B27hOOqQBiw9L6yWcM7.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10402,"Music","/pbXgLEYh8rlG2Km5IGZPnhcnuSz.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(9648,"Mystery","/3CCfgSvtvN3HwVs5hbcC1NhOAzw.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10749,"Romance","/saK9BZM3yuyucTz71UrQcVcMg9M.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(878,"Sci-fi","/rxYG6Sj95as9rv9wKIHUx6ATWd3.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10770,"TV Movie","/rtPtwVTo4RqumivX2zspSk8GyCy.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10752,"War","/fudEG1VUWuOqleXv6NwCExK0VLy.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(37,"Western","/90kmxuSwU28dVy1ghVSHI4x1wb8.jpg");
        list.add(genresModel);



    }
    private void tvlistSetup(){
        GenresModel genresModel=new GenresModel(28,"Action","/qPvvbMIe8pOHGQ0e8bq1Ely7qGL.jpg");
        list.add(genresModel);
//        genresModel=new GenresModel(12,"Adventure","/aw4FOsWr2FY373nKSxbpNi3fz4F.jpg");
//        list.add(genresModel);
        genresModel=new GenresModel(35,"Comedy","/nGsNruW3W27V6r4gkyc3iiEGsKR.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(16,"Animation","/l5pFSS9E6SSFA8QZ8mjTVB3OrNf.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(80,"Crime","/gqemVzi13T4oB95EBufIxqafSCl.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(99,"Documentary","/2XAaObTzZKomc3wVU2iGgnQHGxk.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(18,"Drama","/mKBP1OCgCG0jw8DwVYlnYqVILtc.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10751,"Family","/jzlRzNRyz8rVIIfnsXkAa9gV8jD.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(14,"Fantasy","/b6ZJZHUdMEFECvGiDpJjlfUWela.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10762,"Kids","/c14vjmndzL9tBdooGsMznMFrFLo.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10763,"News","/ATH47CH9nZ7IC6PUt4iXlesXI4.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10764,"Reality","/66uAz0ubQL7ojETBSmLbF8iwiAP.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(9648,"Mystery","/9XgVqYPY7gDuCpymmTwwpXA1IB5.jpg");
        list.add(genresModel);
//        genresModel=new GenresModel(10766,"Soap","/4IMptN7S7VJs6tyLOx5dOTPsOx8.jpg");
//        list.add(genresModel);
        genresModel=new GenresModel(878,"Sci-fi","/2qou2R47XZ1N6SlqGZcoCHDyEhN.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10767,"Talk","/7wri8hbMd1yZWIFubnZTe9ZJrKT.jpg");
        list.add(genresModel);
        genresModel=new GenresModel(10752,"War","/fudEG1VUWuOqleXv6NwCExK0VLy.jpg");
        list.add(genresModel);
//        genresModel=new GenresModel(37,"Western","/90kmxuSwU28dVy1ghVSHI4x1wb8.jpg");
//        list.add(genresModel);
    }
}
