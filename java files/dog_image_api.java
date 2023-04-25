
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class dog_image_api {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://dog.ceo/api/breeds/image/random");
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            String json_string = json.toString();
            JSONObject jsonObject = new JSONObject(json_string);
            String fact = jsonObject.getString("message");
            System.out.println(fact);
        }
    }
}