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


public class TestCase_UPLoad extends BasicDriver {

    /**
     * 初始化读取case的yaml文件
     * @return
     */
    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        geturl("https://music.163.com/",3);

    }


    /**
     * 测试上传文件
     * @return
     */

    @Test
    public void test_upload(){
        basicDriver.displayWait(3,new By.ByCssSelector("#auto-id-hPthdkhpMAg5P6Uu > div.head.f-fl.f-pr > img")).click();
        basicDriver.displayWait(3,new By.ByXPath("//*[@id=\"auto-id-hPthdkhpMAg5P6Uu\"]/div[2]/ul[1]/li[1]/a/em")).click();



    }
}
