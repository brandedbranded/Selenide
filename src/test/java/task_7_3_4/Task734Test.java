package task_7_3_4;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static common.Urls.ADD_ELEMENT;
import static common.Urls.INPUTS;
import static common.Urls.LOGIN;
import static common.Urls.REDIRECTOR;
import static condition.MyCondition.button;
import static elements.InternetPageElements.addElement;
import static elements.InternetPageElements.addedManually;
import static elements.InternetPageElements.flashAtrbt;
import static elements.InternetPageElements.hrefValue;
import static elements.InternetPageElements.inputNumbers;
import static elements.InternetPageElements.loginBtn;
import static elements.InternetPageElements.redirectBtn;
import static elements.InternetPageElements.textOnPage;

import baseTest.BaseTest;
import java.util.concurrent.TimeUnit;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task734Test extends BaseTest {

    @Test
    @DisplayName("Появление элемента на странице Add element")
    @Description("Ожидание появления элемента")
    public void appearanceOfElementTest() {
        openBrowser(ADD_ELEMENT);
        addElement.shouldBe(button("button")).click();
        addedManually.should(visible);
    }

    @Test
    @DisplayName("Исчезновение элемента на странице Add element")
    @Description("Ожидание исчезновения элемента")
    public void disappearanceOfElementTest() {
        openBrowser(ADD_ELEMENT);
        addElement.shouldBe(button("button")).click();
        addedManually.should(visible).click();
        addedManually.shouldNot(visible);
    }

    @Test
    @DisplayName("Появление текста на странице Add element")
    @Description("Ожидание появления текста")
    public void appearanceOfTextTest() {
        openBrowser(ADD_ELEMENT);
        addElement.shouldBe(button("button")).click();
        addedManually.should(visible).shouldHave(text("Delete"));
    }

    @Test
    @DisplayName("Появление значения на странице Inputs")
    @Description("Ожидание появления значения")
    public void waitingOfValueTest() {
        openBrowser(INPUTS);
        inputNumbers.sendKeys("1");
        inputNumbers.shouldHave(value("1"));
    }

    @Test
    @DisplayName("Появление атрибута на странице Login page")
    @Description("Ожидание появления атрибута")
    public void waitingOfAttributeTest() {
        openBrowser(LOGIN);
        loginBtn.click();
        flashAtrbt.shouldHave(attribute("data-alert"));
    }

    @Test
    @DisplayName("Ожидание перехода на другую страницу")
    @Description("Таймаут")
    public void testWithTimeOut() throws InterruptedException {
        openBrowser(REDIRECTOR);
        redirectBtn.click();
        TimeUnit.SECONDS.sleep(2);
        hrefValue.should(visible);
    }

    @Test
    @DisplayName("Ожидание перехода на другую страницу")
    @Description("Sleep")
    public void testWithSleep() {
        openBrowser(REDIRECTOR);
        redirectBtn.click();
        sleep(2000);
        hrefValue.should(visible);
    }

    @Test
    @DisplayName("Ожидание перехода на другую страницу")
    @Description("Sleep")
    public void testRedirect() throws InterruptedException {
        openBrowser(REDIRECTOR);
        redirectBtn.shouldBe(visible).click();
        sleep(2000);
        textOnPage.shouldHave(text("HTTP"));
        hrefValue.should(visible).click();
        TimeUnit.SECONDS.sleep(2);
        textOnPage.should(exist);
    }
}
