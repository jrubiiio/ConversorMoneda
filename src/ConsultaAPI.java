import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Consulta API para la conversión
public class ConsultaAPI {
    public String buscaConversion(String monedaInicial, String monedaFinal, double cantidad) {
        try {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/66c3ced73afcb36412312064/pair/" +
                    monedaInicial + "/" + monedaFinal + "/" + cantidad);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            return jsonObject.get("conversion_result").getAsString();

        } catch (NumberFormatException | IOException | InterruptedException e) {
            System.out.println("Ha ocurrido un error: ");
            throw new RuntimeException("Error" + e.getMessage());
        }
    }
}