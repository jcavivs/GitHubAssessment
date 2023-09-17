package com.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubUsersSearchTest {
    WebDriver driver;

    HomePage githubhomepage;
    UserDetailsPage userdetails ;
    UserRepositoriesPage repositorytab;
    
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://gh-users-search.netlify.app/");
        
    }
    
    @Test
    public void HomePage() throws InterruptedException{

        githubhomepage = new HomePage(driver);
         
        // Additional Requirements #1

        String[] usernames = {"jcavivs", "qweasdaszxcasdgasdgas","Mahmudalhakim"};
        
        for (String username : usernames) {
            githubhomepage.searchUsername(username);
            pause();
            githubhomepage.enterKey();
            pause();
            githubhomepage.clearSearchbox();
            pause();
        }

        githubhomepage.followButton();
        pause();
     
    }

    @Test
    public void UserDetailsPage() throws InterruptedException{

        pause();

        userdetails = new UserDetailsPage(driver);

        String fname = userdetails.verifyName();
        String userbio = userdetails.userBio();
        String userLoc = userdetails.userLocation();

        Assert.assertTrue(fname.contains(fname));
        Assert.assertTrue(userbio.contains(userbio));
        Assert.assertTrue(userLoc.contains(userLoc));

        System.out.println("Github User Details\nFullname: " + fname + "\nBio: " + userbio + "\nLocation: "+ userLoc);

        }
    
    @Test
    public void UserRepositoriesPage() throws InterruptedException{

        repositorytab = new UserRepositoriesPage(driver);

        repositorytab.clickrepositoriesTab();
        pause();
        
        //Additional Requirement Number 3
        repositorytab.clickNextpage();
        pause();
        repositorytab.clickNextpage();
        pause();

        int reposeele = repositorytab.sizeofTitleRepositories();
        int decrisize = repositorytab.sizeofDescRepositories();
        
        Assert.assertTrue(reposeele != 0);
        Assert.assertTrue(decrisize != 0);

        System.out.println("\nSize of Title: " +reposeele + "\nSize of Title that has description: " + decrisize);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    
    private void pause() throws InterruptedException{
        Thread.sleep(2000);
    }
}