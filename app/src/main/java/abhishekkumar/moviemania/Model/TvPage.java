package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;

public class TvPage {
    @SerializedName("name")
    private String title;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("id")
    private int id;
    @SerializedName("vote_average")
    private double voteAverage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
