package condition;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebElementCondition;
import javax.annotation.Nonnull;
import org.openqa.selenium.WebElement;

public class MyCondition {

    public static WebElementCondition button(String button) {
        return new WebElementCondition(button) {
            @Nonnull
            @Override
            public CheckResult check(Driver driver, WebElement element) {
                String tagName = element.getTagName();
                boolean verifyTag = tagName.equals("button");
                return new CheckResult(verifyTag, tagName);
            }
        };
    }
}

