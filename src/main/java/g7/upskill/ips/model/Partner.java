package g7.upskill.ips.model;

public class Partner {
    private transient int id_partner;
    private String region;
    private String url;
    private String name;
    private String website;
    private String id_gallerist;
    private String id_coordinator;

    public int getId_partner() {
        return id_partner;
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

    public String getId_gallerist() {
        return id_gallerist;
    }

    public String getId_coordinator() {
        return id_coordinator;
    }

    public void setId_partner(int id_partner) {
        this.id_partner = id_partner;
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

    public void setId_gallerist(String id_gallerist) {
        this.id_gallerist = id_gallerist;
    }

    public void setId_coordinator(String id_coordinator) {
        this.id_coordinator = id_coordinator;
    }
}
