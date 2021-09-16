package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SBear_ViewAllOrdersPage extends SBear_BasePage{

    @FindBy(xpath = "//tr[2]/td[2]")
    public WebElement newCustomerCell;

}