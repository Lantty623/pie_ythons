import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class shibe_image_api {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://shibe.online/api/shibes?count=[1]");
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            String json_string = json.toString();
            String temp = url_finder(json_string);
            temp = remove_quotes(temp);
            System.out.println(temp);
        }
    }

    static String url_finder(String url) {
        String string = null;
        string = url;
        Pattern pattern = Pattern.compile("(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)"
        );
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            string = matcher.group(0);

            return string;
        }
        return string;
    }

    static String remove_quotes(String url) {
        String temp = url;
        char remove = '"';
        temp = temp.replace(String.valueOf(remove), "");
        return temp;
    }
}