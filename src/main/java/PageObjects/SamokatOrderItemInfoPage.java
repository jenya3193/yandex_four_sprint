package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SamokatOrderItemInfoPage {

    private WebDriver driver;

    // поле ввода Дата привоза самоката
    private By shippingDateInput = By.xpath("//div[contains(@class, 'Order_Form')]/div[1]//input");

    // выпадающий список Срок аренды
    private By rentalPeriodList = By.xpath("//div[contains(@class, 'Order_Form')]/div[2]");

    // элементы выпадающего списка Срок аренды
    private By rentalPeriodListItem = By.xpath("//div[contains(@class, 'Order_Form')]/div[2]//div[@class = 'Dropdown-option'][3]");

    // элементы списка Цвет самоката
    private By colourRadioGroupItem = By.xpath("//div[contains(@class, 'Order_Form')]/div[3]//label[2]");

    // поле ввода Комментарий курьеру
    private By commentaryInput = By.xpath("//div[contains(@class, 'Order_Form')]/div[4]//input");

    // кнопка Заказать
    private By orderButton = By.xpath("//div[contains(@class, 'Order_Buttons')]/button[2]");

    public SamokatOrderItemInfoPage(WebDriver driver){
        this.driver = driver;
    }

    // метод заполнения информации о заказе
    public void inputItemData(String date, String commentary) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(shippingDateInput)));
        driver.findElement(shippingDateInput).sendKeys(date);
        driver.findElement(shippingDateInput).sendKeys(Keys.ENTER);
        driver.findElement(rentalPeriodList).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(rentalPeriodListItem)));
        driver.findElement(rentalPeriodListItem).click();
        driver.findElement(colourRadioGroupItem).click();
        driver.findElement(commentaryInput).sendKeys(commentary);
        driver.findElement(orderButton).click();
    }

}
