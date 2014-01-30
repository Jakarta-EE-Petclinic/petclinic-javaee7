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
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
@Location("specialties.jsf")
public class SpecialtiesPage {

    @FindBy(id="specialties")
    private WebElement specialties;

    @FindBy(id="specialtiesForm:addNewSpecialty")
    private WebElement addNewSpecialty;

    @FindBy(id="specialtiesForm:specialtiesTable:0:name")
    private WebElement nameInTable;

    @FindBy(id="specialtiesForm:specialtiesTable:0:edit")
    private WebElement editInTable;

    @FindBy(id="specialtiesForm:specialtiesTable:0:delete")
    private WebElement deleteInTable;

    public void assertPageIsLoaded(){
        Assert.assertTrue(specialties.isDisplayed());
    }

    public void clickAddNewSpecialty(){
        addNewSpecialty.click();
    }

    public void assertNewContentFound(String content) {
        Assert.assertEquals(content, nameInTable.getText());
    }

    public void clickEditSpecialty() {
        editInTable.click();
    }

    public void assertEditedContentFound(String content) {
        Assert.assertEquals(content, nameInTable.getText());
    }

    public void clickDeleteSpecialty() {
        deleteInTable.click();
    }

    public void assertDeletedContentNotFound() {
        boolean isDeleted = false;
        try {
            Assert.assertEquals(null,nameInTable);
        } catch (NoSuchElementException elementException) {
            isDeleted = true;
        }
        Assert.assertTrue(isDeleted);
    }
}
