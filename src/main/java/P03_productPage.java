import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class P03_productPage {
    SHAFT.GUI.WebDriver driver;

    public P03_productPage (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    By productCard = By.xpath("//div[@class='productinfo text-center']");
    By continueButton = By.xpath("//button[@data-dismiss=\"modal\"]");
    By vieBtn = By.xpath("(//a[@href=\"/view_cart\"])[1]");
    @Step("add products with price less than 1000")
    public P03_productPage addProducts(){
        List<WebElement> products = driver.getDriver().findElements(productCard);
        try {
            for (int i = 0; i < products.size(); i++) {
                int productPrice = Integer.parseInt(driver.getDriver().
                        findElement(By.xpath("(//div[@class='productinfo text-center']/h2)[" + (i + 1) + "]")).
                        getText().replaceAll("[^0-9]", ""));

                System.out.println("price of product " + (i + 1) + " is: " + productPrice);

                if (productPrice < 1000){
                    driver.element().scrollToElement(vieBtn).click(By.xpath("(//div[@class=\"productinfo text-center\"])[" + (i + 1) + "]/a"))
                            .click(continueButton);

                    System.out.println("Added product with price " + productPrice + " to the cart");

                    try { Thread.sleep(250); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Step("verify view cart product ")
    public void productVerfication(){
        driver.element().click(vieBtn).and().browser().captureScreenshot();
    }
}
