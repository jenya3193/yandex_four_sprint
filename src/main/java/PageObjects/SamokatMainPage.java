package PageObjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class SamokatMainPage {

    private WebDriver driver;
    // кнопка заказать в Nav
    private By navPanelOrderButton = By.xpath("//div[contains(@class, 'Header_Nav')]/button[1]");

    // кнопка заказать в RoadMap
    private By roadMapOrderButton = By.xpath("//div[contains(@class, 'Home_RoadMap')]//button");

    // список элементов раздела «Вопросы о важном»
    private By questionListItem = By.className("accordion__item");

    // список внутренних тектовых элементов раздела «Вопросы о важном»
    private By questionListInnerItem = By.xpath("//div[@class = 'accordion__panel']/p");

    // кнопка Принять куки
    private By acceptCookiesButton = By.id("rcc-confirm-button");


    public SamokatMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
    }

    // метод клика по кнопке заказать
    public void clickOnOrderButton(String buttonName) {
        switch (buttonName) {
            case "кнопка Заказать в панели навигации":
                driver.findElement(navPanelOrderButton).click();
                break;
            case "кнопка Заказать в блоке инстркукций":
                clickAcceptCookiesButton();
                new Actions(driver).scrollToElement(driver.findElement(roadMapOrderButton)).perform();
                driver.findElement(roadMapOrderButton).click();
                break;
        }
    }

    // метод проверки списка элементов раздела «Вопросы о важном»
    public void assertQuestionListItems(String expectedAnswer, Integer questionNumber) {
        List<WebElement> questions = driver.findElements(questionListItem);
        List<WebElement> answers = driver.findElements(questionListInnerItem);
        int questionIndex = questionNumber - 1;
        clickAcceptCookiesButton();
        new Actions(driver).scrollToElement(questions.get(questionIndex)).perform();
        questions.get(questionIndex).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(answers.get(questionIndex)));
        MatcherAssert.assertThat(answers.get(questionIndex).getText(), is(expectedAnswer));
    }

}
