package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(partialLinkText = "登录")
    public WebElement HomeLogin;


    /**
     * 初始化页面
     * 用于页面构造器
     * @return
     */
    public HomePage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);

    }

    /**
    点击首页登录
     */
    public void Cilck_HomeLogin(){
        HomeLogin.click();
    }

}
