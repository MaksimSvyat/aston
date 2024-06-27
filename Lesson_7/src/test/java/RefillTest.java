import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RefillTest extends BaseTest {

    @Test
    public void testCheckBlockTitle() {
        MainPage mainPage = new MainPage();
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .assertBlockName(ConfigProvider.BLOCK_NAME);
    }

    @Test
    public void testCheckPaymentSystemLogosPresence() {
        List<String> logos = new ArrayList<>();
        logos.add(ConfigProvider.LOGO_1);
        logos.add(ConfigProvider.LOGO_2);
        logos.add(ConfigProvider.LOGO_3);
        logos.add(ConfigProvider.LOGO_4);
        logos.add(ConfigProvider.LOGO_5);

        MainPage mainPage = new MainPage();
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .assertLogosPresence(logos);
    }

    @Test
    public void testCheckServiceLink() {
        MainPage mainPage = new MainPage();
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .clickAboutServiceRef()
                .assertURL(ConfigProvider.REF_URL);
    }

    @Test
    public void testFillFieldsAndContinueButton() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.clickCookieAgreeButton()
                .scrollIntoBlock()
                .fillField(ConfigProvider.TEST_PHONE_NUMBER, ConfigProvider.TEST_SUM)
                .assertPayForm(ConfigProvider.PHONE_IN_FORM, ConfigProvider.SUM_IN_FORM);
    }
}
