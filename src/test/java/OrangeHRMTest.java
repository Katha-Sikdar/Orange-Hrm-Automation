import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OrangeHRMTest {
    public static void main(String[] args) throws InterruptedException {
        //Setup WebDriver using WebDriverManager
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open the application
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Step 2: Enter Username and Password
            WebElement username = driver.findElement(By.name("username"));
            WebElement password = driver.findElement(By.name("password"));
            username.sendKeys("Admin");
            password.sendKeys("admin123");

            // Step 3: Click on the Login button
            WebElement loginButton = driver.findElement(By.cssSelector(type="submit"));
            loginButton.click();

            // Step 4: Verify user is logged in successfully
            Thread.sleep(2000); // Wait for login
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("dashboard")) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
                return;  // Stop further execution if login fails
            }

            // Step 5: Click on the Admin tab
            WebElement adminTab = driver.findElement(By.className("oxd-text oxd-text--span oxd-main-menu-item--name"));
            adminTab.click();

            // Step 6: Click on the Add button
            Thread.sleep(2000); // Wait for page load
            WebElement addButton = driver.findElement(By.cssSelector(type="submit"));
            addButton.click();

            // Step 7: Enter information of the user
            WebElement userRole = driver.findElement(By.className("oxd-select-text-input"));
            userRole.sendKeys("Admin"); // Example

            WebElement employeeName = driver.findElement(By.className("oxd-autocomplete-text-input--after"));
            employeeName.sendKeys("John Smith"); // Example

            WebElement usernameField = driver.findElement(By.className("oxd-autocomplete-text-input--after"));
            usernameField.sendKeys("johnsmith2023"); // Example

            WebElement status = driver.findElement(By.className("oxd-select-text-input"));
            status.sendKeys("Enabled");

            WebElement passwordField = driver.findElement(By.id("systemUser_password"));
            passwordField.sendKeys("Password@123");

            WebElement confirmPasswordField = driver.findElement(By.id("systemUser_confirmPassword"));
            confirmPasswordField.sendKeys("Password@123");

            // Step 8: Click on the Save button
            WebElement saveButton = driver.findElement(By.id("btnSave"));
            saveButton.click();

            // Step 9: Verify user is created successfully
            Thread.sleep(2000); // Wait for page load
            WebElement successMessage = driver.findElement(By.cssSelector(type="submit")));
            if (successMessage.isDisplayed()) {
                System.out.println("User created successfully");
            } else {
                System.out.println("user Creation Failed");
            }

        } finally {
            // Close the browser after the test
            driver.quit();
        }
    }
}
