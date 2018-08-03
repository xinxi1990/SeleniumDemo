package untils;


import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Assertunits {


    /**
     * 对查找元素断言封装,如果存在则成功
     * @param webElement 元素
     * @return
     */
    public static void is_exist(WebElement webElement) {

        if (webElement.isEnabled()){
            Assert.assertTrue(true);

        }
        else {
            Assert.assertFalse(true);
        }
    }


    /**
     * 对查找元素断言封装,如果不存在则成功
     * @param webElement 元素
     * @return
     */
    public static void not_exist(WebElement webElement) {

        if (webElement.isEnabled()){
            Assert.assertFalse(true);

        }
        else {
            Assert.assertTrue(true);
        }
    }

}
