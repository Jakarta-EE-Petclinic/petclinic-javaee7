package org.woehlke.javaee7.petclinic.services;

import org.woehlke.javaee7.petclinic.dao.VetDao;
import org.woehlke.javaee7.petclinic.entities.Specialty;
import org.woehlke.javaee7.petclinic.entities.Vet;
import org.woehlke.javaee7.petclinic.model.Vets;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 05.01.14
 * Time: 09:27
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@Path("/vets")
public class VetWebservice {

    @EJB
    private VetDao vetDao;

    @GET
    @Produces("application/xml")
    @Path("/xml")
    public Vets getXml(){
        Vets vets = new Vets();
        vets.setVetList(vetDao.getAll());
        return vets;
    }

    @GET
    @Produces("application/json")
    @Path("/json")
    public Vets getJson(){
        Vets vets = new Vets();
        vets.setVetList(vetDao.getAll());
        return vets;
    }

}
