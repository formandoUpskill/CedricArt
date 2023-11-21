package g7.upskill.ips.clients;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.model.Gene;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetAllGenes {



    public static void searchAllGenes() {

        OkHttpClient client = new OkHttpClient();
        String apiUrl = "https://api.artsy.net/api/genes";

      String xappToken= LigacaoArtsy.generateXappToken();

        Gson gson = new GsonBuilder().create();

        System.out.println(apiUrl);

        System.out.println(apiUrl);
        Request request = new Request.Builder()
                .url(apiUrl)
                .header("X-XAPP-Token", xappToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // Processar a resposta aqui conforme necessário


                // Deserialize a list of genes
                Type listType = new TypeToken<ArrayList<Gene>>(){}.getType();
                List<Gene> all = gson.fromJson(response.body().string(), listType);
                for (Gene gene : all) {
                    System.out.println(gene);
                }

                System.out.println(response.body().string());
            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }





    }


    public static void main(String[] args){


        GetAllGenes.searchAllGenes();
    }
}