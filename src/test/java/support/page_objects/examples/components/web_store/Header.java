package support.page_objects.examples.components.web_store;

import org.openqa.selenium.By;
import com.ui.web.BaseComponent;
import support.page_objects.webelements.Button;

public class Header extends BaseComponent {
    public Button signInButton = new Button(By.xpath(".//a[@class=\"login\"]"), "Log In button", this);


    public Header(By locator, String name) {
        super(locator, name);
    }


}
