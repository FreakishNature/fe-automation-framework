package support.page_objects.webelements;

import com.ui.web.BaseElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class PlainRadioElement extends BaseElement {

    public PlainRadioElement(By locator, String name, BaseElement parentElement) {
        super(locator, name != null ? name + " Plain radio button" : null, parentElement);
    }

    public PlainRadioElement(String xPathLocator, String name, BaseElement parentElement) {
        super(By.xpath(xPathLocator), name != null ? name + " Plain radio button" : null, parentElement);
    }

    public boolean isChecked() {
        return this.element(By.xpath(".//input")).getRawElement().isSelected();
    }

    public String getLabelText() {
        return this.element(By.xpath(".//label")).getText();
    }
}
