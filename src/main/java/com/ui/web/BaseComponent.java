package com.ui.web;

import org.openqa.selenium.By;

public class BaseComponent extends BaseElement {

    public  BaseComponent(String byXpathLocator, String name, BaseElement parent){
        super(byXpathLocator, name + " component", parent);
    }
    public BaseComponent(By locator, String name) {
        super(locator, name + " component");
    }

    public BaseComponent(String xPathLocator) {
        super(By.xpath(xPathLocator), By.xpath(xPathLocator) + " component");
    }
    public BaseComponent(String xPathLocator, String name) {
        super(By.xpath(xPathLocator), name + " component");
    }


}
