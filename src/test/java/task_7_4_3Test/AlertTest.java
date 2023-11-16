package task_7_4_3Test;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.confirm;
import static com.codeborne.selenide.Selenide.dismiss;
import static com.codeborne.selenide.Selenide.switchTo;
import static common.Constants.ALERT_TEXT;
import static common.Urls.ALERT_PAGE;
import static elements.task_743.AlertPageElements.jsAlertBtn;
import static elements.task_743.AlertPageElements.jsConfirmBtn;
import static elements.task_743.AlertPageElements.jsPromptBtn;
import static steps.StepsForTests.checkAlertIsClosed;

import baseTest.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertTest extends BaseTest {

    @BeforeEach
    public void openBrowser() {
        openBrowser(ALERT_PAGE);
    }

    @Test
    @DisplayName("Взаимодействие с Alert")
    @Description("Текст в алерте - I am a JS Alert")
    public void alertAcceptCheckTextTest() {
        jsAlertBtn.shouldBe(interactable).click();
        switchTo().alert().getText().equals(ALERT_TEXT);
        confirm();
        checkAlertIsClosed("You successfully clicked an alert");
    }

    @Test
    @DisplayName("Взаимодействие с Confirm")
    @Description("Алерт закрылся")
    public void alertDismissTest() {
        jsConfirmBtn.shouldBe(interactable).click();
        dismiss();
        checkAlertIsClosed("You clicked: Cancel");
    }

    @Test
    @DisplayName("Взаимодействие с Prompt")
    @Description("Введеный текст отображается на странице после принятия алерта")
    public void alertTextInput() {
        jsPromptBtn.shouldBe(interactable).click();
        switchTo().alert().sendKeys("Hello World");
        confirm();
        checkAlertIsClosed("You entered: Hello World");
    }
}
