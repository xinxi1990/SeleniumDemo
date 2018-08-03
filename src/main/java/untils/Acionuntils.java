package untils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Acionuntils  {

    private WebDriver webDriver;
    private WebElement webElement;

    public Acionuntils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * 滑动到某个元素
     * @param webElement元素
     * @param webDriver
     */
    public void scrollToElement(WebElement webElement) {
        System.out.println(webElement.toString());
        JavascriptExecutor js = (JavascriptExecutor)this.webDriver;
        // roll down and keep the element to the center of browser
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }


}
