package core;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Title_Validation_CSV {

	public static void main(String[] args) {
		
		String csvFile = "./src/main/resources/Test.csv";
		BufferedReader br = null;
		String line = null;
		String SplitBy = ";";
		String text_case_id = null;
		String url = null;
		String expected_result = null;
		
		WebDriver driver = new HtmlUnitDriver();

		//Properties properties = new Properties();

		try {
			br = new BufferedReader(new FileReader(csvFile));
		} catch (FileNotFoundException e) {
			System.out.println("No file");//e.printStackTrace();
		} 

		try {
			while ((line = br.readLine()) != null) {

				String[] csv = line.split(SplitBy);

				text_case_id = csv[0];
				url = csv[1];
				expected_result = csv[2];

				driver.get(url);
				driver.manage().timeouts().implicitlyWait(36, TimeUnit.SECONDS);
				String actual_result = driver.getTitle();
				System.out.println("");

		if (expected_result.equals(actual_result)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Expected Result: \t" + expected_result);
			System.out.println("Actual Result: \t\t" + actual_result);
			System.out.println("Test Case Result: \t" + "CONGRATS,YOU PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Expected Result: \t" + expected_result);
			System.out.println("Actual Result: \t" + actual_result);
			System.out.println("Test Case Result: \t" + "SORRY, YOU FAILED");
		} 
			}
        br.close();
			
		} catch (IOException e) {
		System.out.println("No IO"); //	e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}