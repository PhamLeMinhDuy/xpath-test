import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class download {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Thiết lập các tùy chọn tải xuống
        options.setExperimentalOption("prefs", getChromePreferences());

        // Khởi tạo ChromeDriver với ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Mở trang web
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/p/page7.html");

        // Tìm và nhấp vào liên kết "Test File to Download"
        driver.findElement(By.xpath("//a[text()='ZIP file']")).click();

        // Chờ 5 giây để tải xuống hoàn tất
        Thread.sleep(5000);

        // Đóng trình duyệt
        driver.quit();
    }
    private static Object getChromePreferences() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "D:\\HKIII_3\\Automation_testing");
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("safebrowsing.enabled", true);
        return prefs;
    }
}
