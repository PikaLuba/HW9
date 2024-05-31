package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus(int priznakException) {

        Scanner sc = new Scanner(System.in);
        int code = -1;
        while (code < 0) {

            System.out.println("Enter HTTP status code: ");
            String x = sc.nextLine();
            try {
                code = Integer.parseInt(x);

                HttpStatusImageDownloader downloadImage = new HttpStatusImageDownloader();
                String linkToPicture = downloadImage.downloadStatusImage(code, priznakException);

                if (linkToPicture.equals("***")) {
                    System.out.println("There is not image for HTTP status " + code);
                    code = -1;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number");
            }

        }

    }
}
