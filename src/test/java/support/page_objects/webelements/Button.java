package support.page_objects.webelements;

import com.ui.web.BaseElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class Button extends BaseElement {

    public Button(By locator, String name, BaseElement parentElement) {
        super(locator, name != null ? name + " Button" : null, parentElement);
    }

    public Button(String locator, String name, BaseElement parentElement) {
        super(locator, name != null ? name + " Button" : null, parentElement);
    }

    public void click() {
        super.click();
    }
}