package g7.upskill.ips.model;

public class Gene {

    private transient int id;

    private String name;

    private String description;

    public int getId() {
       return id;
     }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

    }


    public void setName(String name) {
        this.name = name;
    }
}

