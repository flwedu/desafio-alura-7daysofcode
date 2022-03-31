import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    public Properties getPropertiesFromFile(){
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {

            Properties props = new Properties();
            props.load(input);

            return props;

        } catch (IOException ex) {
            System.out.println("Error getting properties");
            ex.printStackTrace();
        }

        return null;
    }
}
