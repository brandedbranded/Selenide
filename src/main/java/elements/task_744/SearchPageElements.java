package elements.task_744;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;


public class SearchPageElements {

    public static SelenideElement searchLine = $x("//input[@id='searchInput']");
    public static SelenideElement foundItems = $x("//h1[@class='searching-results__title']");
    public static SelenideElement filterForItems = $(".dropdown-filter__btn--burger");
    public static SelenideElement sortBtn = $(".dropdown-filter__btn--sorter");
    public static SelenideElement brandOfFirstItem = $x(
        "(//span[@class='product-card__brand'])[1]");
    public static SelenideElement crossBtn = $x(
        "//button[@class='search-catalog__btn search-catalog__btn--clear search-catalog__btn--active']");
}
