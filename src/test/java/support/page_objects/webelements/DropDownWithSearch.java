package support.page_objects.webelements;

import com.ui.web.BaseElement;
import com.ui.web.ElementsList;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class DropDownWithSearch extends BaseElement {

    public TextInput searchInput;
    public ElementsList<BaseElement> options;

    public DropDownWithSearch(By locator, String name, BaseElement parentElement) {
        super(locator, name != null ? name + " Plane DropDown" : null, parentElement);
//        this.searchInput = new TextInput(By.xpath(".//input"), null, this);
        this.options = new ElementsList<BaseElement>(By.xpath(".//*[@*]"), null, this);
    }

    public void expand() {
        this.click();
    }

    public void search(String val) {
        this.searchInput.waitTillIsEnabled();
        this.searchInput.click();
        this.searchInput.sendKeys(val);
    }

    public void select(String val) {
        this.expand();
        this.search(val);
        if (this.options.getCount() > 0) {
            this.options.getByStrictText(val, BaseElement.class, this).click();
        } else {
            throw new Error("Option [" + val + "] is missing");
        }
    }

}
