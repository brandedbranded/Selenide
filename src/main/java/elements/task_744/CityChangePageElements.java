package elements.task_744;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;


public class CityChangePageElements {

    public static SelenideElement addressBtn = $x("//span[@data-wba-header-name='DLV_Adress']");
    public static SelenideElement searchBoxInAddress = $x(
        "//input[@class='ymaps-2-1-79-searchbox-input__input']");
    public static SelenideElement firstFoundAddress = $x(
        "(//span[@class='address-item__name-text'])[1]");
    public static SelenideElement aboutPointAddress = $x(
        "//span[@class='details-self__name-text']");
    public static SelenideElement chooseAddressBtn = $x(
        "//button[@class='details-self__btn btn-main']");
    public static SelenideElement visibleAddressOfChosenPoint = $x(
        "//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
}
