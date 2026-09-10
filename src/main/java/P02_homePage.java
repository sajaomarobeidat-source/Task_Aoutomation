import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P02_homePage {
    SHAFT.GUI.WebDriver driver ;
    public  P02_homePage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }
    // Locetors
    By menBtin = By.xpath("//a[@href=\"#Men\"]");
    By tshirBtn = By.xpath("//a[@href=\"/category_products/3\"] and contains (.,'Tshirts') ");
    public void NavigateProducts(){
        driver.element().click(menBtin).click(tshirBtn);
    }

}
