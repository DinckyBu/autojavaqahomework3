package ru.netology.web;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardApplicationTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupAll() {
//        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void BeforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
//         options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    public void AfterEach() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldValidateInputs() {
//                WebElement form = driver.findElement(By.cssSelector("[data-test-id=order-form]"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Федерико-Федерикович Феллини");
        driver.findElement(By.cssSelector("[data-test-id=phone]input")).sendKeys("+12345678910");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.cssSelector("[button=button]")).click();
        var actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actualText);


    }


}
