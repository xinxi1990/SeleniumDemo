package TestCase;

import Base.BasicDriver;
import org.testng.annotations.AfterMethod;
import untils.Assertunits;
import untils.Fileunits;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Map;

public class TestCase_Lianjia_1  extends BasicDriver{

    private static Map fileYaml;
    private static Map caseYaml;
    private String url;


    /**
     * 初始化读取case的yaml文件
     * @return
     */
    @BeforeMethod
    @Override
    public void setup() {
        fileYaml = new Fileunits().getYaml("Testdata_Lianjia.yaml");
        caseYaml = (Map) fileYaml.get("TestCase1");
        super.setup();
        url  = (String) caseYaml.get("url");
        geturl(url,3);

    }

    @Test
    public void testcase(){

        webElement = basicDriver.displayWait(3,By.id((String) caseYaml.get("serach")));
        webElement.clear();
        webElement.sendKeys((CharSequence) caseYaml.get("sendkey"));
        webElement = basicDriver.displayWait(3,By.id((String) caseYaml.get("clickfind")));
        webElement.click();
        webElement = basicDriver.displayWait(3,new By.ByCssSelector((String) caseYaml.get("assertElement")));
        Assertunits.is_exist(webElement);
    }

    @AfterMethod
    @Override
    public void teardown() {
        super.teardown();
        System.out.println(String.format("关闭网站%s,并退出浏览器", url));

    }
}
