package g7.upskill.ips.clients;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.Artist;
import g7.upskill.ips.model.Artwork;
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

    public static Partner searchPartner( String apiUrl, String xappToken, int id_gallerist, int id_Coordinator) {

        Partner partner= new Partner();

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

                String jsonString = jsonObject.toString();

                partner = gson.fromJson(jsonString, Partner.class);

                partner.setRegion(MyDBUtils.cleanString(partner.getRegion()));
                partner.setName(MyDBUtils.cleanString(partner.getName()));
                partner.setWebsite(MyDBUtils.cleanString(partner.getWebsiteLink()));
                partner.setEmail(MyDBUtils.cleanString(partner.getEmail()));
                partner.setId_gallerist(id_gallerist);
                partner.setId_coordinator(id_Coordinator);

            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return partner;
    }



    public static void main(String[] args){


    }

}