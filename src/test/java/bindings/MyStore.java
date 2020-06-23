package bindings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class MyStore {

    WebDriver driver;

    public MyStore(){
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path +"/resources/chromedriver.exe");
    }

    String productName = "";
    String productPrice = "";
    String productNameSummer = "";
    String productPriceSummer = "";

    Map<String, String> productSummaryInfo = new HashMap<String, String>();

    @Given("^MyStore uygulamasina giris yapilir$")
    public void open_the_Chrome_and_launch_the_application() throws Throwable
    {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }

    @When("^Sign in butonuna tiklanir$")
    public void click_sign_in() throws Throwable
    {
        WebElement btnSignIn = driver.findElement(By.className("login"));
        btnSignIn.click();
        Boolean isSignInSuccessful = driver.getCurrentUrl().endsWith("authentication&back=my-account");
        assertTrue(isSignInSuccessful);
    }

    @Then("^Email adres alanina '(.*)' degeri girilir$")
    public void enter_create_email(String email) throws Throwable
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        WebElement txtEmail = driver.findElement(By.id("email_create"));
        txtEmail.sendKeys(email);
    }

    @Then("^Create an account butonuna tiklanir$")
    public void click_create_an_account() throws Throwable
    {
        WebElement btnCreateAccount = driver.findElement(By.id("SubmitCreate"));
        btnCreateAccount.click();
        //assertTrue(driver.getCurrentUrl().endsWith("account-creation"));
    }

    @Then("^Title olarak Mrs secilir$")
    public void click_mrs_gender() throws Throwable
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
        WebElement chkMrs = driver.findElement(By.id("id_gender2"));
        chkMrs.click();
    }

    @Then("^First name alanina '(.*)' yazilir$")
    public void set_customer_first_name(String customerFirstName) throws Throwable
    {
        WebElement txtCustomerFirstName = driver.findElement(By.id("customer_firstname"));
        txtCustomerFirstName.sendKeys(customerFirstName);
    }

    @Then("^Last name alanina '(.*)' yazilir$")
    public void set_customer_last_name(String customerLastName) throws Throwable
    {
        WebElement txtCustomerLastName = driver.findElement(By.id("customer_lastname"));
        txtCustomerLastName.sendKeys(customerLastName);
    }

    @Then("^Password alanina '(.*)' yazilir$")
    public void set_password(String password) throws Throwable
    {
        WebElement txtPassword = driver.findElement(By.id("passwd"));
        txtPassword.sendKeys(password);
    }

    @Then("^Days alani '(.*)' secilir$")
    public void set_day(String day) throws Throwable
    {
        WebElement cboDays = driver.findElement(By.id("days"));
        Select days = new Select(cboDays);
        days.selectByValue(day);
    }

    @Then("^Months alani '(.*)' ay secilir$")
    public void set_months(String month) throws Throwable
    {
        WebElement cboMonths = driver.findElement(By.id("months"));
        Select months = new Select(cboMonths);
        months.selectByValue(month);
    }

    @Then("^Years alani '(.*)' secilir$")
    public void set_years(String year) throws Throwable
    {
        WebElement cboYears = driver.findElement(By.id("years"));
        Select years = new Select(cboYears);
        years.selectByValue(year);
    }

    @Then("^Your adress alanindaki first name alanina '(.*)' yazilir$")
    public void set_first_name_for_adress(String firstName) throws Throwable
    {
        WebElement txtFirstNameForAdress = driver.findElement(By.id("firstname"));
        txtFirstNameForAdress.clear();
        txtFirstNameForAdress.sendKeys(firstName);
    }

    @Then("^Your adress alanindaki last name alanina '(.*)' yazilir$")
    public void set_last_name_for_adress(String lastName) throws Throwable
    {
        WebElement txtLastNameForAdress = driver.findElement(By.id("lastname"));
        txtLastNameForAdress.clear();
        txtLastNameForAdress.sendKeys(lastName);
    }

    @Then("^Company alanina '(.*)' yazilir$")
    public void set_company(String company) throws Throwable
    {
        WebElement txtCompany = driver.findElement(By.id("company"));
        txtCompany.sendKeys(company);
    }

    @Then("^Birinci adres alanina '(.*)' yazilir$")
    public void set_firts_adress(String address) throws Throwable
    {
        WebElement txtFirstAdress = driver.findElement(By.id("address1"));
        txtFirstAdress.sendKeys(address);
    }

    @Then("^İkinci adres alanina '(.*)' yazilir$")
    public void set_second_adress(String address) throws Throwable
    {
        WebElement txtSecondAdress = driver.findElement(By.id("address2"));
        txtSecondAdress.sendKeys(address);
    }

    @Then("^City alanina '(.*)' yazilir$")
    public void set_city(String city) throws Throwable
    {
        WebElement txtCity = driver.findElement(By.id("city"));
        txtCity.sendKeys(city);
    }

    @Then("^State alani '(.*)' secilir$")
    public void set_state(String state) throws Throwable
    {
        WebElement txtState = driver.findElement(By.id("id_state"));
        Select states = new Select(txtState);
        states.selectByVisibleText(state);
    }

    @Then("^Postal Code alanina '(.*)' yazilir$")
    public void set_postal_code(String postCode) throws Throwable
    {
        WebElement txtPostCode = driver.findElement(By.id("postcode"));
        txtPostCode.sendKeys(postCode);
    }

    @Then("^Additional information alanina '(.*)' yazilir$")
    public void set_additional_information(String additionalInformation) throws Throwable
    {
        WebElement txtAdditionalInformation = driver.findElement(By.id("other"));
        txtAdditionalInformation.sendKeys(additionalInformation);
    }

    @Then("^Home phone alanina '(.*)' yazilir$")
    public void set_home_phone(String homePhone) throws Throwable
    {
        WebElement txtPhone = driver.findElement(By.id("phone"));
        txtPhone.sendKeys(homePhone);
    }

    @Then("^Mobile phone alanina '(.*)' yazilir$")
    public void set_mobile_phone(String phoneMobile) throws Throwable
    {
        WebElement txtMobilePhone = driver.findElement(By.id("phone_mobile"));
        txtMobilePhone.sendKeys(phoneMobile);
    }

    @Then("^Adress alias alanina '(.*)' yazilir$")
    public void set_adress_alias(String adressAlias) throws Throwable
    {
        WebElement txtAdressAlias = driver.findElement(By.id("alias"));
        txtAdressAlias.clear();
        txtAdressAlias.sendKeys(adressAlias);
    }

    @Then("^Register butonuna tiklanir$")
    public void click_register() throws Throwable
    {
        WebElement btnSubmitAccount = driver.findElement(By.id("submitAccount"));
        btnSubmitAccount.click();
    }

    @Then("^Anasayfada kullanicinin olustugu dogrulanir$")
    public void check_if_register_is_successful() throws Throwable
    {
        Boolean isRegisterSuccessful = driver.getCurrentUrl().endsWith("controller=my-account");
        assertTrue(isRegisterSuccessful);
    }

    @Then("^Dresses sekmesi uzerine gelinerek Summer Dresses menusu secilir$")
    public void click_summer_dresses() throws Throwable
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")));

        WebElement btnDresses = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));;
        btnDresses.click();

        WebElement btnSummerDresses = driver.findElement(By.xpath("//*[@id='subcategories']/ul/li[3]/div[1]/a"));
        btnSummerDresses.click();

        Boolean isClickSummerDressesSuccessful = driver.getCurrentUrl().endsWith("id_category=11&controller=category");
        assertTrue(isClickSummerDressesSuccessful);
    }

    @Then("^Herhangi bir urun Add to cart butonuna tiklanarak sepete eklenir$")
    public void add_to_cart() throws Throwable
    {
        WebElement btnProduct = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div"));

        WebElement txtProductName = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a"));
        WebElement txtProductPrice = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span[1]"));

        productName = txtProductName.getText();
        productPrice = txtProductPrice.getText();

        productSummaryInfo.put(productName , productPrice);
        WebElement btnInStock = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/span/span"));
        Actions action = new Actions(driver);
        action.moveToElement(btnInStock).perform();
        WebElement btnFirstSelectedProduct = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        btnFirstSelectedProduct.click();
    }

    @Then("^Continue Shopping butonuna tiklanir$")
    public void click_continue_shopping() throws Throwable
    {
        WebElement btnContinueShopping = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")));
        btnContinueShopping.click();
    }

    @Then("^Search kismina '(.*)' yazilir$")
    public void set_query(String query) throws Throwable
    {
        WebElement txtSearcQuery = driver.findElement(By.id("search_query_top"));
        txtSearcQuery.sendKeys(query);
    }

    @Then("^Search butonuna tiklanir$")
    public void click_search() throws Throwable
    {
        WebElement btnSearch = driver.findElement(By.xpath("//*[@id='searchbox']/button"));
        btnSearch.click();
    }

    @Then("^Sonuc sayfasindan herhangi bir urun sepete eklenir$")
    public void add_to_cart_from_search() throws Throwable
    {
        WebElement btnProduct = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div"));

        WebElement txtProductNameSummer = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a"));
        WebElement txtProductPriceSummer = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span[1]"));

        productNameSummer = txtProductNameSummer.getText();
        productPriceSummer = txtProductPriceSummer.getText();

        productSummaryInfo.put(productNameSummer , productPriceSummer);
        WebElement btnInStock = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/span/span"));
        Actions action = new Actions(driver);
        action.moveToElement(btnInStock).perform();
        WebElement btnSelectedProduct = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        btnSelectedProduct.click();
    }

    @Then("^Procees to Check out butonuna tiklanir$")
    public void click_process_check_out() throws Throwable
    {
        WebElement btnProcessCheckOut = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")));
        btnProcessCheckOut.click();
    }

    @Then("^Eklenen urunler dogrulanir$")
    public void check_if_shopping_cart_summary() throws Throwable
    {
        Map<String, String> productInfo = new HashMap<String, String>();

        String cartProductName = null;
        String cartProductPrice = null;
        List<WebElement> favProductList = driver.findElements(By.xpath("//*[@id='cart_summary']/tbody"));

        for (WebElement favProd:favProductList){
            cartProductName  = (favProd.findElement(By.xpath("//td[2]/p/a"))).getText();
            cartProductPrice = (favProd.findElement(By.xpath("//td[4]/span/span[1]"))).getText();
            productInfo.put(cartProductName , cartProductPrice);
        }

        assertEquals(productInfo, productSummaryInfo);
        //assertEquals(cartProductName, productName);

        //assertEquals(cartProductPrice, productPriceSummer);
        //assertEquals(cartProductName, productNameSummer);
    }

    @Then("^Adress sayfasina gecebilmek icin Proceed to checkout butonuna tiklanir$")
    public void click_proceed_to_checkout() throws Throwable
    {
        WebElement btnProceedToCheckOutToAdress = driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span"));
        btnProceedToCheckOutToAdress.click();
    }

    @Then("^Order adress sayfasina gecildigi gorulur$")
    public void page_order_adress_control() throws Throwable
    {
        Boolean isPageOrderAdressOpen = driver.getCurrentUrl().endsWith("controller=order&step=1");
        assertTrue(isPageOrderAdressOpen);
    }

    @Then("^Shipping alanina gecebilmek icin Proceed to checkout butonuna tiklanir$")
    public void click_proceed_to_checkout_to_adress_page() throws Throwable
    {
        WebElement btnProceedToCheckOutToShipping = driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span"));
        btnProceedToCheckOutToShipping.click();
    }

    @Then("^Shipping sayfasina gecildigi gorulur$")
    public void page_order_shipping_control() throws Throwable
    {
        Boolean isPageOrderShippingOpen = driver.getCurrentUrl().endsWith("controller=order");
        assertTrue(isPageOrderShippingOpen);
    }

    @Then("^Kargo secenegi ve hizmet sartlari kabul edilir$")
    public void click_agree_to_terms_of_service() throws Throwable
    {
        WebElement chkAgreeToTermsOfServices = driver.findElement(By.id("cgv"));
        chkAgreeToTermsOfServices.click();
    }

    @Then("^Payment alanina gecebilmek icin Proceed to checkout butonuna tiklanir$")
    public void click_proceed_to_checkout_to_payment_page() throws Throwable
    {
        WebElement btnProceedToCheckoutToPayment = driver.findElement(By.xpath("//*[@id='form']/p/button/span"));
        btnProceedToCheckoutToPayment.click();
    }

    @Then("^Payment sayfasina gecildigi gorulur$")
    public void page_order_payment_control() throws Throwable
    {
        Boolean isPageOrderPaymentOpen = driver.getCurrentUrl().endsWith("controller=order&multi-shipping=");
        assertTrue(isPageOrderPaymentOpen);
    }

    @Then("^Odeme ekraninda herhangi bir odeme yontemi secilerek siparis tamamlanir$")
    public void choose_payment_method() throws Throwable
    {
        WebElement btnBankWire = driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a"));
        btnBankWire.click();
    }

    @Then("^I confirm my order butonuna tiklanir$")
    public void click_confirm_order() throws Throwable
    {
        WebElement btnConfirmOrder = driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span"));
        btnConfirmOrder.click();
    }

    @Then("^Kullanici adinin yazildigi customer account butonuna tiklanir$")
    public void click_customer_account() throws Throwable
    {
        WebElement btnAccount = driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]"));
        btnAccount.click();
    }

    @Then("^Order history and details butonuna tiklanir$")
    public void click_order_history_and_details() throws Throwable
    {
        WebElement btnHistoryAndDetails = driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a/span"));
        btnHistoryAndDetails.click();
    }

    @Then("^Order history and details ekranindan olusturulan siparis kontrol edilir$")
    public void control_order() throws Throwable
    {
        WebElement btnDetails = driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr/td[7]/a[1]/span"));
        btnDetails.click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='order-detail-content']/table/tbody/tr/td[2]/label")));
        WebElement txtProductName = driver.findElement(By.xpath("//*[@id='order-detail-content']/table/tbody/tr/td[2]/label"));
        String productNameText = txtProductName.getText();
        Assert.assertTrue((productNameText.replace(" ","")).contains(productName.replace(" " , "")));
        driver.close();
    }
}