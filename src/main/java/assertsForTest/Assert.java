package assertsForTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.SelenideElement;

public class Assert {

    public static void verifyTextOnElement(SelenideElement element, String expectedText) {
    assertTrue(element.getText().contains(expectedText));
    }

}
