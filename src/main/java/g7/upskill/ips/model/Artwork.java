package g7.upskill.ips.model;



import java.time.LocalDateTime;
import java.util.UUID;


public class Artwork {
    private transient int id_Artwork;


    private String title;


     private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String thumbnail;
    private String url;

    private String date;
    private transient int id_Exhibition;
    private transient int id_Gene;

    public int getId_Artwork() {
        return id_Artwork;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
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

    public void setCreated_at(LocalDateTime date) {
        this.created_at = date;
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

    public String getDate() {
        return date;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "id_Artwork=" + id_Artwork +
                ", title='" + title + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", thumbnail='" + thumbnail + '\'' +
                ", url='" + url + '\'' +
                ", date='" + date + '\'' +
                ", id_Exhibition=" + id_Exhibition +
                ", id_Gene=" + id_Gene +
                '}';
    }
}
