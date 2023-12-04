package g7.upskill.ips.clients;

import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.model.*;
import g7.upskill.ips.persistence.DBStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetAllApi {


    Properties config;

    public static void loadAllGenes() {

        new LigacaoArtsy();

        String xappToken = LigacaoArtsy.generateXappToken();

        String apiUrl = "https://api.artsy.net/api/genes?size=100&total_count=true";

        DBStorage storage = new DBStorage();
        List<Gene> geneList = new ArrayList<>();

        do {
            apiUrl = GetAllApiGenes.getAllGenes(apiUrl, xappToken, geneList);

        }
        while (!apiUrl.isBlank());

        System.out.println(geneList.size());

        for (Gene gene : geneList) {
            // inserir esse artista na base de dados
            storage.createGene(gene);
        }
    }


    public static void loadAllArtistsArworksPartnersExhibitions() {
        DBStorage storage = new DBStorage();
        List<Artist> artistsList = new ArrayList<>();
        List<Artwork> artworksList = new ArrayList<>();
        List<Gene> geneList = new ArrayList<>();
        List<Exhibition> exhibitionList = new ArrayList<>();


        String xappToken = LigacaoArtsy.generateXappToken();

        String apiUrl = "";

        // Obter todos os artistas com obras de arte
        apiUrl = "https://api.artsy.net/api/artists?artworks=true&size=100&total_count=true";
        do {
            apiUrl = GetAllApiArtists.getAllArtistsIdWithArtworks(apiUrl, xappToken, artistsList);

        }
        while (!apiUrl.isBlank());


        for (Artist artist : artistsList) {
            // inserir esse artista na base de dados
            storage.createArtist(artist);


            // obter a lista de obras de arte desse artista
            artworksList = new ArrayList<>();
            apiUrl = artist.getArtworksLink() + "&total_count=true";

            apiUrl = GetAllApiArtwork.getAllArtworksOfAnArtist(apiUrl, xappToken, artworksList);

            for (Artwork artwork : artworksList) {
                // Obter a lista de genes dessa obra
                geneList = new ArrayList<>();
                apiUrl = artwork.getGenesLink() + "&total_count=true";
                do {
                    apiUrl = GetAllApiGenes.getAllGenes(apiUrl, xappToken, geneList);

                }
                while (!apiUrl.isBlank());

                // inserir essa obra de arte na base de dados
                storage.createArtwork(artwork, geneList, artist);

                // ir buscar o partner que tem essa obra de arte

                apiUrl = artwork.getPartnersLink();
                if (apiUrl != null) {
                    Partner partner = GetAllApiPartners.searchPartner(apiUrl, xappToken, 1, 2);

                    storage.createPartner(partner, artwork);

                    // obter todas as exposições desse partner

                    apiUrl = partner.getShowsLink() + "&total_count=true";


                    exhibitionList = new ArrayList<>();
                    do {
                        apiUrl = GetAllApiExhibition.searchAllExhibitions(apiUrl, xappToken, exhibitionList);

                    }
                    while (!apiUrl.isBlank());

                    for (Exhibition exhibition : exhibitionList) {
                        // Inserir o show na tabela exibibion e levar o id_partner (fk)
                        storage.createExhibition(exhibition, partner, artwork);
                    }
                }
            }

        }


    }


    public static void main(String[] args) {



    }
}
