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
import abhishekkumar.moviemania.R;
import abhishekkumar.moviemania.View.MovieDetailsActivity;

/* This class is used to provide the adapter for recycllerView which is used in home page for live Movie. */
public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.MyviewHolder> {
    private List<HomePage> myresponse;

    public HomePageAdapter(List<HomePage> myresponse) {
        this.myresponse = myresponse;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.livenow_list,parent,false);
        return new MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500"+myresponse.get(position).getPosterPath())
                .into(holder.liveposter);
        holder.status.setText("LIVE");
        holder.rating.setText(String.valueOf(myresponse.get(position).getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return myresponse.size();
    }


    public class MyviewHolder extends RecyclerView.ViewHolder {
        private ImageView liveposter;
        private TextView status,rating;
        private MyviewHolder(final View itemView) {
            super(itemView);
            liveposter=itemView.findViewById(R.id.live_poster);
            status=itemView.findViewById(R.id.live_nowtitle);
            rating=itemView.findViewById(R.id.live_now_rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HomePage homePage=myresponse.get(getAdapterPosition());
                    Intent intent=new Intent(itemView.getContext(),MovieDetailsActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("title",homePage.getTitle());
                    bundle.putString("type","movie");
                    bundle.putString("posterpath",homePage.getPosterPath());
                    bundle.putInt("id",homePage.getId());
                    intent.putExtras(bundle);
//                    Log.v("moviehome",homePage.getTitle()+homePage.getId());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
