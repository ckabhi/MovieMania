package abhishekkumar.moviemania.Model;
/* This provide generic type of object which is used in the List to pass the different value together in adapter class */
public class GenresModel {
    private String name,posterpath;
    private int id;

    public GenresModel(int id,String name, String posterpath) {
        this.name = name;
        this.posterpath = posterpath;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterpath() {
        return posterpath;
    }

    public void setPosterpath(String posterpath) {
        this.posterpath = posterpath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
