package support.page_objects.examples.pages;

import lombok.extern.log4j.Log4j;
import com.ui.web.actions.Wait;
import support.page_objects.pages.BasePage;

@Log4j
public abstract class ContentPage extends BasePage {
//TODO Header, Footer go here


    public ContentPage(String name) {
        super(name);
    }


    @Override
    public void waitPageReady(long timeoutInSeconds) {
        Wait.untilPageLoadComplete(getDriver(), timeoutInSeconds);
        Wait.untilJqueryIsDone(getDriver(), timeoutInSeconds);
    }

    @Override
    public void waitPageReady() {
        Wait.untilPageLoadComplete(getDriver(), MAX_WAIT_TIME);
        Wait.untilJqueryIsDone(getDriver(), MAX_WAIT_TIME);
    }
}
