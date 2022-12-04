package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final WebDriver driver;
    private final By nameInput = By.xpath(".//input[@placeholder = '* Имя']");
    private final By surnameInput = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By addressInput = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By metroInput = By.xpath(".//input[@placeholder = '* Станция метро']");
    private final By phoneInput = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By startDateInput = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private final By durationDropDownListInput = By.xpath(".//div[text() = '* Срок аренды']");
    private final By durationOptionsDropDownList = By.xpath(".//div[@class = 'Dropdown-option']");
    private final By colorBlackCheckbox = By.xpath(".//input[@id = 'black']");
    private final By colorGrayCheckbox = By.xpath(".//input[@id = 'gray']");
    private final By commentsInput = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private final By nextPersonFormButton = By.xpath(".//button[text() = 'Далее']");
    private final By orderFinalButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By orderConfirmationButton = By.xpath(".//button[text() = 'Да']");
    private final By orderCompletedMsg = By.xpath(".//div[text() = 'Заказ оформлен']");
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void inputName(String text) {
        driver.findElement(nameInput).sendKeys(text);
    }
    public void inputSurname(String text) {
        driver.findElement(surnameInput).sendKeys(text);
    }
    public void inputAddress(String text) {
        driver.findElement(addressInput).sendKeys(text);
    }
    public void inputMetro(String text) {
        driver.findElement(metroInput).click();
        driver.findElement(metroInput).sendKeys(text, Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void inputPhone(String text) {
        driver.findElement(phoneInput).sendKeys(text);
    }
    public void setStartDateInput(String text) {
        driver.findElement(startDateInput).click();
        driver.findElement(startDateInput).sendKeys(text, Keys.ENTER);
    }
    public void setDurationDropDownListInput(int day) {
        driver.findElement(durationDropDownListInput).click();
        driver.findElements(durationOptionsDropDownList).get(day).click();
    }
    public void setColorCheckbox(String color) {
        if ("black".equals(color)) {
            driver.findElement(colorBlackCheckbox).click();
        } else if ("grey".equals(color))  {
            driver.findElement(colorGrayCheckbox).click();
        }
    }
    public void setCommentsInput(String comments) {
        driver.findElement(commentsInput).sendKeys(comments);
    }

    public void clickNextPersonFormButton() {
        driver.findElement(nextPersonFormButton).click();
    }

    public void clickOrderFinalButton() {
        driver.findElement(orderFinalButton).click();
    }

    public void clickOrderConfirmationButton() {
        driver.findElement(orderConfirmationButton).click();
    }

    public boolean isOrderCompletedMsg() {
        return driver.findElements(orderCompletedMsg).size() > 0;
    }
}
