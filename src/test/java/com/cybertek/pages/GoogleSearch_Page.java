package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearch_Page {

    public GoogleSearch_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "q")
    public WebElement searchBar;

    //Instead of using findElements method, we can directly use @FindBy
    // and if locator returns more than 1 web element we can store it in
    // List of WebElements
    @FindBy(xpath = "//a[@class='pHiOh']")
    public List<WebElement> footerLinks;

}