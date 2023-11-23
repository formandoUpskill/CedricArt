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
}
