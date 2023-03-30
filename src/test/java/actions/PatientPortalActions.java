package actions;

import com.ui.managers.WebDriverFactory;
import support.context.TestContext;
import support.page_objects.pages.auth.AuthPage;
import support.page_objects.pages.auth.LoginPage;
import support.page_objects.pages.auth.VerifyPage;
import support.page_objects.webelements.Button;
import support.page_objects.webelements.TextInput;
import support.ui_dto.User;

public class PatientPortalActions {
   private final TestContext context;
    public PatientPortalActions(TestContext context){
        this.context = context;}
    public void login(User user){
        AuthPage authPage = context.getPageObjectManager().get(AuthPage.class);
        authPage.navigate();
        authPage.socialAuthLogin.loginWithPasswordButton.click();

        LoginPage loginPage = context.getPageObjectManager().get(LoginPage.class);
        loginPage.navigate();
        loginPage.loginAuth.emailFormPart.emailInput.appendKeys(user.getUsername());
        loginPage.loginAuth.passwordFormPart.passwordInput.appendKeys(user.getPassword());
        loginPage.loginAuth.loginButton.click();
        loginPage.loginAuth.loginButton.waitTillIsGone();

        VerifyPage verifyPage = context.getPageObjectManager().get(VerifyPage.class);
        verifyPage.authVerify.emailCheckRadio.click();
//        verifyPage.authVerify.
    }

    public void googleAuth(User user){
        WebDriverFactory.getWebDriver().get("https://accounts.google.com/InteractiveLogin/signinchooser");
        TextInput input = new TextInput("//input[@type='email']","inputUsername", null);
        input.appendKeys(user.getUsername());
        new Button("(//button)[3]","nextButton", null).click();
        input.waitTillIsGone(5);
        input = new TextInput("//input[@type='password']","inputPassword", null);
        input.appendKeys(user.getPassword());
        new Button("(//button)[2]","nextButton", null).click();
        input.waitTillIsGone(5);
        WebDriverFactory.getWebDriver().get("https://mail.google.com/mail");

    }
}
