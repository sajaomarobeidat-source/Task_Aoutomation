import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_LoginPgae {
    SHAFT.GUI.WebDriver driver ;
    //constuctor
    public P01_LoginPgae(SHAFT.GUI.WebDriver driver){
            this.driver=driver ;
    }
    // Locetors
    By emailInput = By.xpath("//input[@data-qa=\"login-email\"]");
    By passInput = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    // Methods
    public P02_homePage login(String userNmae , String Password){
        driver.element().type(emailInput,userNmae).
                type(passInput,Password).click(loginButton);
        return new P02_homePage(driver);
    }
}
