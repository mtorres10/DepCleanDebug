import java.io.File;
import java.util.HashMap;
import me.tongfei.progressbar.DelegatingProgressBarConsumer;
import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  static HashMap<String, File> cache = new HashMap<>();
  //Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) throws InterruptedException {
    String log4jConfPath = "/resources/log4j.properties";
    PropertyConfigurator.configure(log4jConfPath);
    //System.out.println("Hello World");
    //System.setProperty("webdriver.chrome.driver", "C:\\temp\\JavaCABuild\\Drivers\\chromedriver.exe");
    //WebDriver driver = new ChromeDriver();

    //String baseUrl = "https://www.google.com/";
    //driver.get(baseUrl);
    //driver.close();
    printLoggerTest();
  }


  static void printLoggerTest() throws InterruptedException {
    final Logger logger = LoggerFactory.getLogger("Test");

    try (ProgressBar pb = new ProgressBarBuilder()
        .setInitialMax(100)
        .setTaskName("log.test")
        .setConsumer(new DelegatingProgressBarConsumer(logger::info, 100))
        .setUpdateIntervalMillis(1)
        .build()) {
      for (Integer i = 0; i < 100; i++) {
        pb.step();
        Thread.sleep(10);
        //logger.info(i.toString());
      }
    }
  }
}
