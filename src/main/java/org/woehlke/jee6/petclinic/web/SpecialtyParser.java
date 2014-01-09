package org.woehlke.jee6.petclinic.web;

import org.woehlke.jee6.petclinic.dao.SpecialtyDao;
import org.woehlke.jee6.petclinic.entities.Specialty;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 04.01.14
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ApplicationScoped
public class SpecialtyParser {

    @EJB
    private SpecialtyDao specialtyDao;

    public synchronized List<Specialty> getSpecialtyList() {
        return specialtyDao.getAll();
    }
}
