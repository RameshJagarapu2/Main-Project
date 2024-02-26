package pageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class HomePage {
	
		public WebDriver driver;
		public HomePage (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@id='i0118']")
		WebElement signIn;
		
		@FindBy(xpath="//input[@id='idSIButton9']")
		WebElement next;
		
		@FindBy(xpath="//div[@data-bind=\\\"css: { 'inline-block': true }, externalCss: { 'button-item': true }\\\"]")
		WebElement no;
		
		
	    @FindBy (xpath="//div[@id='O365_HeaderRightRegion']")
	    WebElement profilebutton;
	    
	    @FindBy (id= "mectrl_currentAccount_primary")
	    public WebElement name;
	    
	    @FindBy (id= "mectrl_currentAccount_secondary")
	    public WebElement mailid;
	    
	    @FindBy (xpath="//a[@id='news_text_title' and @tabindex='-1']")
	    public List <WebElement> Titles;
	    
	     @FindBy(id="title_text")
	     WebElement afterClickHead;
	     
	     public String getAfterClickTitle()
	     {
	    	 return afterClickHead.getText();
	     }
	      
	     
	     
	    @FindBy (xpath="//a[@name='be.cognizant']")
	    public WebElement homePage;
	    
	    
	    @FindBy (id="vpc_WebPart.QuickLinksWebPart.internal.89c5ffca-2ffb-4052-a723-e99c8c9a14ef")
	    WebElement Apps;
	    
	    @FindBy (xpath="//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong")
	    public WebElement aroundCognizant;
	    
	    @FindBy (xpath="//div[contains(@id,'89c5ffca-2ffb-4052-a723-e99c8c9a14ef')]//div[contains(@class,'labelTextWrapper')]")
	    List<WebElement> apps;
	    
	   
	    
	    
	    
	    public void signIn()
	    {
	    	signIn.sendKeys(Keys.RETURN);
	    }
	    
	    public void clickNext()
	    {
	    	next.click();
	    }
	    
	    public void clickNo()
	    {
	    	no.click();
	    }
	    public String getName() {
	    	return name.getText();
	    }
	    
	    public void clickbutton() {
	    	 profilebutton.click();;
	    }
	    
	    public String getMail() {
	    	return mailid.getText();
	    }

	    public List<WebElement> newsTitle()
	    {
	    	
			return Titles;
	    }
	    
	     
	    public void homePage()
	    {
	    	homePage.getText();
	    }
	    
	    
	    public void clickNews(int i) {
	    	Titles.get(i).click();
	    }
	  
	    public String getApps()
	    {
	    	return Apps.getText();
	    }
	    
	    public List<String> AppsTools()
	    {
	    	List<String> app=new ArrayList<String>();
			for(WebElement e:apps)
			{
				app.add(e.getText());
			}
	    	return app;
	    }
	   
}

