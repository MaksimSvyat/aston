import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@id='cookie-agree']")
    private WebElement cookieAgreeButton;

    @FindBy(xpath = "//div[@class='pay__wrapper']")
    private WebElement payWrapper;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement serviceOptionsButton;

    @FindBy(xpath = "//ul[@class='select__list']")
    private WebElement serviceOptionsList;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumField;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='internet-phone']")
    private WebElement internetPhoneField;

    @FindBy(xpath = "//input[@id='internet-sum']")
    private WebElement internetSumField;

    @FindBy(xpath = "//input[@id='internet-email']")
    private WebElement internetEmailField;

    @FindBy(xpath = "//input[@id='score-instalment']")
    private WebElement scoreInstalmentField;

    @FindBy(xpath = "//input[@id='instalment-sum']")
    private WebElement instalmentSumField;

    @FindBy(xpath = "//input[@id='instalment-email']")
    private WebElement instalmentEmailField;

    @FindBy(xpath = "//input[@id='score-arrears']")
    private WebElement scoreArrearsField;

    @FindBy(xpath = "//input[@id='arrears-sum']")
    private WebElement arrearsSumField;

    @FindBy(xpath = "//input[@id='arrears-email']")
    private WebElement arrearsEmailField;

    @FindBy(xpath = "//*[@id='pay-connection']/button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payFormPhone;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span[not(@class='pay-description__cost_converted')]")
    private WebElement payFormSum;

    @FindBy(xpath = "//button[@type='submit'][@class='colored disabled']")
    private WebElement payButton;

    @FindBy(xpath = "//input[@formcontrolname='creditCard']/../label")
    private WebElement cardNumberField;

    @FindBy(xpath = "//input[@formcontrolname='expirationDate']/../label")
    private WebElement expirationDateField;

    @FindBy(xpath = "//input[@formcontrolname='cvc']/../label")
    private WebElement cvcField;

    @FindBy(xpath = "//input[@formcontrolname='holder']/../label")
    private WebElement holderField;

    @FindBy(xpath = "//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']")
    private WebElement mastercardLabel;

    @FindBy(xpath = "//img[@src='assets/images/payment-icons/card-types/visa-system.svg']")
    private WebElement visaLabel;

    @FindBy(xpath = "//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']")
    private WebElement belkartLabel;

    @FindBy(xpath = "//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']")
    private WebElement mirLabel;

    public MainPage(String url) {
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    @Step("Принятие соглашения по применения кук.")
    public MainPage clickCookieAgreeButton() {
        cookieAgreeButton.click();
        return this;
    }

    @Step("Скрол до формы онлайн пополнения.")
    public MainPage scrollIntoBlock() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", payWrapper);
        return this;
    }

    @Step("Выбор вида услуг для оплаты из выпадающего списка.")
    public MainPage choosingServiceOption(int num) {
        serviceOptionsButton.click();
        String xpath = String.format("//ul[@class='select__list']/li[%d]", num);
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return this;
    }

    @Step("Сверка надписей в незаполненных полях.")
    public void assertLabelsBlankFields(int num, String first, String second, String third) {
        String actualText;

        switch (num) {
            case 1:
                actualText = phoneField.getAttribute("placeholder");
                assertEquals(first, actualText);
                actualText = sumField.getAttribute("placeholder");
                assertEquals(second, actualText);
                actualText = emailField.getAttribute("placeholder");
                assertEquals(third, actualText);
                break;
            case 2:
                actualText = internetPhoneField.getAttribute("placeholder");
                assertEquals(first, actualText);
                actualText = internetSumField.getAttribute("placeholder");
                assertEquals(second, actualText);
                actualText = internetEmailField.getAttribute("placeholder");
                assertEquals(third, actualText);
                break;
            case 3:
                actualText = scoreInstalmentField.getAttribute("placeholder");
                assertEquals(first, actualText);
                actualText = instalmentSumField.getAttribute("placeholder");
                assertEquals(second, actualText);
                actualText = instalmentEmailField.getAttribute("placeholder");
                assertEquals(third, actualText);
                break;
            case 4:
                actualText = scoreArrearsField.getAttribute("placeholder");
                assertEquals(first, actualText);
                actualText = arrearsSumField.getAttribute("placeholder");
                assertEquals(second, actualText);
                actualText = arrearsEmailField.getAttribute("placeholder");
                assertEquals(third, actualText);
                break;
        }
    }

    @Step("Заполняются обязательные поля и нажимается кнопка Продолжить.")
    public MainPage fillField(String phone, String sum) {
        phoneField.sendKeys(phone);
        sumField.sendKeys(sum);
        submitButton.click();
        return this;
    }

    @Step("Сверка надписеей и проверка наличия иконок платёжных систем.")
    public void assertPhonePaymentFormFields(List<String> list) throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        Assertions.assertAll("Проверка полей и иконок",
                () -> assertEquals(list.get(0), payFormSum.getText()),
                () -> assertEquals(list.get(1), payFormPhone.getText()),
                () -> assertEquals(list.get(2), payButton.getText()),
                () -> assertEquals(list.get(3), cardNumberField.getText()),
                () -> assertEquals(list.get(4), expirationDateField.getText()),
                () -> assertEquals(list.get(5), cvcField.getText()),
                () -> assertEquals(list.get(6), holderField.getText()),
                () -> assertTrue(mastercardLabel.isDisplayed()),
                () -> assertTrue(visaLabel.isDisplayed()),
                () -> assertTrue(belkartLabel.isDisplayed()),
                () -> assertTrue(mirLabel.isDisplayed())
        );
    }
}
