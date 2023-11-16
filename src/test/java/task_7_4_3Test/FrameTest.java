package task_7_4_3Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static common.Urls.FRAMES_PAGE;
import static elements.task_743.FramePageElements.boldBtn;
import static elements.task_743.FramePageElements.frameBtn;
import static elements.task_743.FramePageElements.frameName;
import static elements.task_743.FramePageElements.selectAllBtn;
import static elements.task_743.FramePageElements.writingField;

import baseTest.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrameTest extends BaseTest {

    @BeforeEach
    public void openBrowser() {
        openBrowser(FRAMES_PAGE);
    }

    @Test
    @DisplayName("Взаимодействие с элементами внутри фрейма")
    @Description("Введенный текст оформляется жирным шрифтом, браузер закрывается")
    public void framesTest() {
        frameBtn.shouldBe(enabled, visible, interactable).click();
        boldBtn.shouldBe(visible, interactable).click();
        switchTo().frame(frameName);
        writingField.shouldBe(visible).clear();
        writingField.sendKeys("Hello World");
        switchTo().defaultContent();
        selectAllBtn.shouldBe(interactable).click();
        boldBtn.shouldBe(visible, interactable).click();
    }
}
