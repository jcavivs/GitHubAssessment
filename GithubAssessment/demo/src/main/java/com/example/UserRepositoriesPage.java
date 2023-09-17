package com.example;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRepositoriesPage extends HomePage {

    public UserRepositoriesPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    @FindBy(css = "a[itemprop='name codeRepository']")
    List<WebElement> titlerepositorysize;

    @FindBy(css = "p[itemprop='description']")
    List<WebElement> descriptionsize;

    @FindBy(partialLinkText = "Repositories")
    WebElement repositoriestab;
    
    @FindBy(partialLinkText = "Next")
    WebElement nextpage;

    public void clickNextpage(){
        nextpage.click();
    }

    public void clickrepositoriesTab(){
        repositoriestab.click();
    }

    public int sizeofTitleRepositories(){
        return titlerepositorysize.size();
    }

    public int sizeofDescRepositories(){
        return descriptionsize.size();
    }

}
 
    
