package TestCase;


import Base.BasicDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import untils.Fileunits;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JSTest {


    BasicDriver basicDriver;
    WebDriver webDriver;
    WebElement webElement;
    Map testcase_map1;
    Map testcase_map2;
    String URL;


    @BeforeClass
    public void setup(){

        testcase_map1 =  new Fileunits().getYaml("Testdata_Case.yaml");
        testcase_map2 =  new Fileunits().getYaml("Testdata_Case.yaml");

        basicDriver = new BasicDriver();
        webDriver =  basicDriver.CreatDriver("chrome","no handless");
        URL = (String) testcase_map1.get("url");
        webDriver.get(URL);
        System.out.println(String.format("打开网站:%s", URL));
        webDriver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }


    @Test
    public void  test() throws IOException {

        String jsStr = "window.scrollTo(100,450);";
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(jsStr);
        basicDriver.screenshot(webDriver);
    }


}
