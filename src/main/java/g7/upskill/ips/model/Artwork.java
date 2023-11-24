package g7.upskill.ips.model;

import java.time.LocalDate;

public class Artwork {
    private transient int id_Artwork;
    private String title;
    private LocalDate date;
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

    public LocalDate getDate() {
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

    public void setId_Artwork(int id_Artwork) {
        this.id_Artwork = id_Artwork;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId_Exhibition(int id_Exhibition) {
        this.id_Exhibition = id_Exhibition;
    }

    public void setId_Gene(int id_Gene) {
        this.id_Gene = id_Gene;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "id_Artwork=" + id_Artwork +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", thumbnail='" + thumbnail + '\'' +
                ", url='" + url + '\'' +
                ", id_Exhibition=" + id_Exhibition +
                ", id_Gene=" + id_Gene +
                '}';
    }
}
