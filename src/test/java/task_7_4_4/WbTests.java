package task_7_4_4;

import static assertsForTest.Assert.checkTextContainsOnPage;
import static assertsForTest.Assert.getNameOfItem;
import static assertsForTest.Assert.getPriceOfItem;
import static assertsForTest.Assert.verifyPriceOnElement;
import static assertsForTest.Assert.verifyRedirectToHomePage;
import static assertsForTest.Assert.verifyTextOnElement;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static common.Constants.ITEM;
import static common.Urls.WB_PAGE;
import static elements.task_744.AddToCartPageElements.addToBasket;
import static elements.task_744.AddToCartPageElements.basketBtn;
import static elements.task_744.AddToCartPageElements.catalogTitle;
import static elements.task_744.AddToCartPageElements.counterAboveBasket;
import static elements.task_744.AddToCartPageElements.filterBtn;
import static elements.task_744.AddToCartPageElements.filterPath;
import static elements.task_744.AddToCartPageElements.firstVacuum;
import static elements.task_744.AddToCartPageElements.homeAppliancesBtn;
import static elements.task_744.AddToCartPageElements.householdBtn;
import static elements.task_744.AddToCartPageElements.nameOfItem;
import static elements.task_744.AddToCartPageElements.orderBtn;
import static elements.task_744.AddToCartPageElements.priceInsideBasket;
import static elements.task_744.AddToCartPageElements.priceOfItem;
import static elements.task_744.AddToCartPageElements.sumPriceInBasket;
import static elements.task_744.AddToCartPageElements.vacuums;
import static elements.task_744.CityChangePageElements.aboutPointAddress;
import static elements.task_744.CityChangePageElements.addressBtn;
import static elements.task_744.CityChangePageElements.chooseAddressBtn;
import static elements.task_744.CityChangePageElements.firstFoundAddress;
import static elements.task_744.CityChangePageElements.searchBoxInAddress;
import static elements.task_744.CityChangePageElements.visibleAddressOfChosenPoint;
import static elements.task_744.FiltresPageElements.allFiltres;
import static elements.task_744.FiltresPageElements.amountOfItemsOnPage;
import static elements.task_744.FiltresPageElements.brandApple;
import static elements.task_744.FiltresPageElements.electronicsBtn;
import static elements.task_744.FiltresPageElements.expectedAmountOfItems;
import static elements.task_744.FiltresPageElements.laptops;
import static elements.task_744.FiltresPageElements.laptopsAndPc;
import static elements.task_744.FiltresPageElements.lessThan3DaysBtn;
import static elements.task_744.FiltresPageElements.listOfFiltres;
import static elements.task_744.FiltresPageElements.priceMax;
import static elements.task_744.FiltresPageElements.priceMin;
import static elements.task_744.FiltresPageElements.screen133;
import static elements.task_744.FiltresPageElements.showItemsWithFiltres;
import static elements.task_744.FiltresPageElements.titleAfterSearch;
import static elements.task_744.SearchPageElements.brandOfFirstItem;
import static elements.task_744.SearchPageElements.crossBtn;
import static elements.task_744.SearchPageElements.filterForItems;
import static elements.task_744.SearchPageElements.foundItems;
import static elements.task_744.SearchPageElements.searchLine;
import static elements.task_744.SearchPageElements.sortBtn;
import static steps.StepsForTests.hoverClick;
import static steps.StepsForTests.sendKeysToPriceFilter;

import baseTest.BaseTest;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class WbTests extends BaseTest {

    @BeforeEach
    public void setUp() {
        openBrowser(WB_PAGE);
    }

    @Test
    @DisplayName("Работа с поисковой строкой")
    @Description("Присутствует текст Iphone 13. Первый фильтр - iphone 13. Применен фильтр По популярности. У первого устройства из списка бренд - Apple.")
    public void searchForItemTest() {
        searchLine.shouldBe(visible, enabled, interactable).click();
        searchLine.sendKeys(ITEM + Keys.ENTER);

        verifyTextOnElement(ITEM, foundItems);
        verifyTextOnElement(ITEM, filterForItems);
        verifyTextOnElement("По популярности", sortBtn);
        verifyTextOnElement("Apple", brandOfFirstItem);

        crossBtn.shouldBe(interactable).click();

        verifyTextOnElement("", searchLine);
    }

    /**
     * У меня тест работает четко, странно, почему у тебя не находит элемент, может не хватает
     * ожидания из-за скорости интернета? Я добавил условие editable и увеличил ожидание с 5 до 10
     * секунд.
     */
    @Test
    @DisplayName("Смена города")
    @Description("Адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов. Отображается адрес пункта выдачи.")
    public void changeCityTest() {
        addressBtn.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        searchBoxInAddress.shouldBe(visible, enabled, editable)
            .sendKeys("Санкт-Петербург" + Keys.ENTER);

        firstFoundAddress.shouldHave(text("Санкт-Петербург"));
        String addressFromList = firstFoundAddress.shouldBe(visible, enabled).getText();
        firstFoundAddress.shouldBe(interactable).click();

        verifyTextOnElement(addressFromList, aboutPointAddress);

        chooseAddressBtn.shouldBe(interactable).click();

        verifyTextOnElement(addressFromList, visibleAddressOfChosenPoint);
        verifyRedirectToHomePage(WB_PAGE);
    }

    @Test
    @DisplayName("Добавление товара в избранное")
    @Description("Товар добавляется в избранное, счетчик изменяется")
    public void addItemToFavorite() {
        hoverClick(filterBtn);
        householdBtn.shouldBe(visible, interactable).hover();
        homeAppliancesBtn.shouldBe(visible, interactable).click();
        vacuums.shouldBe(visible, interactable).click();

        verifyTextOnElement("Главная\n"
            + "Бытовая техника\n"
            + "Техника для дома\n"
            + "Пылесосы и пароочистители", filterPath);
        verifyTextOnElement("Пылесосы и пароочистители", catalogTitle);

        firstVacuum.shouldBe(visible).hover();
        addToBasket.shouldBe(visible, interactable).click();

        String nameItem = getNameOfItem(nameOfItem);
        String itemPrice = getPriceOfItem(priceOfItem);
        verifyTextOnElement("1", counterAboveBasket);

        basketBtn.shouldBe(interactable).click();

        verifyPriceOnElement(itemPrice, priceInsideBasket);
        checkTextContainsOnPage(nameItem);
        verifyPriceOnElement(itemPrice, sumPriceInBasket);
        orderBtn.shouldBe(interactable);
    }

    @Test
    @DisplayName("Работа с фильтрами")
    @Description("Фильтр активен, фильтр отображается на странице, есть кнопка Сбросить всё")
    public void useFiltres() {
        hoverClick(filterBtn);
        electronicsBtn.shouldBe(visible, interactable).hover();
        laptopsAndPc.shouldBe(interactable).click();
        laptops.shouldBe(interactable).click();

        verifyTextOnElement("Ноутбуки и ультрабуки", titleAfterSearch);

        allFiltres.shouldBe(interactable).click();
        sendKeysToPriceFilter(priceMin, "100000");
        sendKeysToPriceFilter(priceMax, "149000");
        lessThan3DaysBtn.shouldBe(interactable).click();
        brandApple.shouldBe(visible).click();
        screen133.shouldBe(visible).click();
        showItemsWithFiltres.shouldBe(interactable).click();

        verifyTextOnElement("до 3 дней", listOfFiltres);
        verifyTextOnElement("Apple", listOfFiltres);
        verifyTextOnElement("13", listOfFiltres);
        verifyTextOnElement("Сбросить все", listOfFiltres);

        amountOfItemsOnPage.shouldHave(size(Integer.parseInt(expectedAmountOfItems.getText())));
    }
}
