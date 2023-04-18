package com.example.animalstepper.data;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatAPI {

    public static String url;
    public static String getJSON() throws Exception {
        URL url = new URL("https://api.thecatapi.com/v1/images/search?api_key=live_F2uLi8Qt4G2zvVMYiAyUj8cHfqo82Y14mTSeL27qDZy2fu3lU4eyyTrLmS82ukPB");
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
            return temp;
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

    public static String loadImageURL() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    url = getJSON();
                }
                catch (Exception e){
                    System.out.println("\n\n\n getJSON() error = " + e +"\n\n\n");
                }
            }
        });

        t.start();
        t.join();

        return url;
    }
}