package g7.upskill.ips.clients;

import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.model.*;
import g7.upskill.ips.persistence.DBStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetAllApi {


   private  DBStorage storage;
   // private Properties config;

    public GetAllApi(){
        this.storage = new DBStorage();
        new LigacaoArtsy();
    }


    public void loadAllGenes() {

      //  new LigacaoArtsy();

        String xappToken = LigacaoArtsy.generateXappToken();

        String apiUrl = "https://api.artsy.net/api/genes?total_count=true";

       //  DBStorage storage = new DBStorage();
        List<Gene> geneList = new ArrayList<>();

        do {
            apiUrl = GetAllApiGenes.getAllGenes(apiUrl, xappToken, geneList);

        }
        while (!apiUrl.isBlank());

        System.out.println(geneList.size());

        for (Gene gene : geneList) {
            // inserir esse artista na base de dados
            this.storage.createGene(gene);
        }
    }


    public void loadAllArtistsArworksPartnersExhibitions() {
       // DBStorage storage = new DBStorage();
        List<Artist> artistsList = new ArrayList<>();
        List<Artwork> artworksList = new ArrayList<>();
        List<Artwork> artworksShowsList = new ArrayList<>();
        List<Gene> geneList = new ArrayList<>();
        List<Exhibition> exhibitionList = new ArrayList<>();


        String xappToken = LigacaoArtsy.generateXappToken();

        String apiUrl = "";

        // Obter todos os artistas com obras de arte
        apiUrl = "https://api.artsy.net/api/artists?artworks=true&size=1000&total_count=true";
        do {
            apiUrl = GetAllApiArtists.getAllArtistsIdWithArtworks(apiUrl, xappToken, artistsList);

        }
        while (!apiUrl.isBlank());


        for (Artist artist : artistsList) {
            // inserir esse artista na base de dados
            this.storage.createArtist(artist);


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
                this.storage.createArtwork(artwork, geneList, artist);

                // ir buscar o partner que tem essa obra de arte

                apiUrl = artwork.getPartnersLink();
                if (apiUrl != null) {
                    Partner partner = GetAllApiPartners.searchPartner(apiUrl, xappToken, 1, 2);

                    this.storage.createPartner(partner, artwork);

                    // obter todas as exposições desse partner

                    apiUrl = partner.getShowsLink() + "&total_count=true";

                    if (apiUrl != null) {

                        exhibitionList = new ArrayList<>();
                        do {
                            apiUrl = GetAllApiExhibition.searchAllExhibitions(apiUrl, xappToken, exhibitionList);

                        }
                        while (!apiUrl.isBlank());

                        for (Exhibition exhibition : exhibitionList) {
                            // Inserir o show na tabela exibibion e levar o id_partner (fk)
                            this.storage.createExhibition(exhibition, partner, artwork);

                        }
                    }
                }
            }

        }
    }

    // Obter todas as obras de arte dessa exposição

    public void insertExhibitionArtworks()
    {
/*
                        // Obter todas as obras de arte dessa exposição
                        apiUrl = exhibition.getArtworksLink() + "&total_count=true";
                        System.out.println("artworksShowsList " + apiUrl);
                        // https://api.artsy.net/api/artworks?show_id=4f6a3a300b665e0001000094

                        artworksShowsList= new ArrayList<>();

                        do {
                            apiUrl = GetAllApiArtwork.getAllArtworksOfAnShow(apiUrl, xappToken, artworksShowsList);

                        }
                        while (!apiUrl.isBlank());

                        System.out.println("artworksShowsList " + artworksShowsList.size());

                        for (Artwork artworkShow : artworksShowsList) {

                            storage.insertExhibitionArtwork(artworkShow,exhibition);
                        }
*/

    }


    public static void main(String[] args) {



    }
}
