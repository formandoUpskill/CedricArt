package g7.upskill.ips.clients;

import g7.upskill.ips.LigacaoArtsy;

public class GetAllApi {

    public static void main(String[] args) {


        boolean test= true;

        String xappToken= LigacaoArtsy.generateXappToken();
       // String apiUrl ="";

//        String apiUrl1 = "https://api.artsy.net/api/genes/4de57c607804370001008c8b";
        String apiUrl2 = "https://api.artsy.net/api/genes/4d90d190dcdd5f44a5000032";
//        String apiUrl3 = "https://api.artsy.net/api/genes/51b662c48b3b8190570001e6";
//        String apiUrl4 = "https://api.artsy.net/api/genes/51b662a48b3b816b5c00034f";
//        String apiUrl5 = "https://api.artsy.net/api/genes/51b662978b3b81ec27000285";



        if (test) {
         //   GetAllApiGenes.searchGeneById(xappToken, apiUrl1);
            GetAllApiGenes.searchGeneById(xappToken, apiUrl2);
//            GetAllApiGenes.searchGeneById(xappToken, apiUrl3);
//            GetAllApiGenes.searchGeneById(xappToken, apiUrl4);
//            GetAllApiGenes.searchGeneById(xappToken, apiUrl5);
        }
        else {
            GetAllApiGenes.searchAllGenes(xappToken);
        }
    }
}
