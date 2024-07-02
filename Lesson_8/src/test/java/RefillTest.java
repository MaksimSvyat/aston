import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RefillTest extends BaseTest {

    private final static String URL = "http://mts.by";
    private final static int PHONE = 1;
    private final static int HOME_INTERNET = 2;
    private final static int INSTALMENT = 3;
    private final static int ARREARS = 4;
    private final static String PHONE_TEXT = "Номер телефона";
    private final static String SUM_TEXT = "Сумма";
    private final static String EMAIL_TEXT = "E-mail для отправки чека";
    private final static String INTERNET_PHONE_TEXT = "Номер абонента";
    private final static String INSTALMENT_SCORE_TEXT = "Номер счета на 44";
    private final static String ARREARS_SCORE_TEXT = "Номер счета на 2073";
    private final static String PAY_FORM_PHONE = "Оплата: Услуги связи Номер:375297777777";
    private final static String PAY_FORM_SUM = "50.00 BYN";
    private final static String PAY_FORM_SUM_BUTTON = "Оплатить 50.00 BYN";
    private final static String CARD_NUMBER = "Номер карты";
    private final static String EXPIRATION_DATE = "Срок действия";
    private final static String CVC = "CVC";
    private final static String HOLDER = "Имя держателя (как на карте)";
    private final static String TEST_PHONE_NUMBER = "297777777";
    private final static String TEST_SUM = "50";



    @Test
    @Order(1)
    public void checkPhonePaymentFields() {
        MainPage mainPage = new MainPage(URL);
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .assertLabelsBlankFields(PHONE, PHONE_TEXT, SUM_TEXT, EMAIL_TEXT);
    }

    @Test
    @Order(2)
    public void checkInternetPaymentFields() {
        MainPage mainPage = new MainPage(URL);
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .choosingServiceOption(HOME_INTERNET)
                .assertLabelsBlankFields(HOME_INTERNET, INTERNET_PHONE_TEXT, SUM_TEXT, EMAIL_TEXT);
    }

    @Test
    @Order(3)
    public void checkInstalmentPaymentFields() {
        MainPage mainPage = new MainPage(URL);
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .choosingServiceOption(INSTALMENT)
                .assertLabelsBlankFields(INSTALMENT, INSTALMENT_SCORE_TEXT, SUM_TEXT, EMAIL_TEXT);
    }

    @Test
    @Order(4)
    public void checkArrearsPaymentFields() {
        MainPage mainPage = new MainPage(URL);
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .choosingServiceOption(ARREARS)
                .assertLabelsBlankFields(ARREARS, ARREARS_SCORE_TEXT, SUM_TEXT, EMAIL_TEXT);
    }

    @Test
    @Order(5)
    public void checkPhonePaymentFormFields() throws InterruptedException {
        List<String> fields = new ArrayList<>();
        fields.add(PAY_FORM_SUM);
        fields.add(PAY_FORM_PHONE);
        fields.add(PAY_FORM_SUM_BUTTON);
        fields.add(CARD_NUMBER);
        fields.add(EXPIRATION_DATE);
        fields.add(CVC);
        fields.add(HOLDER);

        MainPage mainPage = new MainPage(URL);
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .fillField(TEST_PHONE_NUMBER, TEST_SUM)
                .assertPhonePaymentFormFields(fields);
    }
}