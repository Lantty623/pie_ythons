import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class cat_fact_api {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://catfact.ninja/fact");
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
            String fact = jsonObject.getString("fact");
            System.out.println(fact);
        }
    }
}