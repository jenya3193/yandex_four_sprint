import PageObjects.SamokatMainPage;
import PageObjects.SamokatOrderConfirmModalPage;
import PageObjects.SamokatOrderItemInfoPage;
import PageObjects.SamokatOrderUserInfoPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class OrderTest {
    // парметр теста для кнопки Заказать
    private String orderButton;

    private WebDriver driver;

    public OrderTest(String orderButton) {
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object[] getOrderNameButton() {
        return new Object[] {
                "кнопка Заказать в панели навигации",
                "кнопка Заказать в блоке инстркукций"
        };
    }

    @Test
    public void checkQuestionAndAnswers() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamokatMainPage = new SamokatMainPage(driver);
        objSamokatMainPage.clickOnOrderButton(orderButton);

        SamokatOrderUserInfoPage objSamokatOrderUserInfoPage = new SamokatOrderUserInfoPage(driver);
        objSamokatOrderUserInfoPage.inputUserData("Евгений", "Иванов", "Москва", "12345678910");

        SamokatOrderItemInfoPage objSamokatOrderItemInfoPage = new SamokatOrderItemInfoPage(driver);
        objSamokatOrderItemInfoPage.inputItemData("01.03.2023", "коммнтарий");

        SamokatOrderConfirmModalPage objSamokatOrderConfirmModalPage = new SamokatOrderConfirmModalPage(driver);
        objSamokatOrderConfirmModalPage.clickModalConfirmButton();
        objSamokatOrderConfirmModalPage.checkOrderConfirmation();

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
