package g7.upskill.ips.clients;

import g7.upskill.ips.LigacaoArtsy;

public class GetAllApi {

    public static void main(String[] args) {


        boolean test= true;

        String xappToken= LigacaoArtsy.generateXappToken();
        String apiUrl ="";
        // apiUrl=  "https://api.artsy.net/api/genes/4d90d190dcdd5f44a5000032";
        apiUrl=  "https://api.artsy.net/api/genes/4de57c607804370001008c8b";


        if (test) {
            GetAllApiGenes.searchGeneById(xappToken, apiUrl);
        }
        else {
            GetAllApiGenes.searchAllGenes(xappToken);
        }
    }
}
