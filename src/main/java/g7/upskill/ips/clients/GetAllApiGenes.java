package g7.upskill.ips.clients;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.Gene;
import g7.upskill.ips.model.Partner;
import g7.upskill.ips.persistence.DBStorage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetAllApiGenes {

    public static void searchAllGenes(String xappToken, int size) {


        String apiUrl = "https://api.artsy.net/api/genes?size=" + size;

        OkHttpClient client = new OkHttpClient();

        String idGene="";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(apiUrl);
        System.out.println(apiUrl);
        Request request = new Request.Builder()
                .url(apiUrl)
                .header("X-XAPP-Token", xappToken)
                .build();


        DBStorage storage = new DBStorage();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // Processar a resposta aqui conforme necessário
                String responseBody = response.body().string();
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = (JsonObject)parser.parse(responseBody);
                JsonArray data = jsonObject.getAsJsonObject("_embedded").getAsJsonArray("genes");
                // Deserialize a list of genes
                List<Gene>  genes= new ArrayList<>();
                Type listType = new TypeToken<ArrayList<Gene>>(){}.getType();
                genes = gson.fromJson(data, listType);
                System.out.println(genes.size());

                for (Gene gene : genes) {

                    gene.setDescription(MyDBUtils.cleanString(gene.getDescription()));
                    gene.setName(MyDBUtils.cleanString(gene.getName()));


                    storage.createGene(gene);

                    idGene= gene.getId();

                    GetAllApiArtists.searchAllArtist (xappToken, gene.getArtistsLink(),10);

                    GetAllApiArtwork.searchAllArtworks(xappToken, gene.getArtworksLink(),idGene,10);

                }

            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void searchGeneById(String xappToken, String apiUrl) {


        if (apiUrl.isBlank())
        {
            apiUrl = "https://api.artsy.net/api/genes?size=10";
        }

        OkHttpClient client = new OkHttpClient();

        String idGene="";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(apiUrl);
        System.out.println(apiUrl);
        Request request = new Request.Builder()
                .url(apiUrl)
                .header("X-XAPP-Token", xappToken)
                .build();


        DBStorage storage = new DBStorage();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // Processar a resposta aqui conforme necessário
                String responseBody = response.body().string();
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = (JsonObject)parser.parse(responseBody);

                String jsonString = jsonObject.toString();

                Gene gene = gson.fromJson(jsonString, Gene.class);
                // Deserialize a list of genes


                gene.setDescription(MyDBUtils.cleanString(gene.getDescription()));
                gene.setName(MyDBUtils.cleanString(gene.getName()));

                storage.createGene(gene);
                idGene= gene.getId();

                GetAllApiArtists.searchAllArtist (xappToken, gene.getArtistsLink(),20);

                GetAllApiArtwork.searchAllArtworks(xappToken, gene.getArtworksLink(),idGene,30);



            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {

    }
}
