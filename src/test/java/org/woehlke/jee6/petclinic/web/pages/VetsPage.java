package org.woehlke.jee6.petclinic.web.pages;

import org.jboss.arquillian.graphene.page.Location;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 26.01.14
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
@Location("vets.jsf")
public class VetsPage {

    @FindBy(id="veterinarians")
    private WebElement veterinarians;

    @FindBy(id="veterinariansForm:getNewVetForm")
    private WebElement getNewVetForm;

    @FindBy(id="veterinariansForm:veterinariansTable:0:firstName")
    private WebElement firstNameInTable;

    @FindBy(id="veterinariansForm:veterinariansTable:0:lastName")
    private WebElement lastNameInTable;

    @FindBy(id="veterinariansForm:veterinariansTable:0:edit")
    private WebElement editInTable;

    @FindBy(id="veterinariansForm:veterinariansTable:0:delete")
    private WebElement deleteInTable;

    public void assertPageIsLoaded() {
        Assert.assertTrue(veterinarians.isDisplayed());
    }

    public void clickAddNewVet() {
        getNewVetForm.click();
    }

    public void assertNewContentFound(String firstName, String lastName) {
        Assert.assertEquals(firstName,firstNameInTable.getText());
        Assert.assertEquals(lastName,lastNameInTable.getText());
    }

    public void clickEditVet() {
        editInTable.click();
    }

    public void assertEditedContentFound(String firstName, String lastName) {
        Assert.assertEquals(firstName,firstNameInTable.getText());
        Assert.assertEquals(lastName,lastNameInTable.getText());
    }

    public void clickDeleteVet() {
        deleteInTable.click();
    }

    public void assertDeletedContentNotFound() {
        boolean isDeletedFirstName = false;
        try {
            Assert.assertEquals(null,firstNameInTable);
        } catch (NoSuchElementException elementException) {
            isDeletedFirstName = true;
        }
        Assert.assertTrue(isDeletedFirstName);
        boolean isDeletedLastName = false;
        try {
            Assert.assertEquals(null,lastNameInTable);
        } catch (NoSuchElementException elementException) {
            isDeletedLastName = true;
        }
        Assert.assertTrue(isDeletedLastName);
    }
}
