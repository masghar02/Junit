import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

class calTest {
   static ChromeDriver cd;

     @BeforeAll
     public static void DriverInitilialize()
     {
         WebDriverManager.chromedriver().setup();

     }
     @BeforeEach
     public void ChromeInitilialize()
     {
         cd = new ChromeDriver();
         cd.manage().window().maximize();

     }

     @AfterEach
    void teardown() throws InterruptedException
     {
         Thread.sleep(2000);
         cd.quit();
     }
     @Test
   public void Test1Homepage() throws InterruptedException
     {
         cd.get("https://bystored:bystored2020@stage.bystored.com");
         Thread.sleep(2000);
         cd.findElement(By.id("postcode")).sendKeys("BN9");
         Thread.sleep(2000);
         cd.findElement(By.id("get-storage-price-v-35")).click();
         Thread.sleep(5000);
     }
     @Test
   public void Test2Unitsection()  throws InterruptedException
   {
       cd.get("https://bystored:bystored2020@stage.bystored.com/booking");
       Thread.sleep(2000);
       JavascriptExecutor js = (JavascriptExecutor) calTest.cd;
       js.executeScript("window.scrollBy(0,450)");
       cd.findElement(By.xpath("//body/section[@id='section1']/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/div[1]")).click();
       Thread.sleep(3000);
       cd.findElement(By.id("step1-cta-next")).click();
       Thread.sleep(3000);
   }


}