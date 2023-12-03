package g7.upskill.ips.clients;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import g7.upskill.ips.LigacaoArtsy;
import g7.upskill.ips.MyDBUtils;
import g7.upskill.ips.model.Artist;
import g7.upskill.ips.model.Artwork;
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



   public static String getAllGenes(String apiUrl,String xappToken, List<Gene> geneList)
   {
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
               }
               catch(NullPointerException ex)
               {
                   apiUrl="";
               }

               JsonArray data = jsonObject.getAsJsonObject("_embedded").getAsJsonArray("genes");
               // Deserialize a list of genes
               List<Gene>  genes= new ArrayList<>();
               Type listType = new TypeToken<ArrayList<Gene>>(){}.getType();
               genes = gson.fromJson(data, listType);
               System.out.println(genes.size());

               for (Gene gene : genes) {

                   gene.setDescription(MyDBUtils.cleanString(gene.getDescription()));
                   gene.setName(MyDBUtils.cleanString(gene.getName()));

                   geneList.add(gene);

               }



           } else {
               System.out.println("Falha na solicitação à API. Código de resposta: " + response.code());
           }
       } catch (IOException e) {
           e.printStackTrace();
       }

       return apiUrl;

   }



    public static void main(String[] args) {

    }
}
