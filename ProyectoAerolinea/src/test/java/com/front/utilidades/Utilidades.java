package com.front.utilidades;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Utilidades extends PageObject {

    private WebDriver driver;
    public void bordearElemento(WebElementFacade webLocalizador) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed red'", webLocalizador);
    }

    public void posicionarElemento(WebElementFacade strWebElement) {
        Actions actions=new Actions(getDriver());
        actions.moveToElement(strWebElement).perform();
    }

    public void scrollUpWithActions(int numberKeystrokes) throws InterruptedException {
        Actions actions = new Actions(driver);
        for (int i = 0; i < numberKeystrokes; i++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
            Thread.sleep(10);
        }
    }
    public void scrollDownWithActions(int numberKeystrokes) throws InterruptedException {
        Actions actions = new Actions(driver);
        for (int i = 0; i < numberKeystrokes; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(10);
        }
    }
    public void tomarCapturaPantallaDesdeElemento(WebElementFacade strWebElement) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", strWebElement);
        //Serenity.takeScreenshot();
    }
}
