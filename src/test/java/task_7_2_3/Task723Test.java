package task_7_2_3;

import static assertsForTest.Assert.verifyTextOnElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static common.Constants.QUANTITY_ITEMS;
import static common.Constants.SEARCH_PHONE;
import static common.Urls.WB_PAGE;
import static elements.WbPageElements.*;

import baseTest.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task723Test extends BaseTest {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Товар отображается в корзине")
    public void addToBasket() {
        openBrowser(WB_PAGE);
        searchInput.shouldBe(enabled, interactable).sendKeys(SEARCH_PHONE);
        searchBtn.shouldBe(enabled, interactable).click();
        firstItem.shouldBe(exist, visible, enabled).click();
        addToBasket.shouldBe(enabled, interactable).click();
        goToBasket.shouldBe(enabled, interactable).click();
        verifyTextOnElement(amountItemsInCart, QUANTITY_ITEMS);
    }
}
