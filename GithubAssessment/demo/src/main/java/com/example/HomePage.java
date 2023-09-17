package com.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
        
    WebDriver driver;

    @FindBy(css =  "[placeholder='enter github user name']")
    WebElement githubusername;
    
    @FindBy(partialLinkText = "Follow")
     WebElement follow;

    public HomePage(WebDriver driver){
        this.driver = driver;
    PageFactory.initElements(driver, this);
    }
             
    public void searchUsername(String strSearch){
        githubusername.sendKeys(strSearch);
     }
   
    public void followButton(){
        follow.click();
    }

    public void enterKey(){
        githubusername.sendKeys(Keys.ENTER);
    }

    public void clearSearchbox(){
        githubusername.clear();
    }



    
}