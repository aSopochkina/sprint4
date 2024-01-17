import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MakeOrderTest extends Utils {
    private String customerName;
    private String customerSurname;
    private String customerAddress;
    private String customerUnderground;
    private String customerMobileNumber;
    private String dateDelivery;
    private String rentalTime;
    private String colourSamokat;
    private String commentDelivery;

    public MakeOrderTest(String customerName, String customerSurname, String customerAddress, String customerUnderground, String customerMobileNumber, String dateDelivery, String rentalTime, String colourSamokat, String commentDelivery) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerAddress = customerAddress;
        this.customerUnderground = customerUnderground;
        this.customerMobileNumber = customerMobileNumber;
        this.dateDelivery = dateDelivery;
        this.rentalTime = rentalTime;
        this.colourSamokat = colourSamokat;
        this.commentDelivery = commentDelivery;
    }

    @Parameterized.Parameters
    public static Object[][] ordersVariants() {
        return new Object[][]{
                {"Александр", "Буйнов", "улица Зубковой", "1", "89109009090", "17.01.2024", "сутки", "grey", "ничего"},
                {"Анастасия", "Рожкова", "улица Штрауса", "2", "89909909090", "16.01.2024", "двое суток", "black", "нет комментария"}
        };
    }

    // Тут тест будет падать, т.к. на chrome баг, не выводится надпись 'Заказ оформлен'
    @Test
    public void order() {
        String buttonOrder = "Top";
        boolean actual = new MainPage(driver)
                .clickAcceptCookie()
                .clickButtonOrder(buttonOrder)
                .setCustomerInfo(customerName, customerSurname, customerAddress, customerUnderground, customerMobileNumber)
                .clickButtonNext()
                .setRentalInfo(dateDelivery, rentalTime, colourSamokat, commentDelivery)
                .clickYesRegistrationOrder()
                .isOrderProcessed();

        assertTrue("Всплывающего окна Заказ оформлен нет", actual);
    }

    @Test
    public void orderLowerButton() {
        String buttonOrder = "Lower";
        boolean actual = new MainPage(driver)
                .clickAcceptCookie()
                .clickButtonOrder(buttonOrder)
                .isTitlePresent();

        assertTrue("Не перешли на форму ввода параметров заказа", actual);
    }
}
