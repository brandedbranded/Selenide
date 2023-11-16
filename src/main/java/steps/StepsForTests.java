package steps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
}
