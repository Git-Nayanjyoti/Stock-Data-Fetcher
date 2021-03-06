package com.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static JavascriptExecutor js;

	// method for initialising the browser with the url
	public static void setBrowser(String browser, String url) {
		
		if (browser.toLowerCase().equals("chrome")) {
			//for performing the task without launching the browser
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("headless");
			driver = new ChromeDriver(opt);

		} else if (browser.toLowerCase().equals("firefox")) {
			//for performing the task without launching the browser
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("headless");
			driver = new FirefoxDriver(opt);

		} else if (browser.toLowerCase().equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

		} else if (browser.toLowerCase().equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			System.out.println("Browser not found.\n !!Please configure the Browser name.");
		}

		driver.get(url);
		driver.manage().window().maximize();
		
		
	}

}
