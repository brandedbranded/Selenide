package task_7_4_3;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;
import static common.Urls.NEW_WINDOW_PAGE;
import static elements.task_743.NewWindowPageElements.newWindowBtn;
import static steps.StepsForTests.checkText;
import static steps.StepsForTests.notEquals;

import baseTest.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NewWindowTest extends BaseTest {

    @BeforeEach
    public void openBrowser() {
        openBrowser(NEW_WINDOW_PAGE);
    }

    @Test
    @DisplayName("Открытие нового окна")
    @Description("Скрипт переключается между вкладками и закрывает новую вкладку")
    public void newWindowTest() {
        String window1 = switchTo().window(0).getWindowHandle();
        newWindowBtn.shouldBe(visible).click();
        String window2 = switchTo().window(1).getWindowHandle();
        notEquals(window1, window2);
        checkText("New window");
        closeWindow();
        switchTo().window(0).getWindowHandle().equals(window1);
    }
}
