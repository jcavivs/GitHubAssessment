package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserDetailsPage extends HomePage{
        

    public String fullname,bio,location;

    @FindBy(css =  "span[itemprop=name]")
    WebElement username;

    @FindBy(className = "p-note")
    WebElement userbio;

    @FindBy(className =  "p-label")
    WebElement userlocation;

    public UserDetailsPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public String verifyName(){
        fullname =  username.getText();
        return fullname;
     }

    public String userBio(){
        bio = userbio.getText();
        return bio;
    }

    public String userLocation(){
        bio = userlocation.getText();
        return bio;
    }


     


     
 
    
}