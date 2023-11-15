package elements;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class WbPageElements {

    public static SelenideElement searchInput = $x("//input[@id='searchInput']");
    public static SelenideElement searchBtn = $x("//button[@id='applySearchBtn']");
    public static SelenideElement firstItem = $x("//div[@class='product-card__wrapper']");
    public static SelenideElement addToBasket = $x("//button[@class='btn-main']");
    public static SelenideElement goToBasket = $x("//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static SelenideElement amountItemsInCart = $x("//div[@class='b-top__count line']");
}
