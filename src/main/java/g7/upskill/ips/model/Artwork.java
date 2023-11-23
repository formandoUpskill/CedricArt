package g7.upskill.ips.model;

public class Artwork {
    private transient int id_Artwork;
    private String title;
    private String date;
    private String thumbnail;
    private String url;
    private transient int id_Exhibition;
    private transient int id_Gene;

    public int getId_Artwork() {
        return id_Artwork;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public int getId_Exhibition() {
        return id_Exhibition;
    }

    public int getId_Gene() {
        return id_Gene;
    }
}
