package org.woehlke.jee6.petclinic.web;

import org.woehlke.jee6.petclinic.dao.PetTypeDao;
import org.woehlke.jee6.petclinic.entities.PetType;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fert
 * Date: 06.01.14
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class PetTypeController implements Serializable {

    @EJB
    private PetTypeDao petTypeDao;

    private PetType petType;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public List<PetType> getPetTypes(){
        return petTypeDao.getAll();
    }

    public String getNewPetTypeForm(){
        petType = new PetType();
        return "newPetType.jsf";
    }

    public String saveNewPetType(){
        petTypeDao.addNew(this.petType);
        return "petTypes.jsf";
    }

    public String getEditForm(long id){
        this.petType = petTypeDao.findById(id);
        return "editPetType.jsf";
    }

    public String saveEditedPetType(){
        petTypeDao.update(this.petType);
        return "petTypes.jsf";
    }

    public String delete(long id){
        try {
            petTypeDao.delete(id);
        } catch (EJBTransactionRolledbackException e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage("cannot delete, object still in use"));
        }
        return "petTypes.jsf";
    }
}
