package TestCase;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class HeadlessDemo {

//    public static void main(String[] args) throws IOException {
//        ChromeOptions chromeOptions  = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        WebDriver webDriver = new ChromeDriver(chromeOptions);
//        webDriver.get("https://testerhome.com");
//        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//
//        //String webElement = webDriver.getPageSource();
//        //System.out.println(webElement);
//
//        System.out.println("this is one");
//
//        webDriver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
//        String webElement1 = webDriver.getPageSource();
//        System.out.println(webElement1);
//        File srcFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(srcFile, new File("screenshot.png"));
//        System.out.println("this is two");
//
//
 //   }


//    public static void main(String[] args) throws IOException {
//        FirefoxOptions firefoxOptions  = new FirefoxOptions();
//        firefoxOptions.setHeadless(true);
//        WebDriver webDriver = new FirefoxDriver(firefoxOptions);
//        webDriver.get("https://testerhome.com");
//        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//
//        //String webElement = webDriver.getPageSource();
//        //System.out.println(webElement);
//
//        System.out.println("this is one");
//
//        webDriver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
//        String webElement1 = webDriver.getPageSource();
//        System.out.println(webElement1);
//        File srcFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(srcFile, new File("screenshot.png"));
//        System.out.println("this is two");
//
//
// //Runtime.getRuntime().exec("/usr/bin/safaridriver --enable");
// }


    public static void main(String[] args) throws IOException {
        //Runtime.getRuntime().exec("su");
        //Runtime.getRuntime().exec("/usr/bin/safaridriver --enable");

        SafariOptions safariOptions  = new SafariOptions();
        WebDriver driver = new SafariDriver(safariOptions);
        driver.get("https://testerhome.com");
        driver.quit();

    }

    }



