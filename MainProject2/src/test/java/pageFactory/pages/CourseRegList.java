package pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseRegList {
	
	/**
     * All WebElements are identified by @FindBy annotation
     */
    WebDriver driver;
    
    @FindBy(css="#myDiv > li:nth-child(4) > a")
    private WebElement courseRegBtn;
    
    @FindBy(css="button.bg-gradient-primary")
    private WebElement dwnldBtn;
    
    @FindBy(css="tbody.ng-star-inserted:nth-child(2) > tr:nth-child(1) > td:nth-child(10) > i")
    private WebElement usrRegDelete;    
    
    @FindBy(css="html.swal2-shown.swal2-height-auto body.loaded.swal2-shown.swal2-height-auto "
    		+ "div.swal2-container.swal2-center.swal2-backdrop-show div.swal2-popup.swal2-modal.swal2-icon-warning.swal2-show "
    		+ "div.swal2-actions button.swal2-confirm.swal2-styled.swal2-default-outline")
    private WebElement deleteConfirm;
    
    //@FindBy(css=".error-message-container > h3:nth-child(1)")
   // private WebElement errorBanner;


 public CourseRegList(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
 
 public void CourseRegBtn() {
	 courseRegBtn.click();
 }
 public void dwnldBtn(){
	 dwnldBtn.click();
 }
public void UserRegDelete() {
	usrRegDelete.click();	
}
public void confirmDelete() {
	deleteConfirm.click();
}
}
