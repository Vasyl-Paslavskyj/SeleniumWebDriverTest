package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GmailPage {

    private WebDriver driver;

    @FindBy(className="T-Jo-auh")
    private List<WebElement> messagesCheckboxes;

    @FindBy(xpath="//div[@class='ar9 T-I-J3 J-J5-Ji']")
    private WebElement deleteDiv;

    @FindBy(id="link_undo")
    private WebElement cancelDeleteSpan;

    @FindBy(css="span[class='bofITb']")
    private WebElement confirmationCancelDeleteSpan;

    @FindBy(xpath="//a[contains(@title, 'vasyl87test@gmail.com')]")
    private WebElement verificationPage;

    @FindBy(css="div[aria-checked='true']")
    private List<WebElement> selectedMessagesCheckboxes;

    public GmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getCancelDeleteSpan() {
        return cancelDeleteSpan;
    }

    public String verificationThatPageIsOpened(){
        return verificationPage.getAttribute("title").trim().toString();
    }

    public void selectTreeMessages(){
        List<String> listSubjects = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if(!(messagesCheckboxes.get(i).isSelected())) {
                messagesCheckboxes.get(i).click();
            }
        }
    }

    public int getCountOfSelectedMessages(){
        return selectedMessagesCheckboxes.size();
    }

    public void deleteSelectedMessages(){
        deleteDiv.click();
    }

    public void cancelDeleteMessages(){
        cancelDeleteSpan.click();
    }

    public String verificationThatMessagesWereNotDeleted(){
        return confirmationCancelDeleteSpan.getText().trim();
    }
}