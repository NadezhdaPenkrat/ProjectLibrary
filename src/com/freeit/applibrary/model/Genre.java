package src.com.freeit.applibrary.model;

public class Genre {

    private long id;
    private String name;

    public static GenreStyle valueOf(String toUpperCase) {

        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}