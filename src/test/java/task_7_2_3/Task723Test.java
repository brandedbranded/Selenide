package task_7_2_3;

import static assertsForTest.Assert.verifyTextOnElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static common.Constants.QUANTITY_ITEMS;
import static common.Constants.SEARCH_PHONE;
import static common.Urls.WB_PAGE;
import static elements.WbPageElements.addToBasket;
import static elements.WbPageElements.amountItemsInCart;
import static elements.WbPageElements.firstItem;
import static elements.WbPageElements.goToBasket;
import static elements.WbPageElements.searchBtn;
import static elements.WbPageElements.searchInput;

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
        searchInput.sendKeys(SEARCH_PHONE);
        searchBtn.click();
        firstItem.shouldBe(exist, visible, enabled).click();
        addToBasket.click();
        goToBasket.click();
        verifyTextOnElement(QUANTITY_ITEMS, amountItemsInCart);
    }
}
