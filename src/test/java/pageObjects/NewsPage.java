package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {
	public WebDriver driver;

		public NewsPage (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	    @FindBy (xpath="//div[@id='title_text']")
	    WebElement title;
	    
	    @FindBy (xpath="//div[@data-automation-id=\"textBox\"]")
	    WebElement content;
	    
	    @FindBy (xpath="//a[@name='be.cognizant']")
		 public WebElement becognizant;
	    
	    
        public String getHeadtitle()
        {
	      return  title.getText();
	
        }
        
        public String  getHeadtitletooltip()
        {
        	return title.getAttribute("title");
	
        }
        
        public String getContent() {
        	return content.getText();
        }        
        
        public void clickbeCognizant()
        {
        	becognizant.click();
        }
        
}
