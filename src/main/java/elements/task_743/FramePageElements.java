package elements.task_743;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class FramePageElements {

    public static SelenideElement frameBtn = $x("//a[@href='/iframe']");
    public static String frameName = "mce_0_ifr";
    public static SelenideElement writingField = $x("//p");
    public static SelenideElement boldBtn = $x("//button[@aria-label='Bold']");
    public static SelenideElement selectAllBtn = $x("//div[@role='button']");
}
