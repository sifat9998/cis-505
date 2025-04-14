public class Composer {
    private int id;
    private String name;
    private String genre;

    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGenre() { return genre; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return String.format("Id: %d\nName: %s\nGenre: %s", id, name, genre);
    }
}
