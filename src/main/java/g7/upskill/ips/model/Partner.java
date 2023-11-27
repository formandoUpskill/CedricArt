package g7.upskill.ips.model;

public class Partner {
    private  String id;
    private String region;
    private String url;
    private String name;
    private String website;
    private int id_gallerist;
    private int id_coordinator;

    public String getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public int getId_gallerist() {
        return id_gallerist;
    }

    public int getId_coordinator() {
        return id_coordinator;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setId_gallerist(int id_gallerist) {
        this.id_gallerist = id_gallerist;
    }

    public void setId_coordinator(int id_coordinator) {
        this.id_coordinator = id_coordinator;
    }
}
