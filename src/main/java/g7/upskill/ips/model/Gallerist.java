package g7.upskill.ips.model;

import java.time.LocalDate;

public class Gallerist extends User{
    private transient int id_Gallerist;
    private LocalDate start_at;
    private LocalDate end_at;

    public int getId_Gallerist() {
        return id_Gallerist;
    }

    public LocalDate getStart_at() {
        return start_at;
    }

    public LocalDate getEnd_at() {
        return end_at;
    }

    public void setId_Gallerist(int id_Gallerist) {
        this.id_Gallerist = id_Gallerist;
    }

    public void setStart_at(LocalDate start_at) {
        this.start_at = start_at;
    }

    public void setEnd_at(LocalDate end_at) {
        this.end_at = end_at;
    }
}
