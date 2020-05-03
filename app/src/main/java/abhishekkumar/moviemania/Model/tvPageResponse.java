package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class tvPageResponse {
    @SerializedName("results")
    private List<TvPage> result;
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResult;
    @SerializedName("total_pages")
    private int totalPage;

    public List<TvPage> getResult() {
        return result;
    }

    public void setResult(List<TvPage> result) {
        this.result = result;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
