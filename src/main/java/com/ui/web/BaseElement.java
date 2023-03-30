package com.ui.web;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ui.config.ConfigReader;
import com.ui.managers.WebDriverFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j
@Data
public class BaseElement {
    private ConfigReader configs = ConfigReader.getInstance();
    private WebDriver driver = WebDriverFactory.getWebDriver();
    private Actions actions = new Actions(driver);
    private JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
    private BaseElement parentElement;
    private By locator;
    private String name;
    private final long IMPLICIT_NO_TIMEOUT = 500;
    private final long DEFAULT_TIMEOUT = configs.getImplicitWait();
    private final long MAX_WAIT_TIME = configs.getMaxWaitTime();

    public BaseElement(By locator, String name, BaseElement parentElement) {
        this.locator = locator;
        this.name = name != null ? name : locator.toString();
        this.parentElement = parentElement;
    }

    public BaseElement(String xPathLocator, String name, BaseElement parentElement) {
        this.locator = By.xpath(xPathLocator);
        this.name = name != null ? name : locator.toString();
        this.parentElement = parentElement;
    }

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name != null ? name : locator.toString();
    }

    public BaseElement(By locator) {
        this.locator = locator;
        this.name = locator.toString();
    }

    public BaseElement(String xPathLocator) {
        this.locator = By.xpath(xPathLocator);
        this.name = locator.toString();
    }

    public BaseElement(String xPathLocator, String name) {
        this.locator = By.xpath(xPathLocator);
        this.name = name;
    }

    public By getLocator() {
        return locator;
    }
    @SuppressWarnings("unchecked")
    public <T extends BaseElement> T elementOfType(By locator, String name, Class<T> clazz) {
        T object = null;
        try {
            Constructor<?> ctor = clazz.getConstructor(By.class, String.class, BaseElement.class);
            object = (T) ctor.newInstance(locator, name, this);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

    public WebElement getRawElement() {
        waitTillIsPresent(5);

        return getDriver().findElement(getFullLocator());
    }

    public String getFullXpathString() {
        StringBuilder locator = new StringBuilder(this.locator.toString().replace("By.xpath: ", ""));
        return this.parentElement != null ?
                locator.insert(0, this.parentElement.getFullXpathString()).toString()
                : locator.toString();
    }

    public By getFullLocator(){
        return locator instanceof By.ByXPath ? By.xpath(getFullXpathString()) : locator;
    }
    public BaseElement element(By locator) {
        return new BaseElement(locator, null, this);
    }

    public ElementsList<BaseElement> elements(By locator) {
        return new ElementsList<BaseElement>(locator, null, this);
    }

    public List<WebElement> all(By locator) {
        return this.getRawElement().findElements(locator);
    }

    public String getName() {
        return name;
    }

    public void click() {
        log.info("Clicking:: [" + this.name + "]");
        this.getRawElement().click();
    }

    public void hover() {
        if (this.isDisplayed()) {
            log.info("Hovering:: [" + this.name + "]");
            new Actions(this.driver).moveToElement(this.getRawElement()).perform();
        } else {
            throw new Error("Cannot hover invisible element");
        }
    }

    public void hover(BaseElement el) {
        if (this.isDisplayed()) {
            log.info("Hovering:: [" + this.name + "]");
            new Actions(this.driver).moveToElement(el.getRawElement()).moveToElement(this.getRawElement()).perform();
        } else {
            throw new Error("Cannot hover invisible element");
        }
    }

    public void doubleClick() {
        log.info("Double clicking:: [" + this.name + "]");
        new Actions(this.driver).doubleClick(this.getRawElement()).perform();
    }

    public void rightClick() {
        log.info("Right clicking:: [" + this.name + "]");
        new Actions(this.driver).contextClick(this.getRawElement()).perform();
    }

    public void moveMouseAndClick() {
        log.info("Double clicking:: [" + this.name + "]");
        new Actions(this.driver).moveToElement(this.getRawElement()).click().perform();
    }

    public void clickAndHold() {
        log.info("Clicking and holding:: [" + this.name + "]");
        new Actions(this.driver).clickAndHold(this.getRawElement()).perform();
    }

    public void dragAndDrop(BaseElement target) {
        log.info("Dragging [" + this.name + "] into [" + target.name + "]");
        new Actions(this.driver).dragAndDrop(this.getRawElement(), target.getRawElement()).perform();
    }

    public String getText() {
        log.info("Getting text from:: [" + this.name + "]");
        return this.getRawElement().getText();
    }

    //    TODO
    public static void tryToRecover(Exception exception, BaseElement elem) {

    }

    public void sleepFor(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isDisplayed() {
        log.info("Is Displayed:: [" + this.name + "]");
        return this.getRawElement().isDisplayed();
    }

    public boolean isEnabled() {
        log.info("Checking if Enabled:: [" + this.name + "]");
        return this.getRawElement().isEnabled();
    }

    public boolean isPresent() {
        log.info("Is Present:: [" + this.name + "]");
        return this.driver.findElements(getFullLocator()).size() > 0;
    }

    public boolean isNotPresent() {
        log.info("Is Present:: [" + this.name + "]");
        return this.driver.findElements(getFullLocator()).size() == 0;
    }

    public void sendKeys(String text) {
        log.info("Sending keys to:: [" + this.name + "]");
        this.getRawElement().sendKeys(text);
    }

    public void sendKeys(Keys key) {
        log.info("Sending keys to:: [" + this.name + "]");
        this.getRawElement().sendKeys(key);
    }

    public void jsClick() {
        log.info("JS click:: [" + this.name + "]");
        jsExecutor.executeScript("arguments[0].click()", this.getRawElement());
    }

    public void executeJs(String js) {
        log.info("Executing JS script \"" + js + "\" on [" + this.name + "]");
        jsExecutor.executeScript(js, this.getRawElement());
    }

    public void executeJsOnElement(String js, BaseElement el) {
        log.info("Executing JS script \"" + js + "\" on [" + el.name + "]");
        jsExecutor.executeScript(js, el.getRawElement());
    }

    public void setImplicitTimeout(long timeoutInMilliseconds) {
        this.driver.manage().timeouts().implicitlyWait(timeoutInMilliseconds, TimeUnit.MILLISECONDS);
    }

    public void resetImplicitTimeout() {
        this.driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public void expectToBeDisplayed() {
        Assert.assertTrue(this.name + " is not visible", this.getRawElement().isDisplayed());
    }

    public void scrollTo() {
        log.info("Scrolling to:: [" + this.name + "]");
        jsExecutor.executeScript("arguments[0].scrollIntoView()", this.getRawElement());
    }

    public String getAttribute(String attributeName) {
        return this.getRawElement().getAttribute(attributeName);
    }

    public boolean waitTillIsGone(long timeoutInSeconds) {
        boolean isGone;
        log.info("Waiting till element [" + this.name + "] is gone");
        this.setImplicitTimeout(IMPLICIT_NO_TIMEOUT);
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        isGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(getFullLocator()));
        this.resetImplicitTimeout();
        if (isGone) {
            log.info("Element is gone");
        } else {
            log.info("Element is still present");
        }
        return isGone;
    }

    public boolean waitTillIsGone() {
        return waitTillIsGone(MAX_WAIT_TIME);
    }

    public boolean waitTillIsVisible(long timeoutInSeconds) {
        log.info("Waiting till element [" + this.name + "] is visible");
        this.setImplicitTimeout(IMPLICIT_NO_TIMEOUT);
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        this.resetImplicitTimeout();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(getFullLocator()));
            log.info("Element has become visible");
            return true;
        } catch (Exception e) {
            log.info("Element is still not visible");
            return false;
        }
    }

    public boolean waitTillIsVisible() {
        return waitTillIsVisible(MAX_WAIT_TIME);
    }

    public boolean isElementVisible() {
        this.setImplicitTimeout(IMPLICIT_NO_TIMEOUT);
        try {
            boolean isDisplayed = this.getRawElement().isDisplayed();
            if (isDisplayed)
                log.info("Element is visible");
            return isDisplayed;
        } catch (NoSuchElementException e) {
            log.info("Element is not visible");
            return false;
        } finally {
            this.resetImplicitTimeout();
        }
    }

    public boolean waitElementToHaveText(String text, long timeoutInSeconds) {
        log.info("Waiting till element [" + this.name + "] is has text: " + text);
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        boolean textPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(this.getFullXpathString()), text));
        if (textPresent) {
            log.info("Text is present");
        } else {
            log.info("Expected text is missing");
        }
        return textPresent;
    }
    //TODO for all conditions add not in arguments
    public boolean waitElementToHaveText(String text) {
        return waitElementToHaveText(text, MAX_WAIT_TIME);
    }

    public boolean waitTillIsPresent(long timeoutInSeconds) {
        log.info("Waiting till element [" + this.name + "] is present in DOM");
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(getFullLocator()));
            log.info("Element is present " + getFullXpathString());
            return true;
        } catch (Exception e) {
            log.info("Element is not present with xpath " + getFullXpathString());
            return false;
        }
    }

    public boolean waitTillIsClickable(long timeoutInSeconds) {
        log.info("Waiting till element [" + this.name + "] is present in DOM");
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(getFullLocator()));
            log.info("Element is clickable " + getFullXpathString());
            return true;
        } catch (Exception e) {
            log.info("Element is not clickable with xpath " + getFullXpathString());
            return false;
        }
    }

    public boolean waitTillIsPresent() {
        return waitTillIsPresent(MAX_WAIT_TIME);
    }

    public boolean waitTillIsEnabled(long timeoutInSeconds) {
        log.info("Waiting till element [" + this.name + "] is enabled and clickable");
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(this.getRawElement()));
            log.info("Element is enabled");
            return true;
        } catch (Exception e) {
            log.info("Element is not enabled");
            return false;
        }
    }

    public boolean waitTillIsEnabled() {
        return waitTillIsEnabled(MAX_WAIT_TIME);
    }

    public boolean waitTillIsDisabled(long timeoutInSeconds) {
        log.info("Waiting till element [" + this.name + "] is disabled");
        WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(this.getRawElement())));
            log.info("Element is disabled");
            return true;
        } catch (Exception e) {
            log.info("Element is not disabled");
            return false;
        }
    }

    public boolean waitTillIsDisabled() {
        return waitTillIsDisabled(MAX_WAIT_TIME);
    }

}
