package org.example;

public class App {
    public static void main(String[] args)  {
        String linkToPicture = "";
        //---- 1
           HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
          linkToPicture = httpStatusChecker.getStatusImage(200,1);
        // linkToPicture = httpStatusChecker.getStatusImage(10000,1);
          System.out.println( linkToPicture);

        //---- 2
            HttpStatusImageDownloader downloadImage = new HttpStatusImageDownloader();
            linkToPicture = downloadImage.downloadStatusImage(205,1);
         // linkToPicture = downloadImage.downloadStatusImage(777,1);

        //----- 3
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus(2);

    }
}