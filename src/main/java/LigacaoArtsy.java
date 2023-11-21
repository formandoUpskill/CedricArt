import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;
import java.io.IOException;

public class LigacaoArtsy {
    public static void main(String[] args) {
        LigacaoArtsy pesquisa = new LigacaoArtsy();
        pesquisa.searchArtistsByLetter("B");
    }

    private OkHttpClient client;
    private String xappToken;

    public LigacaoArtsy() {
        this.client = new OkHttpClient();
        this.xappToken = generateXappToken();
    }

    private String generateXappToken() {
        String clientId = "9f14b9f06093d764ddf7";
        String clientSecret = "a8f0f836b1832d14bdc0e3e4c75559c4";
        String tokenUrl = "https://api.artsy.net/api/tokens/xapp_token";

        RequestBody formBody = new FormBody.Builder()
                .add("client_id", clientId)
                .add("client_secret", clientSecret)
                .build();

        Request request = new Request.Builder()
                .url(tokenUrl)
                .post(formBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                JsonObject jsonResponse = new Gson().fromJson(response.body().string(), JsonObject.class);
                return jsonResponse.get("token").getAsString();
            } else {
                throw new IOException("Failed to generate Xapp token. Code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void searchArtistsByLetter(String letter) {

        String apiUrl = "https://api.artsy.net/api/search?q=" + letter + "&type=artist";
        System.out.println(apiUrl);
        Request request = new Request.Builder()
                .url(apiUrl)
                .header("X-XAPP-Token", xappToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                // Processar a resposta aqui conforme necessário
                System.out.println(response.body().string());
            } else {
                System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}