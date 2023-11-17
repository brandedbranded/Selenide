package assertsForTest;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.SelenideElement;

public class Assert {

    public static void verifyTextOnElement(String expectedText, SelenideElement element) {
        assertTrue(element.shouldBe(visible, exist).getText().contains(expectedText));
    }

    public static void verifyPriceOnElement(String expPrice, SelenideElement element) {
        element.shouldBe(visible, exist).shouldHave(text(expPrice));
        assertEquals(element.getText(), expPrice);
    }

    public static String getNameOfItem(SelenideElement element) {
        return element.shouldBe(visible, exist).getText().substring(2);
    }

    public static String getPriceOfItem(SelenideElement element) {
        return element.shouldBe(visible, exist).getText();
    }

    public static void checkTextContainsOnPage(String expectedText) {
        assertTrue($x("//body").shouldBe(visible).getText().contains(expectedText));
    }

    public static void verifyRedirectToHomePage(String url) {
        assertTrue(
            $x("//base[@href]").getAttribute("href").contains(url));
    }

}
