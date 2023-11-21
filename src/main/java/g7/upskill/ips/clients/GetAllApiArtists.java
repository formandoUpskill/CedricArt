package g7.upskill.ips.clients;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.model.Artist;
import g7.upskill.ips.model.Gene;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetAllApiArtists {

    public static void searchAllArtist() {
        OkHttpClient client = new OkHttpClient();
        String apiUrl = "https://api.artsy.net/api/artists?artworks=true&size=3500&page=1";
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
                String responseBody = response.body().string();
                JsonParser parser = new JsonParser();
                JsonObject jsonObject = (JsonObject)parser.parse(responseBody);
                JsonArray data = jsonObject.getAsJsonObject("_embedded").getAsJsonArray("artists");
                // Deserialize a list of genes
                List<Artist>  artists = new ArrayList<>();
                Type listType = new TypeToken<ArrayList<Artist>>(){}.getType();
                artists = gson.fromJson(data, listType);
                System.out.println(artists.size());

                for (Artist artist : artists) {
                    System.out.println(artist.getName());
                }

            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        GetAllApiArtists.searchAllArtist();
    }
}