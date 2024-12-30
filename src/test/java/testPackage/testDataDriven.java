package testPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseDataDriven;

public class testDataDriven extends BaseDataDriven {
    WebDriver driver;

    public testDataDriven(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWithTestData() {
        FileInputStream fi = null;
        XSSFWorkbook wb = null;
        try {
            // Load Excel file
            fi = new FileInputStream("C:\\Users\\user\\Downloads\\test data.xlsx");
            wb = new XSSFWorkbook(fi);
            XSSFSheet sh = wb.getSheet("Sheet1");
            int rowCount = sh.getLastRowNum();

            // Loop through Excel rows
            for (int i = 1; i <= rowCount; i++) {
                String username = sh.getRow(i).getCell(0).getStringCellValue();
                String pass = sh.getRow(i).getCell(1).getStringCellValue();

                // Debug logs
                System.out.println("Username: " + username);
                System.out.println("Password: " + pass);

                // Perform login
                driver.findElement(By.name("email")).clear();
                driver.findElement(By.name("email")).sendKeys(username);
                driver.findElement(By.name("pass")).clear();
                driver.findElement(By.name("pass")).sendKeys(pass);
                driver.findElement(By.name("login")).click();

                // Navigate back to login page
                driver.navigate().to("https://www.facebook.com/");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (wb != null) wb.close();
                if (fi != null) fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
