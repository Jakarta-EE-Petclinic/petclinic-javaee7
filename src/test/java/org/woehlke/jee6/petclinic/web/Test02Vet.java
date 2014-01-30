package org.woehlke.jee6.petclinic.web;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.woehlke.jee6.petclinic.web.pages.EditVetPage;
import org.woehlke.jee6.petclinic.web.pages.HelloPage;
import org.woehlke.jee6.petclinic.web.pages.NewVetPage;
import org.woehlke.jee6.petclinic.web.pages.VetsPage;

import java.net.URL;
import java.util.logging.Logger;

import static org.jboss.arquillian.graphene.Graphene.goTo;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 21.01.14
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class Test02Vet {

    private static Logger log = Logger.getLogger(Test02Vet.class.getName());

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return Deployments.createVetDeployment();
    }

    @Drone
    WebDriver driver;

    @ArquillianResource
    URL deploymentUrl;

    @Page
    private HelloPage helloPage;

    @Page
    private VetsPage vetsPage;

    @Page
    private NewVetPage newVetPage;

    @Page
    private EditVetPage editVetPage;

    @Test
    @InSequence(1)
    @RunAsClient
    public void testOpeningHomePage() {
        goTo(HelloPage.class);
        helloPage.assertTitle();
    }


    @Test
    @InSequence(2)
    @RunAsClient
    public void testOpeningVetPage() {
        goTo(VetsPage.class);
        vetsPage.assertPageIsLoaded();
    }

    @Test
    @InSequence(3)
    @RunAsClient
    public void testNewVetPage() {
        goTo(VetsPage.class);
        vetsPage.assertPageIsLoaded();
        vetsPage.assertPageIsLoaded();
        vetsPage.clickAddNewVet();
        newVetPage.assertPageIsLoaded();
        newVetPage.addNewContent("Thomas","Woehlke");
        vetsPage.assertPageIsLoaded();
        vetsPage.assertNewContentFound("Thomas","Woehlke");
    }

    @Test
    @InSequence(4)
    @RunAsClient
    public void testEditVetPage() {
        goTo(VetsPage.class);
        vetsPage.assertPageIsLoaded();
        vetsPage.clickEditVet();
        editVetPage.assertPageIsLoaded();
        editVetPage.editContent("Willy","Wacker");
        vetsPage.assertPageIsLoaded();
        vetsPage.assertEditedContentFound("Willy","Wacker");
    }

    @Test
    @InSequence(5)
    @RunAsClient
    public void testDeleteVetPage() {
        goTo(VetsPage.class);
        vetsPage.assertPageIsLoaded();
        vetsPage.clickDeleteVet();
        vetsPage.assertPageIsLoaded();
        vetsPage.assertDeletedContentNotFound();
    }
}
