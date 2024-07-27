package org.ruananta.systemeiowebtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MakeMoneyHomePopupTest {
    public static final String DOCKER_WEB_DRIVER_URL = "http://localhost:4444/wd/hub";
    private final boolean LOCAL_WEB_DRIVER = false;
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        //Локальный драйвер?
        if(LOCAL_WEB_DRIVER) setupLocalDriver();
        else setupDockerDriver();
    }

    //Настраиваю локальный драйвер
    private void setupLocalDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Включение headless режима
        options.addArguments("--disable-gpu"); // Отключаю gpu
        options.addArguments("--window-size=1920,1080"); // Установка размера окна

        driver = new ChromeDriver(options);
    }

    //Настраиваю удаленный драйвер
    private void setupDockerDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new RemoteWebDriver(new URL(DOCKER_WEB_DRIVER_URL), options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPopup(){

        // Открываю страницу
        driver.get("https://systeme.io/blog/make-money-home");

        // Создаю обработчик ожидания с ограничением в 10 секунд
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Жду элемент iframe
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

        // Переключаюсь на элемент iframe
        driver.switchTo().frame(iframe);

        // Ищу div элементы с текстом "I want to receive my copy", так как текст прописан не в кнопке, а в div блоке внутри кнопки
        // Если искать один элемент, то нужно обработать исключение (если элемент не найден - выбрасывается исключение), для удобства ищу список
        List<WebElement> buttons = driver.findElements(By.xpath("//div[contains(text(), 'I want to receive my copy')]"));

        // Не утверждаю тест если список пуст - элемент отсутствует
        assertFalse(buttons.isEmpty(), "Button 'I want to receive my copy' is not displayed");

        // Ищу элемент закрытия iframe через css селектор
        List<WebElement> closeButtons = driver.findElements(By.cssSelector("[data-testid='popup-close-icon']"));

        // Если список элементов не пустой
        if(!closeButtons.isEmpty()){

            // Нажимаю на элемент используя JavaScript, что бы избежать исключения
            // ElementClickInterceptedException, возникающего из-за перекрытия элемента
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButtons.get(0));

            //Еще раз ищу элемент закрытия iframe
            closeButtons = driver.findElements(By.cssSelector("[data-testid='popup-close-icon']"));

            //Утверждаю тест, если элемент больше не доступен
            assertTrue(closeButtons.isEmpty(), "Popup did not close");

        //Если список элементов пуст
        }else{

            //Проваливаю тест, так как кнопка закрытия iframe не видна
            fail("Close popup button is not displayed");
        }
    }
}
