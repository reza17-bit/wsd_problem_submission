package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class BaseTest {

    // Global variables Declaration
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader fr;
    public static FileReader fr1;
    public ExtentSparkReporter spark;
    public ExtentReports extent;
    public ExtentTest logger;
    @BeforeMethod
    public void setUp() throws IOException {

        if(driver==null){
            // Project Location...
            fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
            fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");


            // config.properties Loading....
            prop.load(fr);
            loc.load(fr1);

        }
        // This is for initializing the Firefox Driver, and equalsIgnoreCase allows for case-insensitive comparisons.
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")){

            //Driver download
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            // implicitly wait till 10 second for each actions
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            // Maximize window
            driver.manage().window().maximize();
            // Access link (url)
            driver.get(prop.getProperty("testurl"));

        }
        // Firebox Initialization
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));

        }


}
public void initializeReport(){
    spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/extendSparkReport.html");
    spark.config().setDocumentTitle("Test Automation Report for WSD");
    spark.config().setReportName("Test Automation Execution Report for WSD");
    spark.config().setTheme(Theme.STANDARD);
    spark.config().setTimeStampFormat("EEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    extent = new ExtentReports();
    extent.attachReporter(spark);

}
    public static String captureScreenshot (WebDriver driver) throws IOException{

        String FileSeparator = System.getProperty("file.separator");
        String Extent_report_path = "."+FileSeparator+"reports";
        String ScreenshotPath = Extent_report_path+FileSeparator+"screenshots";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotname = "screenshot"+Math.random()+".png";
        String screenshotpath = ScreenshotPath+FileSeparator+screenshotname;
        FileUtils.copyFile(src, new File(screenshotpath));
        return "."+FileSeparator+"screenshots"+FileSeparator+screenshotname;
    }

    @AfterMethod
    public void tearDown()
    {
        // Browser closing
        driver.close();
        System.out.println("Teardown method is working....");
    }

}
