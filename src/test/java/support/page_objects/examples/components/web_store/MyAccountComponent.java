package support.page_objects.examples.components.web_store;


import org.openqa.selenium.By;
import com.ui.web.BaseComponent;
import support.page_objects.webelements.Button;

public class MyAccountComponent extends BaseComponent {

    public Button ordersBtn = new Button(By.xpath(".//a[@title=\"Orders\"]"), "Orders", this);
    public Button creditBtn  = new Button(By.xpath(".//a[@title=\"Credit slips\"]"), "Credit", this);
    public Button addressesBtn = new Button(By.xpath(".//a[@title=\"Addresses\"]"), "Addresses", this);
    public Button infoBtn  = new Button(By.xpath(".//a[@title=\"Information\"]"), "Information", this);
    public Button wishlistBtn  = new Button(By.xpath(".//a[@title=\"My wishlists\"]"), "My wishlists", this);


    public MyAccountComponent(By locator, String name) {
        super(locator, name);
    }


}