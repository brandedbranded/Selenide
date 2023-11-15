package task_7_2_3;

import static assertsForTest.Assert.*;
import static com.codeborne.selenide.Condition.*;
import static common.Constants.*;

import static common.Urls.*;
import static elements.WbPageElements.*;

import baseTest.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task723Test extends BaseTest {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Товар отображается в корзине")
    public void addToBasket() throws InterruptedException {
        openBrowser(WB_PAGE);
        searchInput.sendKeys(SEARCH_PHONE);
        searchBtn.click();
        firstItem.shouldBe(exist, visible, enabled).click();
        addToBasket.click();
        goToBasket.click();
        verifyTextOnElement(amountItemsInCart, QUANTITY_ITEMS);
    }
}
