package TestCase;

import Base.BasicDriver;
import org.openqa.selenium.By;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.*;
import untils.Assertunits;
import untils.Fileunits;
import org.testng.annotations.Test;


public class TestCase_2 extends BasicDriver {

    private static Map FileYaml;
    private static Map CaseYaml;
    private String url;

    /**
     * 初始化读取case的yaml文件
     * @return
     */
    @BeforeMethod
    @Override
    public void setup() {
        FileYaml = new Fileunits().getYaml("Testdata_Case.yaml");
        CaseYaml = (Map) FileYaml.get("TestCase1");
        super.setup();
        url  = (String) CaseYaml.get("url");
        geturl(url,3);
    }


    /**
     * 用css元素定位测试登录功能
     * @return
     */
    @Test
    public void test_login_css(){
        CaseYaml = (Map) FileYaml.get("TestCase2_css");
        if (webDriver.getPageSource().contains("登录")){
            System.out.println(String.format("打开网站:%s成功!", url));
            Assert.assertTrue(true);
        }

        basicDriver.displayWait(3,new By.ByCssSelector((String) CaseYaml.get("click_login"))).click();

        webElement = basicDriver.displayWait(3,new By.ByCssSelector((String) CaseYaml.get("click_username")));
        webElement.clear();
        webElement.sendKeys(CaseYaml.get("username").toString());
        webElement = basicDriver.displayWait(3,new By.ByCssSelector((String) CaseYaml.get("click_password")));
        webElement.clear();
        webElement.sendKeys(CaseYaml.get("password").toString());
        basicDriver.displayWait(3,new By.ByCssSelector((String) CaseYaml.get("click_loginbutton"))).click();
        webElement = basicDriver.displayWait(3,new By.ByCssSelector((String) CaseYaml.get("assertlogin")));
        Assertunits.is_exist(webElement);
    }


    @Test
    public void test_login_xpath(){
        CaseYaml = (Map) FileYaml.get("TestCase3_xpath");
        if (webDriver.getPageSource().contains("登录")){
            System.out.println(String.format("打开网站:%s成功!", url));
            Assert.assertTrue(true);
        }

        basicDriver.displayWait(3,new By.ByXPath((String) CaseYaml.get("click_login"))).click();

        webElement = basicDriver.displayWait(3,new By.ByXPath((String) CaseYaml.get("click_username")));
        webElement.clear();
        webElement.sendKeys(CaseYaml.get("username").toString());
        webElement = basicDriver.displayWait(3,new By.ByXPath((String) CaseYaml.get("click_password")));
        webElement.clear();
        webElement.sendKeys(CaseYaml.get("password").toString());
        basicDriver.displayWait(3,new By.ByXPath((String) CaseYaml.get("click_loginbutton"))).click();
        System.out.println(CaseYaml.get("assertlogin"));
        webElement = basicDriver.displayWait(5,new By.ByXPath((String) CaseYaml.get("assertlogin")));
        Assertunits.is_exist(webElement);


    }



    @AfterMethod
    @Override
    public void teardown() {
        super.teardown();
        System.out.println(String.format("关闭网站%s,并退出浏览器", url));

    }



}
