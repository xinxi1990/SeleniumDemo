package TestCase;

import Base.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import untils.Fileunits;
import untils.Acionuntils;

import java.util.Map;


public class TestCase_SwitchCase extends BasicDriver {

    private static Map File;
    private static Map Case;
    private String url;
    private Acionuntils acionuntils;
    private WebElement webElement;

    /**
     * 初始化读取case的yaml文件
     * @return
     */
    @BeforeMethod
    @Override
    public void setup() {
        File = new Fileunits().getYaml("Testdata_Lianjia.yaml");
        acionuntils = new Acionuntils(webDriver);

        Case = (Map) File.get("TestCase1");
        super.setup();
        url  = (String) Case.get("url");
        geturl(url,3);
        webDriver.manage().window().maximize();


    }


    /**
     * 测试切换窗口
     * @return
     */
    @Test
    public void test_switchWindows(){

        String jsstr = "arguments[0].scrollIntoView(true)";
        ((JavascriptExecutor)webDriver).executeScript(jsstr,webDriver.findElement(By.cssSelector("body > div.hand-lianjia > div > div.fl > div.download > div.hand-app > a.ios")));
        //滑动到某个元素

//      String jsStr = "window.scrollTo(100,450);";
//      JavascriptExecutor js = (JavascriptExecutor) webDriver;
//      js.executeScript(jsStr);
        //向下滑动

        String handel1 = webDriver.getWindowHandle();
        for(WebElement e: webDriver.findElements(By.cssSelector(".home-nav a"))){
            if(e.findElement(By.tagName("b")).getText().equals("找二手房")){
                e.click();
                break;
            }
        }
        for(String handel2:webDriver.getWindowHandles()){
            if(!handel2.equals(handel1)){
                webDriver.switchTo().window(handel2);
                break;
            }
        }
        //切换handel

        basicDriver.displayWait(3,new By.ByCssSelector("#searchForm > div > button > i")).click();
        System.out.println("点击搜索");

    }


    /**
     * 获取返回值
     * @return
     */
    @Test
    public void testReturnValue(){
        String js = "return arguments[0].textContent;";
        Object name = ((JavascriptExecutor)webDriver).executeScript(js,webDriver.findElement(By.cssSelector("body > div.header > div > div.fl > a")));
        System.out.println((((JavascriptExecutor)webDriver).executeScript(" return document.documentElement.scrollTop")));
        System.out.println((((JavascriptExecutor)webDriver).executeScript(" return window.innerWidth")));
        System.out.println((((JavascriptExecutor)webDriver).executeScript(" return document.documentElement.scrollTop")));
    }

    /**
     * 获取设置属性
     * @return
     */
    @Test
    public void testSetAttribute() {
        String js = "arguments[0].setAttribute('style',arguments[1])";
        ((JavascriptExecutor)webDriver).executeScript(js,webDriver.findElement(By.cssSelector("body > div.header > div > div.fl > a")),"background:yellow;border:2 px solid red");
    }



    @AfterMethod(enabled = false)
    @Override
    public void teardown() {
        super.teardown();
        System.out.println(String.format("关闭网站%s,并退出浏览器", url));

    }



}
