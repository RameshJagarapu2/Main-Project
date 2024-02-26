package testPack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;

public class BaseClass {
	public static WebDriver driver;
	HomePage hp;
	NewsPage np;
	public static List<String>Titles=new ArrayList<String>();
	public static List<String>AppssAndTools=new ArrayList<String>();

	
	@Parameters({"browser","url"})
	  @BeforeClass
	  public void setup(String browser,String url) {
		  if(browser.equalsIgnoreCase("chrome")) {
		  driver=new ChromeDriver();
		  }
		  else if (browser.equalsIgnoreCase("Edge")){
			  driver=new EdgeDriver();
		  }
		  else  {
			  driver=new FirefoxDriver();
		  }
		  driver.get(url);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}
	
	@Test(priority=1)
	public void userValidation() throws InterruptedException {
		
		try {
			hp.signIn();
			hp.clickNext();
			hp.clickNo();
		}
		catch (Exception e){
			
		}
		
		hp=new HomePage(driver);
		Thread.sleep(7000);
		hp.clickbutton();
		System.out.println(hp.getName());
		System.out.println(hp.getMail());
System.out.println("___________________________________________________________________________________");
	}
	
	@Test(priority=2)
	public void newsTitleValidation() {
		int count=hp.Titles.size();
		System.out.println(count);
		
		for(int i=0;i<count;i++) {
			System.out.println(hp.Titles.get(i).getText());
			}
System.out.println("___________________________________________________________________________________");

		
		for(int i=0;i<count;i++) {
			String tooltip=hp.Titles.get(i).getAttribute("title");
			Titles.add(hp.Titles.get(i).getText());
		if(tooltip.equals(hp.Titles.get(i).getText())) {
		Assert.assertEquals(true ,true);
		System.out.println("Validated Header with Tooltip");
			}
		
		else
			{
				System.out.println(" Header not matched with Tooltip");}
		
			}
System.out.println("___________________________________________________________________________________");
	}
	
	
	@Test(priority=3)
	public void newsValidation() throws InterruptedException {
		for(int i=0;i<hp.Titles.size();i++) {
			
			
			hp.clickNews(i);
			Thread.sleep(5000);
			np=new NewsPage(driver);
			String title=np.getHeadtitle();
			String toolTip=np.getHeadtitletooltip();
			screenShot(String.valueOf(i));
			if(toolTip.equals(title)) {
				System.out.println(i+1+" --> Title Matched with ToolTip");
			}
			else {
				System.out.println("Title not Matched with ToolTip");

			}
			System.out.println( np.getContent());
System.out.println("___________________________________________________________________________________");
			np.clickbeCognizant();
			driver.navigate().refresh();
			
			}
	}
	
	@Test(priority=4)
	public void apps() throws IOException
	{
		 JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("arguments[0].scrollIntoView()",hp.aroundCognizant);
	     for(String s:hp.AppsTools()) {
	     System.out.println(s);
	     AppssAndTools.add(s);
	     }
	     
	     
	     utility.excelOutput(Titles, AppssAndTools);
	     
	}
	
	@Test(priority=5)
	public void pageValidation() {
		String title=driver.getTitle();
		Assert.assertEquals(title.contains("Be.Cognizant"),true);
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void screenShot(String name) {
		File scrFile = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		File screenShotName = new File(System.getProperty("user.dir")+"\\screenshots\\"+name+".png");
		try {
			FileUtils.copyFile(scrFile, screenShotName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
