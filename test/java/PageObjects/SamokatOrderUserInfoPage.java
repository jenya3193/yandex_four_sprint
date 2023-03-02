package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class SamokatOrderUserInfoPage {

    private WebDriver driver;

    // поле ввода Имя пользователя
    private By userNameInput = By.xpath("//div[contains(@class, 'Order_Form')]/div[1]/input");

    // поле ввода Фамилия пользователя
    private By userSurnameInput = By.xpath("//div[contains(@class, 'Order_Form')]/div[2]/input");

    // поле ввода Адрес
    private By userAddressInput = By.xpath("//div[contains(@class, 'Order_Form')]/div[3]/input");

    // поле ввода с подсказкой Станция метро
    private By metroStationInput = By.xpath("//div[contains(@class, 'Order_Form')]/div[4]//input");

    // поле ввода с подсказкой Станция метро
    private By metroStationListItem = By.xpath("//div[contains(@class, 'Order_Form')]/div[4]//li[1]");

    // поле ввода Телефон
    private By phoneInput = By.xpath("//div[contains(@class, 'Order_Form')]/div[5]/input");

    // кнопка Далее
    private By NextButton = By.xpath("//div[contains(@class, 'Order_NextButton')]/button");

    public SamokatOrderUserInfoPage(WebDriver driver){
        this.driver = driver;
    }

    // метод заполнения данных пользователя
    public void inputUserData(String userName, String userSurname, String address, String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(userNameInput)));
        driver.findElement(userNameInput).sendKeys(userName);
        driver.findElement(userSurnameInput).sendKeys(userSurname);
        driver.findElement(userAddressInput).sendKeys(address);
        driver.findElement(metroStationInput).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(metroStationListItem)));
        driver.findElement(metroStationListItem).click();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(NextButton).click();
    }

}
