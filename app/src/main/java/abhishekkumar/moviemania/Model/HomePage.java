package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;
/* It provide the extra control while calling the api like fore changing the page and others*/

public class HomePage {

    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("id")
    private int id;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("title")
    private String title;

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath =posterPath;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
