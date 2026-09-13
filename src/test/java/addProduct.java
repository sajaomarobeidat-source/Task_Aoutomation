import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class addProduct
{
    SHAFT.GUI.WebDriver driver ;
    SHAFT.TestData.JSON data ;

    @Test
    public void addProducts(){
        new P01_LoginPgae(driver).login(data.getTestData("userNmae"), data.getTestData("password"))
                .NavigateProducts().addProducts().productVerfication();
    }
    @BeforeClass
    public void setUP(){
        driver= new  SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.automationexercise.com/login");
        data = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/testData.json");
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
