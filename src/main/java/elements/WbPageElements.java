package elements;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class WbPageElements {

    public static SelenideElement searchInput = $x("//input[@id='searchInput']");
    public static SelenideElement searchBtn = $x("//button[@id='applySearchBtn']");
    public static SelenideElement firstItem = $x("//div[@class='product-card__wrapper']");

    /**
     * Это первоначальный вариант, он работает у меня как часы, могу скинуть видео
     */
    public static SelenideElement addToBasket = $x(
        "//button[@class='btn-main']");

    /**
     * Данный вариант, сделанный по твоим замечаниям, у меня не работает:
     * public static SelenideElement addToBasket =
     * $x("//div[@class='product-page__order-buttons']//button[@class='btn-main']");
     *
     * Пробовал разными способами, итог один.
     */
    public static SelenideElement goToBasket = $x(
        "//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static SelenideElement amountItemsInCart = $x("//div[@class='b-top__count line']");
}
