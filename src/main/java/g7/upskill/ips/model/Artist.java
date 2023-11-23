package g7.upskill.ips.model;

public class Artist {
    private transient int id_Artist;
    private String location;
    private String hometown;
    private String name;
    private String biography;
    private String slug;
    private String birthyear;
    private String deathyear;
    private String thumbnail;
    private String url;
    private String nationality;
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

    public void setId_Artist(int id_Artist) {
        this.id_Artist = id_Artist;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public void setDeathyear(String deathyear) {
        this.deathyear = deathyear;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setCountry_code(int country_code) {
        this.country_code = country_code;
    }
}
