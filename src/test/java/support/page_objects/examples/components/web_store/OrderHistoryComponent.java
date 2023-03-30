package support.page_objects.examples.components.web_store;

import org.openqa.selenium.By;
import com.ui.web.BaseComponent;
import support.page_objects.webelements.SimpleTable;

public class OrderHistoryComponent extends BaseComponent {

    public SimpleTable ordersTable;


    public OrderHistoryComponent(By locator, String name) {
        super(locator, name);
        this.ordersTable = new SimpleTable(By.xpath(".//table[@id=\"order-list\"]"), "Orders table", this);
    }

    @Override
    public void expectToBeDisplayed() {
        super.expectToBeDisplayed();
        this.ordersTable.waitTillIsVisible(10);
        this.ordersTable.expectToBeDisplayed();
    }
}