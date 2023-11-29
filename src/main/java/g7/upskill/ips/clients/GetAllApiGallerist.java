package g7.upskill.ips.clients;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.Gallerist;
import g7.upskill.ips.model.Gene;
import g7.upskill.ips.persistence.DBStorage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetAllApiGallerist {

    public static void searchAllGallerists() {
        OkHttpClient client = new OkHttpClient();
        String apiUrl = "https://api.artsy.net/api/gallerists?size=10";
        String xappToken= LigacaoArtsy.generateXappToken();
        Gson gson = new GsonBuilder().create();
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
                JsonArray data = jsonObject.getAsJsonObject("_embedded").getAsJsonArray("gallerist");
                // Deserialize a list of gallerists
                List<Gallerist>  gallerists = new ArrayList<>();
                Type listType = new TypeToken<ArrayList<Gallerist>>(){}.getType();
                gallerists = gson.fromJson(data, listType);
                System.out.println(gallerists.size());

                for (Gallerist gallerist : gallerists) {

                    storage.createGallerist(gallerist);

                }

            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        GetAllApiGallerist.searchAllGallerists();
    }
}
