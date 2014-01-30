package org.woehlke.jee6.petclinic.web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 26.01.14
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class OwnersPage {

    @FindBy(id="owners")
    private WebElement owners;

    @FindBy(id="ownersForm:getNewOwnerForm")
    private WebElement getNewOwnerForm;

    @FindBy(id="ownersForm:ownersTable:0:firstName")
    private WebElement firstName;

    @FindBy(id="ownersForm:ownersTable:0:lastName")
    private WebElement lastName;

    @FindBy(id="ownersForm:ownersTable:0:address")
    private WebElement address;

    @FindBy(id="ownersForm:ownersTable:0:city")
    private WebElement city;

    @FindBy(id="ownersForm:ownersTable:0:telephone")
    private WebElement telephone;

    @FindBy(id="ownersForm:ownersTable:0:showOwner")
    private WebElement showOwner;

    public void assertPageIsLoaded() {
        Assert.assertTrue(owners.isDisplayed());
    }

    public void clickNewOwner() {
        getNewOwnerForm.click();
    }

    public void assertNewContentFound(String firstName,
                                      String lastName,
                                      String address,
                                      String city,
                                      String telephone) {
        Assert.assertEquals(firstName,this.firstName.getText());
        Assert.assertEquals(lastName,this.lastName.getText());
        Assert.assertEquals(address,this.address.getText());
        Assert.assertEquals(city,this.city.getText());
        Assert.assertEquals(telephone,this.telephone.getText());
        Assert.assertTrue(showOwner.isDisplayed());
    }

    public void clickShowOwner() {
        showOwner.click();
    }
}
