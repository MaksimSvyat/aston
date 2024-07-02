import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@id='cookie-agree']")
    private WebElement cookieAgreeButton;

    @FindBy(xpath = "//div[@class='pay__wrapper']")
    private WebElement payWrapper;

    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    private WebElement payWrapperName;

    @FindBy(xpath = "//img[@alt='Visa']")
    private WebElement visaLogo;

    @FindBy(xpath = "//img[@alt='Verified By Visa']")
    private WebElement verifiedByVisaLogo;

    @FindBy(xpath = "//img[@alt='MasterCard']")
    private WebElement masterCardLogo;

    @FindBy(xpath = "//img[@alt='MasterCard Secure Code']")
    private WebElement masterCardSecureCodeLogo;

    @FindBy(xpath = "//img[@alt='Белкарт']")
    private WebElement belCardLogo;

    @FindBy(xpath = "//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']")
    private WebElement aboutServiceRef;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumField;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='pay-connection']/button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payFormPhone;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span[1]")
    private WebElement payFormSum;

    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public MainPage clickCookieAgreeButton() {
        cookieAgreeButton.click();
        return this;
    }

    public MainPage scrollIntoBlock() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", payWrapper);
        return this;
    }

    public void assertBlockName(String expectedText) {
        String h2InnerHTML = payWrapperName.getAttribute("innerHTML");
        Pattern pattern = Pattern.compile("<br\\s*/?>");
        Matcher matcher = pattern.matcher(h2InnerHTML);
        String actualText = matcher.replaceAll("");
        assertEquals(expectedText, actualText);
    }

    public void assertLogosPresence(List<String> expectedTexts) {
        List<WebElement> elements = new ArrayList<>();
        elements.add(visaLogo);
        elements.add(verifiedByVisaLogo);
        elements.add(masterCardLogo);
        elements.add(masterCardSecureCodeLogo);
        elements.add(belCardLogo);

        for (int i = 0; i < elements.size(); i++) {
            String actualText = elements.get(i).getAttribute("alt");
            String expectedText = expectedTexts.get(i);
            assertEquals(expectedText, actualText);
        }

    }

    public MainPage clickAboutServiceRef() {
        try {
            aboutServiceRef.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            ((JavascriptExecutor) driver).executeScript("window.stop();");
        }
        return this;
    }

    public void assertURL(String expectedText) {
        String actualText = driver.getCurrentUrl();
        assertEquals(expectedText, actualText);
    }

    public MainPage fillField(String phone, String sum) {
        phoneField.sendKeys(phone);
        sumField.sendKeys(sum);
        submitButton.click();
        return this;
    }

    public void assertPayForm(String expectedText1, String expectedText2) throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame(1);
        String actualText = payFormPhone.getText();
        assertEquals(expectedText1, actualText);

        actualText = payFormSum.getText();
        assertEquals(expectedText2, actualText);
    }
}
