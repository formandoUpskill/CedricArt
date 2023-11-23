package g7.upskill.ips.model;

import java.time.LocalDate;

public class Coordinator extends User{
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
}
