package data_driven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TA3 {
    public WebDriver edriver;
    public WebDriverWait ewait;
    @FindBy(how = How.XPATH, using = "//li/a[text()='Log in']")
    public WebElement login;
    @FindBy(how = How.XPATH, using = "//input[@id='loginusername']")
    public WebElement userName;
    @FindBy(how = How.XPATH, using = "//input[@id='loginpassword']")
    public WebElement passWord;
    @FindBy(how = How.XPATH, using = "//button[text()='Log in']")
    public WebElement submitLogin;
    @FindBy(how = How.XPATH, using = "//a[@id='nameofuser']")
    public WebElement afterLogin;
    @FindBy(how = How.XPATH, using = "//a[text()='Samsung galaxy s6']")
    public WebElement samsungLink;
    @FindBy(how = How.XPATH, using = "//h2[@class='name']")
    public WebElement samsung;
    @FindBy(how = How.XPATH, using = "//h3[@class='price-container']")
    public WebElement price;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane fade active in']")
    public WebElement desc;
    @FindBy(how = How.XPATH, using = "//a[text()='Add to cart']")
    public WebElement addCart;
    @FindBy(how = How.XPATH, using = "//li/a[text()='Cart']")
    public WebElement cart;
    @FindBy(how = How.XPATH, using = "//td[text()='Samsung galaxy s6']")
    public WebElement infosamsung;
    @FindBy(how = How.XPATH, using = "//td[text()='360']")
    public WebElement pricesamsung;
    @FindBy(how = How.XPATH, using = "//td/a[text()='Delete']")
    public WebElement delete;
    @FindBy(how = How.XPATH, using = "//li/a[text()='Home ']")
    public WebElement home;
    @FindBy(how = How.XPATH, using = "//a[text()='Nokia lumia 1520']")
    public WebElement nokia;
    @FindBy(how = How.XPATH, using = "//button[text()='Place Order']")
    public WebElement placeorder;
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    public WebElement placeName;
    @FindBy(how = How.XPATH, using = "//input[@id='country']")
    public WebElement country;
    @FindBy(how = How.XPATH, using = "//div[@id='orderModal']//button[text()='Close']")
    public WebElement close;
    @FindBy(how = How.XPATH, using = "//li/a[text()='Log out']")
    public WebElement logout;

    public TA3(){
        edriver = new ChromeDriver();
        PageFactory.initElements(edriver, this);
        ewait = new WebDriverWait(edriver, Duration.ofSeconds(5));
    }
    //Dùng @Before biểu hiện cho hàm này sẽ đuọc chạy trước
    @Before
    public void setUp(){
        edriver.manage().window().maximize();
        edriver.get("https://www.demoblaze.com/#");

    }
    @Test
    public void test() throws Exception {
        waitUntilElementVisible(login);
        login.click();
        waitUntilElementVisible(userName);
        userName.sendKeys("admin");
        waitUntilElementVisible(passWord);
        passWord.sendKeys("admin");
        waitUntilElementVisible(submitLogin);
        submitLogin.click();
        waitUntilElementVisible(afterLogin);
        samsungLink.click();
        text(samsung);
        text(price);
        text(desc);
        waitUntilElementVisible(addCart);
        addCart.click();
        ewait.until(ExpectedConditions.alertIsPresent());
        Alert alert = edriver.switchTo().alert();
        alert.accept();
        waitUntilElementVisible(cart);
        cart.click();
        text(infosamsung);
        text(pricesamsung);
        waitUntilElementVisible(delete);
        delete.click();
        waitUntilElementVisible(home);
        home.click();
        waitUntilElementVisible(nokia);
        nokia.click();
        waitUntilElementVisible(addCart);
        addCart.click();
        ewait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        waitUntilElementVisible(cart);
        cart.click();
        waitUntilElementVisible(placeorder);
        placeorder.click();
        waitUntilElementVisible(placeName);
        placeName.sendKeys("Duy");
        waitUntilElementVisible(country);
        country.sendKeys("Việt Nam");
        waitUntilElementVisible(close);
        close.click();
        waitUntilElementVisible(logout);
        logout.click();








    }
    @After
    public void tearDown() throws InterruptedException {
    }

    public void waitUntilElementVisible(WebElement element){
        int tryTimes = 0;
        while (tryTimes < 2){
            try {
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch (StaleElementReferenceException se){
                tryTimes ++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }

    public void waitUntilElementVisible(String path) throws Exception{
        int tryTimes = 0;
        while (tryTimes < 2){
            try {
                WebElement element = edriver.findElement(By.xpath(path));
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch (StaleElementReferenceException se){
                tryTimes ++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }
    public void text (WebElement element) throws Exception {
        waitUntilElementVisible(element);
        System.out.println(element.getText());
    }
}
