package com.employee.CallbackGen.business.examples;

import org.openqa.selenium.By;

// TODO: можно будет удалить
public class Selectors {
    // Примеры селекторов

    // XPATH
    By selectorXPath1 = By.xpath("//*[@id=\"MiddleColumn\"]/div[4]/div[1]");
    By selectorXPath2 = By.xpath("//button[normalize-space()='Done']");

    // ID
    By selectorID1 = By.id("Main");

    // CSS
    By selectorCSS1 = By.cssSelector("#RightColumn > div.Transition > div > div > div:nth-child(3) > div > div > div");
    By selectorCSS2 = By.cssSelector("[class=\"Spinner__inner\"]");
    By selectorCSS3 = By.cssSelector("[class=\"dialog-buttons\"]>button:nth-of-type(2)");
    By selectorCSS4 = By.cssSelector("[class=\"chat-list custom-scroll\"]>div:nth-child(1)>[class=\"ListItem-button\"]");
}
