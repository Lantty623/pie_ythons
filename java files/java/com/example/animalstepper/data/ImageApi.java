package serptest_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.gson.JsonArray;
import serpapi.GoogleSearch;
import serpapi.SerpApiSearchException;

import com.google.gson.JsonObject;

public class ImageApi {

    public static String url;

    // returns url for an image of the animal passed in
    public static String get_url(String animal) throws SerpApiSearchException {
        Map<String, String> parameter = new HashMap<>();
        Random rand = new Random();
        String url;
        int url_start;
        int url_end;
        int upper_bound;

        parameter.put("q", animal);
        parameter.put("engine", "google_images");
        parameter.put("ijn", "0");
        parameter.put("api_key", "d624aad4c5d2e20ba9496e7cd20d38e0957664322c845f227cd388226b3c5802");

        // generate google search with parameters
        GoogleSearch search = new GoogleSearch(parameter);
        JsonObject response = search.getJson();
        // pull data for images from api response
        try {
            JsonObject knowledge_graph = response.get("knowledge_graph").getAsJsonObject();
            JsonArray images = knowledge_graph.get("header_images").getAsJsonArray();
            upper_bound = images.size();
            int pos = rand.nextInt(upper_bound);
            // pull data from a random image of those images
            String img_data = images.get(pos).toString();
            // parse url from image data
            url_start = img_data.indexOf("image") + 8;
            url_end = img_data.substring(url_start).indexOf('"');
            url = img_data.substring(url_start, url_end + url_start);
        }
        catch (Exception e){
            JsonArray images = response.get("inline_images").getAsJsonArray();
            upper_bound = images.size();
            int pos = rand.nextInt(upper_bound);
            String img_data = images.get(pos).toString();
            url_start = img_data.indexOf("thumbnail") + 12;
            url_end = img_data.substring(url_start).indexOf('"');
            url = img_data.substring(url_start, url_end + url_start);
        }
        return url;
    }

    public static String loadImageURL() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    url = get_url("dog");
                } catch (SerpApiSearchException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        t.join();
        return url;
    }
}
