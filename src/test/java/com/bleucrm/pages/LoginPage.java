package com.bleucrm.pages;

import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.ConfigurationReader;
import com.bleucrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement username;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement logInButton;


    public void login2(String userType){
        switch (userType){
            case "help desk user":
                username.sendKeys(ConfigurationReader.get("helpDeskUsername"));
                password.sendKeys(ConfigurationReader.get("helpDeskPassword"));
                logInButton.click();
                break;
            case "human resource user":
                username.sendKeys(ConfigurationReader.get("humanResourceUsername"));
                password.sendKeys(ConfigurationReader.get("humanResourcePassword"));
                logInButton.click();
                break;
            case "marketing user":
                username.sendKeys(ConfigurationReader.get("marketingUsername"));
                password.sendKeys(ConfigurationReader.get("marketingPassword"));
                logInButton.click();
                break;
        }
    }

}