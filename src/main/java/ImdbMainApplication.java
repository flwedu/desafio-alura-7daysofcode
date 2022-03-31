import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Properties;

public class ImdbMainApplication {

    public static void main(String[] args){

        Properties props = new PropertyLoader().getPropertiesFromFile();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        var app = new App(client, props.getProperty("API_KEY"));
        try {
            System.out.println(app.getList("https://imdb-api.com/en/API/Top250Movies/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
