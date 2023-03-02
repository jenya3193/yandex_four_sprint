import PageObjects.SamokatMainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAndAnswersTest {

        private WebDriver driver;

        @Test
        public void checkQuestionAndAnswers() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.get("https://qa-scooter.praktikum-services.ru/");

            SamokatMainPage objSamokatMainPage = new SamokatMainPage(driver);

            // подготовка требуемых тестовых данных
            List<String> expectedAnswers = new ArrayList<>();
            expectedAnswers.add("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
            expectedAnswers.add("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
            expectedAnswers.add("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
            expectedAnswers.add("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
            expectedAnswers.add("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
            expectedAnswers.add("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
            expectedAnswers.add("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
            expectedAnswers.add("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
            objSamokatMainPage.assertQuestionListItems(expectedAnswers);

        }


        @After
        public void teardown() {
            driver.quit();
        }

}