package g7.upskill.ips.clients;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.adapters.LocalDateAdapter;
import g7.upskill.ips.model.Exhibition;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetAllApiExhibition {

    public static String searchAllExhibitions( String apiUrl,String xappToken, List exhibitionList) {



        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter()).setPrettyPrinting().create();

        System.out.println(apiUrl);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiUrl)
                .header("X-XAPP-Token", xappToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // Processar a resposta aqui conforme necessário
                String responseBody = response.body().string();
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = (JsonObject) parser.parse(responseBody);

                // int totalCount = jsonObject.get("total_count").getAsInt();

                try {
                    apiUrl = jsonObject.getAsJsonObject("_links").getAsJsonObject("next").get("href").getAsString();
                } catch (NullPointerException ex) {
                    apiUrl = "";
                }

                JsonArray data = jsonObject.getAsJsonObject("_embedded").getAsJsonArray("shows");
                // Deserialize a list of exhibitions
                List<Exhibition> exhibitions = new ArrayList<>();
                Type listType = new TypeToken<ArrayList<Exhibition>>() {
                }.getType();
                exhibitions = gson.fromJson(data, listType);
                System.out.println(exhibitions.size());

                for (Exhibition exhibition : exhibitions) {

                    exhibition.setThumbnail(MyDBUtils.cleanString(exhibition.getThumbnail()));
                    exhibition.setDescription(MyDBUtils.cleanString(exhibition.getDescription()));
                    exhibition.setName(MyDBUtils.cleanString(exhibition.getName()));
                    exhibition.setUrl(MyDBUtils.cleanString(exhibition.getUrl()));

                    exhibitionList.add(exhibition);

                }

            }else {
                    System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return apiUrl;
        }

    public static void main(String[] args){

        boolean testMode= true;

        String xappToken= LigacaoArtsy.generateXappToken();
       // GetAllApiExhibition.searchAllExhibitions(xappToken,"https://api.artsy.net/api/shows?partner_id=51cc9a88275b24f8700000db","51cc9a88275b24f8700000db");


    }
}
