package elements;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class InternetPageElements {

    public static SelenideElement addElement = $x("//button[@onclick='addElement()']");
    public static SelenideElement addedManually = $x("//button[@class='added-manually']");
    public static SelenideElement inputNumbers = $x("//input[@type='number']");
    public static SelenideElement loginBtn = $x("//i[@class='fa fa-2x fa-sign-in']");
    public static SelenideElement flashAtrbt = $x("//div[@id='flash']");
    public static SelenideElement redirectBtn = $x("//a[@id='redirect']");
    public static SelenideElement hrefValue = $x("//a[@href='status_codes/200']");
    public static SelenideElement textOnPage = $x("//p");
}
