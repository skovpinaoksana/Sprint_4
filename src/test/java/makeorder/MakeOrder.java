package makeorder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import main.BaseTest;
import pom.MainPage;
import pom.OrderPage;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class MakeOrder extends BaseTest {
    private final String orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String startDate;
    private final int orderDays;
    private final String color;
    private final String comments;

    public MakeOrder(String orderButton, String name, String surname, String address, String metro, String phone, String startDate, int orderDays, String color, String comments) {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.startDate = startDate;
        this.orderDays = orderDays;
        this.color = color;
        this.comments = comments;
    }

    @Parameterized.Parameters
    public static Object[][] checkMakeOrder() {
        return new Object[][]{
                {"orderInHeaderButton", "Барни", "Стинсон","Центральная 34", "Красносельская", "88009007766", "04.12.2022", 1, "black", "нет"},
                {"orderInContextButton", "Евген", "Давыдов", "Луговая 44", "Лубянка", "88009009988", "05.12.2022", 2, "", "полный заряд"},
        };
    }
    @Test
    public void shouldMakeOrder() {

        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        mainPage.clickAcceptCookiesButton();

        if ("orderInHeaderButton".equals(orderButton)) {
            mainPage.clickOrderInHeaderButton();
        } else if ("orderInContextButton".equals(orderButton)) {
            mainPage.clickOrderInContextButton();
        }

        OrderPage orderPage = new OrderPage(driver);

        orderPage.inputName(name);
        orderPage.inputSurname(surname);
        orderPage.inputAddress(address);
        orderPage.inputMetro(metro);
        orderPage.inputPhone(phone);

        orderPage.clickNextPersonFormButton();

        orderPage.setStartDateInput(startDate);
        orderPage.setDurationDropDownListInput(orderDays);
        orderPage.setColorCheckbox(color);
        orderPage.setCommentsInput(comments);

        orderPage.clickOrderFinalButton();
        orderPage.clickOrderConfirmationButton();

        assertTrue("Ожидаем появления подтверждения \"Заказ оформлен\".",orderPage.isOrderCompletedMsg());
    }
}
