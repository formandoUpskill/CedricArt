package g7.upskill.ips.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Exhibition {
    private String id;
    private LocalDateTime end_at;
    private LocalDateTime start_at;
    private String image;
    private String description;
    private String name;
    private String url;
    private String id_Partner;

    public String getId() {
        return id;
    }

    public LocalDateTime getEnd_at() {
        return end_at;
    }

    public LocalDateTime getStart_at() {
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

    public String getId_Partner() {
        return id_Partner;
    }

    public void setId_Exhibition(String id) {
        this.id = id;
    }

    public void setEnd_at(LocalDateTime end_at) {
        this.end_at = end_at;
    }

    public void setStart_at(LocalDateTime start_at) {
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

    public void setId_Partner(String id_Partner) {
        this.id_Partner = id_Partner;
    }
}
