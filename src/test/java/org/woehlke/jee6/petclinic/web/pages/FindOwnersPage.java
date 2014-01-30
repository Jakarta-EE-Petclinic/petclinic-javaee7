package org.woehlke.jee6.petclinic.web.pages;

import org.jboss.arquillian.graphene.page.Location;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 26.01.14
 * Time: 22:12
 * To change this template use File | Settings | File Templates.
 */
@Location("findOwners.jsf")
public class FindOwnersPage {

    @FindBy(id="findOwners")
    private WebElement findOwners;

    @FindBy(id="findOwnersForm:search")
    private WebElement search;

    @FindBy(id="findOwnersForm:getNewOwnerForm")
    private WebElement getNewOwnerForm;

    public void assertPageIsLoaded() {
        Assert.assertTrue(findOwners.isDisplayed());
    }

    public void clickSearch() {
        search.click();
    }

    public void clickNewOwner() {
        getNewOwnerForm.click();
    }
}
