package abhishekkumar.moviemania.Controler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import abhishekkumar.moviemania.Model.CastModel;
import abhishekkumar.moviemania.R;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.MyViewHolder> {
    private List<CastModel> mylist;

    public CastAdapter(List<CastModel> mylist) {
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public CastAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CastAdapter.MyViewHolder holder, int position) {
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500"+mylist.get(position).getPrifilrPath())
                .into(holder.profilePhoto);
        holder.charecter.setText(mylist.get(position).getCharacter());
        holder.realName.setText(mylist.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView charecter,realName;
        ImageView profilePhoto;
        public MyViewHolder(View itemView) {
            super(itemView);
            charecter=itemView.findViewById(R.id.character_name);
            realName=itemView.findViewById(R.id.real_name);
            profilePhoto=itemView.findViewById(R.id.cast_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
