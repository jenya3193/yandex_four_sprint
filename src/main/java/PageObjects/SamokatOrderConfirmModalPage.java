package PageObjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;

public class SamokatOrderConfirmModalPage {

    private WebDriver driver;

    // кнопка Да
    private By modalConfirmButton = By.xpath("//div[contains(@class, 'Order_Modal')]//button[2]");

    // сообщение Заказ оформлен
    private By orderConfirmedText = By.xpath("//div[contains(@class, 'Order_ModalHeader')]");

    public SamokatOrderConfirmModalPage(WebDriver driver){
        this.driver = driver;
    }

    // клик по кнопке Да
    public void clickModalConfirmButton(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(orderConfirmedText, "Хотите оформить заказ?\n "));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(modalConfirmButton)));
        driver.findElement(modalConfirmButton).click();
    }

    // проверка перехода на модальное окно с успешным созданием заказа
    public void checkOrderConfirmation() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(modalConfirmButton)));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(orderConfirmedText, "Заказ оформлен"));
        MatcherAssert.assertThat(driver.findElement(orderConfirmedText).getText(), is("Заказ оформлен"));
    }

}
