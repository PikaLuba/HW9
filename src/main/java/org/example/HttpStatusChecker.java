package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;

public class HttpStatusChecker {

    String getStatusImage(int code, int priznakException) {

        String path = Integer. toString(code) + ".jpg";
        String result = "";
        try {

            URI uri = new URI("https", "http.cat", "/" + path, null);
            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == 404) {
                if (priznakException == 1) {
                    BufferedImage image1 = ImageIO.read(connection.getInputStream());
                }
            } else {
               result = "https://http.cat/" + path;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

