package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import untils.Assertunits;


public class LoginPage {

    @FindBy(css = "#user_login")
    public WebElement UserLogin;

    @FindBy(xpath = "//*[@id='user_password']")
    public WebElement UserPassword;

    @FindBy(css = "#new_user > div.form-actions > input")
    public WebElement ClickLogin;

    /**
     * 初始化页面
     * 用于页面构造器
     * @return
     */

    public LoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);

    }


    /**
     * 登录方法,可参数化
     * @return
     */
    public void DoLogin(String username,String pwd) throws InterruptedException {
        System.out.println("DoLogin:"+ username + ","+ pwd);

        if ( ! String.valueOf(username).equals("None")){
            UserLogin.click();
            UserLogin.clear();
            UserLogin.sendKeys(username);
            Thread.sleep(1000);
        }
        else {
            System.out.println("username为空");
        }

        if ( ! String.valueOf(pwd).equals("None")){
            UserPassword.click();
            UserPassword.clear();
            UserPassword.sendKeys(pwd);
            Thread.sleep(1000);
        }else {
            System.out.println("pwd为空");
        }

        ClickLogin.click();
        Thread.sleep(1000);
        Assertunits.is_exist(ClickLogin);


    }
}
