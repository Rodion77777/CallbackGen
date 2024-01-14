package com.employee.CallbackGen;

import com.employee.CallbackGen.business.pages.kyivstar.KyivstarPage;
import com.employee.CallbackGen.business.pages.kyivstar.KyivstarTest;
import com.employee.CallbackGen.business.pages.volia.VoliaPage;
import com.employee.CallbackGen.business.pages.volia.VoliaTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
class CallbackGenApplicationTests {
	public static ChromeOptions options;
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	public static String kyivstarLink = "https://my-kyivstar.com.ua/?gclid=EAIaIQobChMIk6KLiZrj_QIVr0aRBR3vIwVTEAAYASAAEgJj3fD_BwE";

	@BeforeAll
	public static void setupAll(){
		WebDriverManager.chromedriver().config().setChromeDriverVersion("120.0.6099.130");
		WebDriverManager
				.chromedriver()
				.clearDriverCache()
				//.driverVersion("chromedriver_120.0.6099.130")
				.setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@AfterAll
	public static void tearDown(){
		if (driver != null)	driver.close();

		options = null;
		driver = null;
	}

	@Test
	void kyivstarPageTest(){
		new KyivstarTest(new KyivstarPage(driver, wait))
				.start("Запоріжжя", "987437125");
	}

	@Test
	void voliaPageTest(){
		new VoliaTest(new VoliaPage(driver, wait))
				.start("Дмитрий", "987437125");
	}
}