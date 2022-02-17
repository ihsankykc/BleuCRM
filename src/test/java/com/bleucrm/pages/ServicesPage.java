package com.bleucrm.pages;

import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ServicesPage extends BasePage {
    @FindBy(xpath = "//div[@id='idea-posts-content']//div[@class='idea-owner']")
    private List<WebElement> dateOfPost;

    @FindBy(xpath = "//div[@id='idea-posts-content']/div")
    public List<WebElement> ideas;

    @FindBy(xpath = "//span[contains(@id,'result')]")
    public List<WebElement> ratingResults;

    @FindBy(xpath = "//a[contains(@id,'plus')]")
    public List<WebElement> positiveRatingButton;

    @FindBy(xpath = "//a[contains(@id,'minus')]")
    public List<WebElement> negativeRatingButton;

    @FindBy(xpath = "//a[.='date added']")
    public WebElement dateAddedButton;

    @FindBy(xpath = "//div[starts-with(@id,'blog-post-')]")
    public WebElement newIdea;

    @FindBy(xpath = "//a[@href='/services/idea/edit/new/']")
    public WebElement createNewIdeaBtn;


    @FindBy(id = "POST_TITLE")
    public WebElement title;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement ideaDescription;

    @FindBy(xpath = "(//iframe)[2]")
    public WebElement ideaDescriptionFrame;

    @FindBy(xpath = "//input[@name='TAGS']")
    public WebElement tags;

    @FindBy(xpath = "//select[@name='UF_CATEGORY_CODE']")
    public WebElement categoryDropdown;

    @FindBy(xpath = "//a/span[.='Suggest New Idea!']")
    public WebElement suggestNewIdea;

    @FindBy(xpath = "//span[@id='pagetitle']")
    public WebElement pageTitle;

    @FindBy(xpath = "//div[starts-with(@class, 'blog-error')]")
    public List<WebElement> errorMessage;


    private List<String> getTextOfThePost(){
        List<String> dates = new ArrayList<>();
        for (WebElement element : dateOfPost) {
            dates.add(element.getText());
        } return dates;
    }

    public void servicesPageModules(String module){
        String xpath="//span[@class='main-buttons-item-text-title'][.='"+module+"']";
        Driver.get().findElement(By.xpath(xpath)).click();
        BrowserUtils.waitFor(1);
    }

    public void setTitle(String str){
        title.clear();
        title.sendKeys(str);
    }
    public void setIdeaDescription(String string){
        Driver.get().switchTo().frame(ideaDescriptionFrame);
        ideaDescription.sendKeys(string);
        Driver.get().switchTo().parentFrame();
    }

    public void setTags(String string){
        tags.clear();
        tags.sendKeys(string);
    }

    public void setCategory(String str){


        Select select=new Select(categoryDropdown);
        select.selectByVisibleText(str);
    }

    public void createNewIdea(){
        BrowserUtils.clickWithJS(createNewIdeaBtn);
        BrowserUtils.waitFor(1);
    }

    public WebElement getFirstIdea(){
        WebElement firstIdea=ideas.get(0);
        return firstIdea;
    }

    public String getFirstMessageRating(){
        WebElement element=ratingResults.get(0);
        String rating=element.getText();
        return rating;
    }

    public void clickLikeButton(){
        if(!positiveRatingButton.get(0).isSelected()){
        WebElement element=positiveRatingButton.get(0);
        element.click();
        }
    }
    public void unClickLikeButton(){
        if(positiveRatingButton.get(0).isSelected()){
            WebElement element=positiveRatingButton.get(0);
            element.click();
        }
    }

    public void clickDislikeButton(){
        if(!negativeRatingButton.get(0).isSelected()) {
            WebElement element = negativeRatingButton.get(0);
            element.click();
        }
    }

    public void unClickDislikeButton(){
        if(negativeRatingButton.get(0).isSelected()){
            WebElement element=negativeRatingButton.get(0);
            element.click();
        }
    }

    public List<String> getIdeasText(){
        List<String>ideasText=new ArrayList<>();
        for (WebElement idea : ideas) {
            ideasText.add(idea.getText());
        }
        return ideasText;
    }


}
