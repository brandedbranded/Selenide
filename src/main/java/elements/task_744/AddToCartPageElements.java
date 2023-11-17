package elements.task_744;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class AddToCartPageElements {

    public static SelenideElement filterBtn = $x("//span[@class='nav-element__burger-line']");
    public static SelenideElement householdBtn = $x("//li[@data-menu-id='16107']");
    public static SelenideElement homeAppliancesBtn = $x(
        "//span[contains(text(), 'Техника для дома')]");
    public static SelenideElement vacuums = $(By.linkText("Пылесосы и пароочистители"));
    public static SelenideElement filterPath = $x("//ul[@class='breadcrumbs__list']");
    public static SelenideElement catalogTitle = $x("//h1[@class='catalog-title']");
    public static SelenideElement firstVacuum = $x("(//div[@class='product-card__wrapper'])[1]");
    public static SelenideElement addToBasket = $x(
        "//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']");
    public static SelenideElement counterAboveBasket = $x("//span[@class='navbar-pc__notify']");
    public static SelenideElement basketBtn = $x(
        "//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static SelenideElement nameOfItem = $(".product-card__name");
    public static SelenideElement priceOfItem = $x("//ins[@class='price__lower-price']");
    public static SelenideElement priceInsideBasket = $x("//div[@class='list-item__price-new']");
    public static SelenideElement sumPriceInBasket = $("p.b-top__total span[data-jsv]");
    public static SelenideElement orderBtn = $x("//button[@data-link='{on submitOrder ~tag}']");
}
