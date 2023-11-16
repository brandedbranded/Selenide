package elements.task_743;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class AlertPageElements {

    public static SelenideElement jsAlertBtn = $x("//button[@onclick='jsAlert()']");
    public static SelenideElement jsConfirmBtn = $x("//button[@onclick='jsConfirm()']");
    public static SelenideElement jsPromptBtn = $x("//button[@onclick='jsPrompt()']");
}
