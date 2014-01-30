package org.woehlke.jee6.petclinic.web;

import org.woehlke.jee6.petclinic.dao.SpecialtyDao;
import org.woehlke.jee6.petclinic.entities.Specialty;

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
 * User: tw
 * Date: 04.01.14
 * Time: 12:00
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class SpecialtyController implements Serializable {

    @EJB
    private SpecialtyDao specialtyDao;

    private Specialty specialty;

    private FacesContext facesContext;

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Specialty> getSpecialties(){
        return specialtyDao.getAll();
    }

    public String getNewSpecialtyForm(){
        specialty = new Specialty();
        return "newSpecialty.jsf";
    }

    public String saveNewSpecialty(){
        specialtyDao.addNew(this.specialty);
        return "specialties.jsf";
    }

    public String getEditForm(long id){
        this.specialty = specialtyDao.findById(id);
        return "editSpecialty.jsf";
    }

    public String saveEditedSpecialty(){
        specialtyDao.update(this.specialty);
        return "specialties.jsf";
    }

    public String delete(long id){
        try {
            specialtyDao.delete(id);
        } catch (EJBTransactionRolledbackException e) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage("cannot delete, object still in use"));
        }
        return "specialties.jsf";
    }
}
