package g7.upskill.ips.clients;

import g7.upskill.ips.LigacaoArtsy;

public class GetAllApi {

    public static void main(String[] args) {
        boolean testMode= false;

        String xappToken= LigacaoArtsy.generateXappToken();

        GetAllApiGenes.searchAllGenes(xappToken, testMode);
    }
}
