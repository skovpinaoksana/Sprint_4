package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private final static String URL = "https://qa-scooter.praktikum-services.ru/";
    private final By acceptCookiesButton = By.id("rcc-confirm-button");
    private final By questionsAndAnswersSection = By.xpath(".//div[text()='Вопросы о важном']");
    private final String questionLocatorBase = "accordion__heading-";
    private final String answerLocatorBase = ".//div[@id='accordion__panel-";
    private final String answerLocatorSuffix = "']/p";
    private final By orderInHeaderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By orderInContextButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void clickAcceptCookiesButton() {
        if (driver.findElement(acceptCookiesButton).isDisplayed()) {
            driver.findElement(acceptCookiesButton).click();
        }
    }

    public void scrollToQuestionsAndAnswersSection() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsAndAnswersSection));
    }

    public void clickQuestion(int index) {
        String questionLocator = questionLocatorBase + index;
        driver.findElement(By.id(questionLocator)).click();
    }

    public String getQuestionText(int index) {
        String questionLocator = questionLocatorBase + index;
        return driver.findElement(By.id(questionLocator)).getText();
    }

    public String getAnswerText(int index) {
        String answerLocator = answerLocatorBase + index + answerLocatorSuffix;
        return driver.findElement(By.xpath(answerLocator)).getText();
    }

    public void clickOrderInHeaderButton() {
        driver.findElement(orderInHeaderButton).click();
    }

    public void clickOrderInContextButton() {
        driver.findElement(orderInContextButton).click();
    }

    public void scrollToOrderInContextButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderInContextButton));
    }
}
