package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasicDriver {

    public WebDriver driver;
    public BasicDriver basicDriver;
    public WebDriver webDriver;
    public WebElement webElement;


    public WebDriver CreatDriver(String DriverType,String Runtype){

        if (DriverType.equals("chrome")){
            if (Runtype.equals("handless")){
                ChromeOptions chromeOptions  = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                System.out.println("获取chrome的driver");
            }else {
                driver = new ChromeDriver();
            }

        }else if (DriverType.equals("firefox")){

            if (Runtype.equals("handless")){
                FirefoxOptions firefoxOptions  = new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                driver = new FirefoxDriver(firefoxOptions);
            }else {
                driver = new FirefoxDriver();
            }

        }else if (DriverType.equals("safair")){
            driver = new SafariDriver();
        }

        return driver;
    }

    /**
     * 封装初始化setup方式,其他case需要继承
     */
    @BeforeClass
    public void setup(){
        basicDriver = new BasicDriver();
        webDriver =  basicDriver.CreatDriver("chrome","no handless");
    }


    @AfterClass()
    public void teardown()
    {
        webDriver.quit();
    }


    /**
     * 打开url并且等待waitTime
     * 隐示等待全局
     */
    public void geturl(String url,int waitTime){
        webDriver.get(url);
        System.out.println(String.format("打开网站:%s", url));
        webDriver.manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS);
    }



    /**
     * 封装显示等待
     * @param waitTime
     * @param by
     * @return
     */

    public WebElement displayWait(int waitTime, By by){
        WebElement wb = null;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver,waitTime);
            wb =  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((by)));
            System.out.println(String.format("点击%s元素:等待%s秒",by,waitTime));
        }catch (Exception e){
            System.out.println(String.format("displayWait has error! + \n + %s", e));
        }
        return wb;
    }

    /**
     * 截图操作
     * @return
     */
     public void screenshot(WebDriver webDriver) throws IOException {
         File srcFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
         //利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件对象。
         FileUtils.copyFile(srcFile, new File("screenshot.png"));

     }



}
