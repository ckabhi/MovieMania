package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomePageRespons {
    @SerializedName("results")
    private List<HomePage> result;
    @SerializedName("page")
    private int page;
    @SerializedName("total_pages")
    private int totalPage;
    @SerializedName("total_results")
    int totalResult;

    public List<HomePage> getResult() {
        return result;
    }

    public void setResult(List<HomePage> result) {
        this.result = result;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }
}
