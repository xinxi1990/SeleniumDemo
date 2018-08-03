package Datas;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;

public class data {

    public static String username = "*****";
    public static String pwd = "****";
    private static Logger logger = LogManager.getLogger(data.class);
    public static String gkpath = System.getProperty("user.dir") + "/drivers/geckodriver";
    public static String chromedriverpath =  System.getProperty("user.dir") + "/drivers/chromedriver";

    public static void main(String[] args) {

        System.out.println(gkpath);
        System.out.println(chromedriverpath);

        File file = new File("drivers/geckodriver");
        System.out.println(file.getAbsolutePath());


    }

}
