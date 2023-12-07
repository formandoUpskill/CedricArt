package g7.upskill.ips.clients;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.adapters.LocalDateAdapter;
import g7.upskill.ips.model.Artist;
import g7.upskill.ips.model.Artwork;
import g7.upskill.ips.model.Gene;
import g7.upskill.ips.persistence.DBStorage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetAllApiArtwork {



    public static String getAllArtworksOfAnArtist(String apiUrl,String xappToken, List<Artwork> artworkList)
    {

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


                try {
                    apiUrl = jsonObject.getAsJsonObject("_links").getAsJsonObject("next").get("href").getAsString();
                }
                catch(NullPointerException ex)
                {
                    apiUrl="";
                }

                JsonArray data = jsonObject.getAsJsonObject("_embedded").getAsJsonArray("artworks");


                // Deserialize a list of genes
                List<Artwork>  artworks = new ArrayList<>();
                Type listType = new TypeToken<ArrayList<Artwork>>(){}.getType();
                artworks = gson.fromJson(data, listType);


                for (Artwork artwork : artworks) {

                    artwork.setTitle(MyDBUtils.cleanString(artwork.getTitle()));
                    artwork.setThumbnail(MyDBUtils.cleanString(artwork.getThumbnail()));
                    artwork.setUrl(MyDBUtils.cleanString(artwork.getUrl()));
                    artwork.setDate(MyDBUtils.cleanString(artwork.getDate()));

                    artworkList.add(artwork);
                }

            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apiUrl;
    }




    public static String getAllArtworksOfAnShow(String apiUrl,String xappToken, List<Artwork> artworkList)
    {

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


                try {
                    apiUrl = jsonObject.getAsJsonObject("_links").getAsJsonObject("next").get("href").getAsString();
                }
                catch(NullPointerException ex)
                {
                    apiUrl="";
                }

                JsonArray data = jsonObject.getAsJsonObject("_embedded").getAsJsonArray("artworks");


                // Deserialize a list of genes
                List<Artwork>  artworks = new ArrayList<>();
                Type listType = new TypeToken<ArrayList<Artwork>>(){}.getType();
                artworks = gson.fromJson(data, listType);


                for (Artwork artwork : artworks) {

                    artwork.setTitle(MyDBUtils.cleanString(artwork.getTitle()));
                    artwork.setThumbnail(MyDBUtils.cleanString(artwork.getThumbnail()));
                    artwork.setUrl(MyDBUtils.cleanString(artwork.getUrl()));
                    artwork.setDate(MyDBUtils.cleanString(artwork.getDate()));

                    artworkList.add(artwork);
                }

            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apiUrl;
    }
    public static void main(String[] args){

        //     GetAllApiArtwork.searchAllArtworks();
    }


}
