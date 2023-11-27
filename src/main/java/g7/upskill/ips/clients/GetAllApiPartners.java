package g7.upskill.ips.clients;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.Artist;
import g7.upskill.ips.model.Partner;
import g7.upskill.ips.persistence.DBStorage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetAllApiPartners {

    public static void searchAllPartners(String xappToken, String apiUrl, int id_gallerist, int id_Coordinator) {

        if (apiUrl.isBlank())
        {
            apiUrl = "https://api.artsy.net/api/partners";
        }
        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
              //  JsonArray data = jsonObject.getAsJsonObject("_embedded").getAsJsonArray("partners");
                Object data = jsonObject.getAsJsonObject();
                System.out.println("data " + data);
                // Deserialize a list of genes
                List<Partner> partners = new ArrayList<>();
                Type listType = new TypeToken<ArrayList<Artist>>(){}.getType();
                partners = gson.fromJson(data, listType);

                for (Partner partner : partners) {

                    partner.setRegion(MyDBUtils.cleanString(partner.getRegion()));
                    partner.setName(MyDBUtils.cleanString(partner.getName()));
                    partner.setWebsite(MyDBUtils.cleanString(partner.getWebsite()));
                    partner.setUrl(MyDBUtils.cleanString(partner.getUrl()));
                    partner.setId_gallerist(id_gallerist);
                    partner.setId_coordinator(id_Coordinator);

                    storage.createPartner(partner);


                }

            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args){

        String xappToken= LigacaoArtsy.generateXappToken();
        GetAllApiPartners.searchAllPartners(xappToken,"https://api.artsy.net/api/partners/51cc9a88275b24f8700000db",1,2);


    }

}