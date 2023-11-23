package g7.upskill.ips.model;

import java.time.LocalDate;

public class Exhibition {
    private transient int id_Exhibition;
    private LocalDate end_at;
    private LocalDate start_at;
    private String image;
    private String description;
    private String name;
    private String url;
    private transient int id_Partner;

    public int getId_Exhibition() {
        return id_Exhibition;
    }

    public LocalDate getEnd_at() {
        return end_at;
    }

    public LocalDate getStart_at() {
        return start_at;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getId_Partner() {
        return id_Partner;
    }

    public void setId_Exhibition(int id_Exhibition) {
        this.id_Exhibition = id_Exhibition;
    }

    public void setEnd_at(LocalDate end_at) {
        this.end_at = end_at;
    }

    public void setStart_at(LocalDate start_at) {
        this.start_at = start_at;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId_Partner(int id_Partner) {
        this.id_Partner = id_Partner;
    }
}
