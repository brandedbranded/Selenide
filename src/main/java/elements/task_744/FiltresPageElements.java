package elements.task_744;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


public class FiltresPageElements {

    public static SelenideElement electronicsBtn = $x("//li[@data-menu-id='4830']");
    public static SelenideElement laptopsAndPc = $x(
        "//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static SelenideElement laptops = $(By.linkText("Ноутбуки"));
    public static SelenideElement allFiltres = $x(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--all']");
    public static SelenideElement priceMin = $x("(//input[@class='j-price'])[1]");
    public static SelenideElement priceMax = $x("(//input[@class='j-price'])[2]");
    public static SelenideElement lessThan3DaysBtn = $x("//*[contains(text(), 'до 3 дней')]");
    public static SelenideElement brandApple = $x("//span[contains(text(), 'Apple')]");
    public static SelenideElement screen133 = $x("//span[contains(text(), '13.3')]");
    public static SelenideElement showItemsWithFiltres = $x(
        "//button[@class='filters-desktop__btn-main btn-main']");
    public static SelenideElement listOfFiltres = $x("//ul[@class='your-choice__list']");
    public static SelenideElement titleAfterSearch = $x("//h1[@class='catalog-title']");
    public static SelenideElement expectedAmountOfItems = $x(
        "//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
    public static ElementsCollection amountOfItemsOnPage = $$(
        "a[class='product-card__link j-card-link j-open-full-product-card']");
}
