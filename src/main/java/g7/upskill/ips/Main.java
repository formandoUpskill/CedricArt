package g7.upskill.ips;

import g7.upskill.ips.clients.GetAllApi;
import g7.upskill.ips.model.Artist;
import g7.upskill.ips.model.Gene;
import g7.upskill.ips.persistence.DBStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {


        GetAllApi getAllApi = new GetAllApi();

        System.out.println("GetAllApi GetAllApi GetAllApi");

// inserir todos os genes na base de dados
        getAllApi.loadAllGenes();

        // Inserir os restantes elementos nas respectivas tabelas
        getAllApi.loadAllArtistsArworksPartnersExhibitions();


    }
}