package abhishekkumar.moviemania.Model;

import com.google.gson.annotations.SerializedName;

public class CastModel {
    @SerializedName("character")
    private String character;
    @SerializedName("id")
    private int id;
    @SerializedName("credit_id")
    private String crediId;
    @SerializedName("name")
    private String name;
    @SerializedName("profile_path")
    private String prifilrPath;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCrediId() {
        return crediId;
    }

    public void setCrediId(String crediId) {
        this.crediId = crediId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrifilrPath() {
        return prifilrPath;
    }

    public void setPrifilrPath(String prifilrPath) {
        this.prifilrPath = prifilrPath;
    }
}
