package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownsPage {

    public DropDownsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "month")
    public WebElement monthDropdown;

}
