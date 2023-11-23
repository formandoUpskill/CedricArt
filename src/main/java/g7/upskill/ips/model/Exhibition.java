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
}
