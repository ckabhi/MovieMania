package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvDetailsPage {
    @SerializedName("status")
    private String tvStatus;
    @SerializedName("type")
    private String tvtype;
    @SerializedName("vote_average")
    private double rating;
    @SerializedName("vote_count")
    private int votecount;
    @SerializedName("overview")
    private String overview;
    @SerializedName("number_of_seasons")
    private int season;
    @SerializedName("number_of_episodes")
    private int episode;
    @SerializedName("first_air_date")
    private String fairdate;
    @SerializedName("last_air_date")
    private String lairdate;
    @SerializedName("original_language")
    private String language;

    public String getTvStatus() {
        return tvStatus;
    }

    public void setTvStatus(String tvStatus) {
        this.tvStatus = tvStatus;
    }

    public String getTvtype() {
        return tvtype;
    }

    public void setTvtype(String tvtype) {
        this.tvtype = tvtype;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getFairdate() {
        return fairdate;
    }

    public void setFairdate(String fairdate) {
        this.fairdate = fairdate;
    }

    public String getLairdate() {
        return lairdate;
    }

    public void setLairdate(String lairdate) {
        this.lairdate = lairdate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
