package g7.upskill.ips;

import g7.upskill.ips.clients.GetAllApi;
import g7.upskill.ips.model.Artist;
import g7.upskill.ips.model.Gene;
import g7.upskill.ips.persistence.DBStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

// inserir todos os genes na base de dados
        GetAllApi.loadAllGenes();

        // Inserir os restantes elementos nas respectivas tabelas
        GetAllApi.loadAllArtistsArworksPartnersExhibitions();

    }
}