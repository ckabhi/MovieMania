package abhishekkumar.moviemania.Controler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import abhishekkumar.moviemania.Model.HomePage;
import abhishekkumar.moviemania.Model.TvPage;
import abhishekkumar.moviemania.R;
import abhishekkumar.moviemania.View.MovieDetailsActivity;
import abhishekkumar.moviemania.View.TvDetails;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
   private List<HomePage> movieresponse;
   private List<TvPage> tvsresponse;
   private String type;
//   private String type;


    public MovieListAdapter(List<HomePage> movieresponse,String type) {
        this.movieresponse = movieresponse;
        this.type=type;
    }
    public  MovieListAdapter(List<TvPage> tvsresponse){
        this.tvsresponse=tvsresponse;
        this.type="tvs";
    }

    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        if (type.equals("movie") || type.equals("Movie Genres")) {
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" + movieresponse.get(position).getPosterPath())
                    .into(holder.moviePoster);
            holder.title.setText(movieresponse.get(position).getTitle());
            holder.rating.setText(String.valueOf(movieresponse.get(position).getVoteAverage()));
        }else{
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500" + tvsresponse.get(position).getPosterPath())
                    .into(holder.moviePoster);
            holder.title.setText(tvsresponse.get(position).getTitle());
            holder.rating.setText(String.valueOf(tvsresponse.get(position).getVoteAverage()));
        }
    }

    @Override
    public int getItemCount() {
        int size;
        if (type.equals("movie")|| type.equals("Movie Genres")) {
            size= movieresponse.size();
        }else {
            size=tvsresponse.size();
        }
        return size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView moviePoster;
        private TextView title,rating;
        private MyViewHolder(final View itemView) {
            super(itemView);
            moviePoster=itemView.findViewById(R.id.movie_list_poster);
            title= itemView.findViewById(R.id.movie_list_tite);
            rating=itemView.findViewById(R.id.movie_list_rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (type.equals("movie")|| type.equals("Movie Genres")){
                        HomePage homePage=movieresponse.get(getAdapterPosition());
//                        Toast.makeText(ctx, homePage.getTitle(), Toast.LENGTH_SHORT).show();
//                        Log.v("Onclickevent",homePage.getTitle()+"AND"+homePage.getId()+"/"+ctx);
                        Intent detailsActivity=new Intent(itemView.getContext(),MovieDetailsActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("id",homePage.getId());
                        bundle.putString("title",homePage.getTitle());
                        bundle.putString("posterpath",homePage.getPosterPath());
//                        Log.v("posterpath",homePage.getPosterPath());
                        bundle.putString("type",type);
                        detailsActivity.putExtras(bundle);
                        itemView.getContext().startActivity(detailsActivity);

                    }else{
                        TvPage tvPage=tvsresponse.get(getAdapterPosition());
                        Intent intent=new Intent(itemView.getContext(),TvDetails.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("id",tvPage.getId());
                        bundle.putString("title",tvPage.getTitle());
                        bundle.putString("posterpath",tvPage.getPosterPath());
                        bundle.putString("type",type);
                        intent.putExtras(bundle);
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
