package com.bleucrm.pages;

import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    @FindBy(id = "user-name")
    public WebElement username;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    public void navigateToTab(String tab){
        String path="//*[@title='"+tab+"']";
        Driver.get().findElement(By.xpath(path)).click();
        BrowserUtils.waitFor(2);

    }


}
