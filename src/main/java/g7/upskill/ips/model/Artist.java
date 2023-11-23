package g7.upskill.ips.model;

public class Artist {
    private transient int id_Artist;
    private String location;
    private String nationality;
    private String hometown;
    private String name;
    private String biography;
    private String slug;
    private String birthyear;
    private String deathyear;
    private String thumbnail;
    private String url;
    private transient int country_code;


    public String getName() {
        return name;
    }

    public int getId_Artist() {
        return id_Artist;
    }

    public String getLocation() {
        return location;
    }

    public String getNationality() {
        return nationality;
    }

    public String getHometown() {
        return hometown;
    }

    public String getBiography() {
        return biography;
    }

    public String getSlug() {
        return slug;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public String getDeathyear() {
        return deathyear;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public int getCountry_code() {
        return country_code;
    }
}
