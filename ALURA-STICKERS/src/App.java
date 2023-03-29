import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        /*System.out.println("Hello, World!");*/

        // fazer uma conexão http e buscar os 250 filmes tops

            //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
            URI endereco = URI.create(url); 
            var client = HttpClient.newHttpClient();
            var request =  HttpRequest.newBuilder(endereco).GET().build();  
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            //System.out.println(body);

        // extrair só os dados que interessam - título - poster(imagem) - classificação            
            
            var parse = new JsonParser();
            List<Map<String, String>> listadefilme = parse.parse(body);


        //exibir e manipular os dados

        for (int i = 0; i <3; i = i + 1) {
            Map<String,String> filme = listadefilme.get(i); 
                System.out.println(filme.get("title"));
                System.out.println(filme.get("image"));
                System.out.println(filme.get("imDbRating"));
            
        }
        

    }
}
