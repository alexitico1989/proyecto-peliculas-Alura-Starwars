import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import com.google.gson.Gson;

public class ConsultarPelicula {

    public Film buscarPelicula(int numeroDePelicula) {
        URI direccion = URI.create("https://swapi.dev/api/films/" + numeroDePelicula + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Film.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No encontré esa película.");
        }
    }
}