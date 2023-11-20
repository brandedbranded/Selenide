package steps;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.codeborne.selenide.SelenideElement;

public class StepsForTests {

    public static void checkAlertIsClosed(String expectedText) {
        $x("//body").shouldHave(text(expectedText));
    }

    public static void checkText(String expectedText) {
        $x("//body").shouldHave(text(expectedText));
    }

    public static void notEquals(String s, String s1) {
        assertNotEquals(s, s1);
    }

    public static void sendKeysToPriceFilter(SelenideElement element, String price) {
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable).sendKeys(price);
    }

    public static void hoverClick(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
    }
}
