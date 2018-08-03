package TestCase;

import Datas.data;
import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


/*
mvn -f pom.xml clean test  -DxmlFileName=testng.xml
 */


public class TestCase_1 {

    private  WebDriver driver;
    private  final  static String[] array = new  String[]{"java","python","ruby","go"};
    private static Logger logger = LogManager.getLogger(TestCase_1.class);


    @BeforeClass
    public void setup(){
//        driver = new FirefoxDriver();
//        System.setProperty("webdriver.firefox.marionette",gkpath);

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", data.chromedriverpath);
        //driver.get("http://testerhome.com");driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

    }

    //@Test(enabled = false)
    @Test
    public void testcase1(){
        driver.get("http://www.baidu.com");
        // 显示等待
        for (int i = 0; i < array.length; i++) {

            ((FirefoxDriver) driver).findElementById("kw").clear();
            ((FirefoxDriver) driver).findElementById("kw").sendKeys(array[i]);
            ((FirefoxDriver) driver).findElementById("su").click();
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

            if (driver.getPageSource().contains("下一页")){
                Assert.assertTrue(true);
            }

            int count = 0;
            while (true){
                driver.navigate().back();
                count=count+1;
                System.out.println("循环退出计数" + count);
                if (driver.getPageSource().contains("hao123")){
                    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
                    break;
                }
            }
        }

    }

    @Test
    public  void testcase2(){
        driver.get("http://testerhome.com");
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        if (driver.getPageSource().contains("登录")){

            System.out.print("未登录!");
        }

//        By logby = By.id("carousel-head");
//        driver.findElement(logby).click();

        int loop = 3;

        while (loop >0) {
            ((ChromeDriver) driver).findElementByXPath("//*[@id=\"carousel-head\"]/div/div/a/img").click();
            driver.navigate().back();
           loop-=1;
        }
    }


    @Test
    public void logintest() throws InterruptedException {

        if ( driver.getPageSource().contains("登录")){
            System.out.println("未登录,进行登录操作!");
            if (driver.getPageSource().contains("退出成功。")){
                System.out.println("退出成功!");
            }
        }
        else {
            System.out.println("已登录,先退出登录!");
            ((ChromeDriver) driver).findElementByXPath("/html/body/div[1]/nav/div/ul[1]/li/a").click();
            ((ChromeDriver) driver).findElementByXPath("/html/body/div[1]/nav/div/ul[1]/li/ul/li[7]/a").click();
        }


        ((ChromeDriver) driver).findElementByXPath("//a[contains(text(),'登录')]").click();
        WebElement userelement = ((ChromeDriver) driver).findElementById("user_login");
        userelement.clear();
        userelement.sendKeys(data.username);

        WebElement pwdelement = ((ChromeDriver) driver).findElementById("user_password");
        pwdelement.clear();
        pwdelement.sendKeys(data.pwd);

        //((ChromeDriver) driver).findElementByXPath("//*[@id=\"new_user\"]/div[4]/input").click();
        driver.findElement(By.name("commit")).click();

        System.out.println("点击登录按钮");

        if ( driver.getPageSource().contains("64.png")){
            System.out.println("登录成功!");
        }else {
            System.out.println("登录失败!");
        }

        logintest();

    }

    @Test
    public void gettext() {
       WebElement element =  ((ChromeDriver) driver).findElementByXPath("//a[contains(text(),'登录')]");
       System.out.println(element.getAttribute("href"));
       System.out.println(element.getText());
       System.out.println(element.getLocation().x + ',' + element.getLocation().y);
       System.out.println(element.getSize());
       System.out.println(element.getTagName());

    }

    @Test
    public void logotest() throws InterruptedException {
        driver.get("http://testerhome.com");
        System.out.println(data.username);
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement webElement =  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("登录")));
        System.out.println(webElement);
        webElement.click();

        java.lang.Thread.sleep(3000);

//        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//        driver.findElement(By.className("carousel-inner")).click();
//        driver.findElement(By.linkText("往届嘉宾")).click();

    }


    @AfterClass
    public void teardown()
    {
        driver.quit();
        //driver.close();
        System.out.println("end test");
    }





}
