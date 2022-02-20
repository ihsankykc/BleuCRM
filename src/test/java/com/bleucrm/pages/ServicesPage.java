package com.bleucrm.pages;

import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class ServicesPage extends BasePage {
    @FindBy(xpath = "//div[@id='idea-posts-content']//div[@class='idea-owner']")
    public List<WebElement> dateOfPost;

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


    public List<String> getTextOfTheMessages(){
        List<String> dates = new ArrayList<>();
        for (WebElement element : dateOfPost) {
            dates.add(element.getText());
        }
        return dates;
    }

    public List<String> getDatesOfTheMessages(){
        List<String>texts=getTextOfTheMessages();
        List<String>dateStr=new ArrayList<>();
        for (String text : texts) {
            String[] arrOfStr=text.split(".com");
            for (String s : arrOfStr) {
                System.out.println(arrOfStr[1]);
                dateStr.add(arrOfStr[1]);
            }
        }

        return dateStr;
    }

    public void sortByDate() throws ParseException {
        List<Date> listDates =new ArrayList<>();
        List<String>datesAsString=getDatesOfTheMessages();
        SimpleDateFormat dateFormat=new SimpleDateFormat(" MMMM dd, yyyy HH:mma");

        for (String str : datesAsString) {
            listDates.add(dateFormat.parse(str));
        }

        System.out.println(listDates.toString());
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


    public void clickLikeButton(){
        if(getPlusButtonTitleAttribute().equals("Like")){
        WebElement element=positiveRatingButton.get(0);
        element.click();
        }
    }
    public void unClickLikeButton(){
        if(getPlusButtonTitleAttribute().equals("Stop liking this item")){
            WebElement element=positiveRatingButton.get(0);
            element.click();
        }
    }

    public void clickDislikeButton(){
        if(getMinusButtonTitleAttribute().equals("Unlike")) {
            WebElement element = negativeRatingButton.get(0);
            element.click();
        }
    }

    public void unClickDislikeButton(){
        if(getMinusButtonTitleAttribute().equals("Stop liking this item")){
            WebElement element=negativeRatingButton.get(0);
            element.click();
        }
    }

    public String getPlusButtonTitleAttribute(){
        String str=positiveRatingButton.get(0).getAttribute("title");
        return str;
    }

    public String getMinusButtonTitleAttribute(){
        String str=negativeRatingButton.get(0).getAttribute("title");
        return str;
    }


}
