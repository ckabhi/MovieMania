package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailsVideo {
    @SerializedName("results")
    private List<Video> video;


    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }





    public class Video{
        @SerializedName("name")
        private String name;
        @SerializedName("key")
        private String key;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
