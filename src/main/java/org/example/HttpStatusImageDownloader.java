package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;

public class HttpStatusImageDownloader {
    String downloadStatusImage(int code, int priznakException) {

        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String linkToPicture = httpStatusChecker.getStatusImage(code, priznakException);

        if (linkToPicture != "") {
            try {
                System.out.println( linkToPicture);

                URLConnection openConnection = new URL(linkToPicture).openConnection();
                openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");

                BufferedImage image1 = ImageIO.read(openConnection.getInputStream());
                File file = new File("./tmp/cat" + Integer.toString(code) + ".jpg");
                ImageIO.write(image1, "jpg", file);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return linkToPicture;
    }
}