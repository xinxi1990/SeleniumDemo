package TestCase;

import Base.BasicDriver;
import Datas.SetDataProvider;
import Model.HomePage;
import Model.LoginPage;
import org.testng.annotations.*;

/**
 * @author xinxi
 * @used po模式调用home、login
 * @testpoint 测试登录失败流程
 */

public class TestCase_Login extends BasicDriver {

    private String url;
    private HomePage homePage;
    private LoginPage loginPage;

    /**
     * 重写父类的setup方法
     * @return
     */
    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        url  = "http://testerhome.com/";
        geturl(url,3);
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        homePage.Cilck_HomeLogin();
    }

    /**
     * @testpoint 用户名错误,密码正常
     * @return
     */
    @Test(groups = "loginTest",dataProvider = "getLoginData_csv",dataProviderClass = SetDataProvider.class)
    public void test_loginfail(String username,String pwd) throws InterruptedException {
        System.out.println("data:"+ username + ":" + pwd);
        loginPage.DoLogin(username,pwd);

    }

    @AfterClass()
    @Override
    public void teardown() {
        super.teardown();
        System.out.println(String.format("关闭网站%s,并退出浏览器", url));

    }



}
