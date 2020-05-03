package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
/* This class is used to provide the list type for storing the value while api calling for movie details*/
public class MovieDetailsPage {
    @SerializedName("budget")
    private long budget;
    @SerializedName("backdrop_path")
    private String posterPath;
    @SerializedName("original_language")
    private String lang;
    @SerializedName("revenue")
    private long revenue;
    @SerializedName("runtime")
    private int runTime;
    @SerializedName("status")
    private String status;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
