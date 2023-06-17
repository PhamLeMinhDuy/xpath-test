import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TA2 {
    static ChromeDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public static void main(String[] args) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/#");
        //Login
        click("//li/a[text()='Log in']");
        sendData("//input[@id='loginusername']", "admin");
        sendData("//input[@id='loginpassword']", "admin");
        click("//button[text()='Log in']");

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[@id='nameofuser']"), "Welcome admin"));
        // Samsung galaxy s6
        click("//a[text()='Samsung galaxy s6']");
        text("//h2[@class='name']");
        text("//h3[@class='price-container']");
        text("//div[@class='tab-pane fade active in']");
        // Add to cart
        click("//a[text()='Add to cart']");
        // Bỏ qua alert
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        // Click vào cart
        click("//li/a[text()='Cart']");
        text("//td[text()='Samsung galaxy s6']");
        text("//td[text()='360']");
        // Delete
        click("//td/a[text()='Delete']");
        //Home
        click("//li/a[text()='Home ']");
        //Nokia Lumia 1520
        click("//a[text()='Nokia lumia 1520']");
        click("//a[text()='Add to cart']");
        wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        // Click vào cart
        click("//li/a[text()='Cart']");
        // Place order
        click("//button[text()='Place Order']");
        sendData("//input[@id='name']", "admin");
        sendData("//input[@id='country']", "Việt Nam");
        click("//div[@id='orderModal']//button[text()='Close']");
        //Logout
        click("//li/a[text()='Log out']");
    }
    public static void click(String xpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement  element= driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    public static void text(String xpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement  element= driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println(element.getText());
    }
    public static void sendData(String xpath, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        WebElement  element= driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
}
