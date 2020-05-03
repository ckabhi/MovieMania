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
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import abhishekkumar.moviemania.Model.GenresModel;
import abhishekkumar.moviemania.R;
import abhishekkumar.moviemania.View.MovieAndTVList;

public class GenresListAdapter extends RecyclerView.Adapter<GenresListAdapter.MyviewHolder> {
    private List<GenresModel> response;
    private String type;
    private final String API_KEY="5a05b0f74b9986a3f1deb838cec732c2";

    public GenresListAdapter(List<GenresModel> response, String type) {
        this.response = response;
        this.type = type;
    }

    @NonNull
    @Override
    public GenresListAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.genreslist,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenresListAdapter.MyviewHolder holder, int position) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+response.get(position).getPosterpath()).into(holder.poster);
        holder.name.setText(response.get(position).getName().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return response.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private ImageView poster;
        private TextView name;
        public MyviewHolder(final View itemView) {
            super(itemView);
            poster=itemView.findViewById(R.id.genresposter);
            name=itemView.findViewById(R.id.genres_type);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GenresModel genresModel=response.get(getAdapterPosition());
//                    Toast.makeText(itemView.getContext(),genresModel.getName(), Toast.LENGTH_SHORT).show();
                    if (type.equals("Movie Genres")){
                        Intent movieIntent=new Intent(itemView.getContext(),MovieAndTVList.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("type",type);
                        bundle.putString("apikey",API_KEY);
                        bundle.putInt("genre",genresModel.getId());
                        movieIntent.putExtras(bundle);
                        itemView.getContext().startActivity(movieIntent);
                    }else {
                        Intent tvIntent=new Intent(itemView.getContext(),MovieAndTVList.class);
                        Bundle bundle2=new Bundle();
                        bundle2.putString("type",type);
                        bundle2.putString("apikey",API_KEY);
                        bundle2.putInt("genre",genresModel.getId());
                        tvIntent.putExtras(bundle2);
                        itemView.getContext().startActivity(tvIntent);
                    }
                }
            });
        }
    }
}
