import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {

    private final HttpClient client;
    private final String api_key;

    public App(HttpClient client, String api_key){
        this.client = client;
        this.api_key = api_key;
    }

    public String getList(String url) throws IOException, InterruptedException {
        var response = this.makeRequestToUrl(url + this.api_key);
        return response.body();
    }

    private HttpResponse<String> makeRequestToUrl(String url) throws IOException, InterruptedException {

        System.out.println(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .headers("accept", "application/json")
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
