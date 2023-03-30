package support.page_objects.webelements;

import com.ui.web.BaseElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class ModalWindow extends BaseElement {
    static String defaultLocator = "TODO";

    String confirmButtonLocator = String.join(" | ",
            ".//button[normalize-space()=\"OK\"]",
            ".//button[normalize-space()=\"Ok\"]",
            ".//button[normalize-space()=\"Yes\"]",
            ".//button[normalize-space()=\"Save\"]",
            ".//button[normalize-space()=\"Add\"]",
            ".//button[normalize-space()=\"Apply\"]",
            ".//button[normalize-space()=\"Submit\"]",
            ".//button[normalize-space()=\"Update\"]",
            ".//button[normalize-space()=\"Delete\"]",
            ".//button[normalize-space()=\"Upload\"]"
    );

    String rejectButtonLocator = String.join(" | ",
            ".//button[normalize-space()=\"No\"]",
            ".//button[normalize-space()=\"Cancel\"]",
            ".//button[normalize-space()=\"Abort\"]"
    );

    public ModalWindow(By locator, String name, BaseElement parentElement) {
        super(locator, name != null ? name + " Modal" : null, parentElement);
    }

    public ModalWindow(String modalText) {
        super(By.xpath(defaultLocator.replaceAll("modalName", modalText)), "Modal:: " + modalText);
    }

    public BaseElement getConfirmButton() {
        return this.element(By.xpath(confirmButtonLocator));
    }

    public BaseElement getRejectButton() {
        return this.element(By.xpath(rejectButtonLocator));
    }

    public void confirm() {
        this.getConfirmButton().waitTillIsEnabled();
        this.getConfirmButton().click();
    }

    public void reject() {
        this.getRejectButton().waitTillIsEnabled();
        this.getRejectButton().click();
    }

}
