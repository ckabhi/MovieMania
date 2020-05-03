package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CastPreModel {
    @SerializedName("cast")
    private List<CastModel> castPrelist;

    public List<CastModel> getCastPrelist() {
        return castPrelist;
    }

    public void setCastPrelist(List<CastModel> castPrelist) {
        this.castPrelist = castPrelist;
    }
}
