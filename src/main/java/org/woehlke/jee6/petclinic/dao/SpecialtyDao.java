package org.woehlke.jee6.petclinic.dao;

import org.woehlke.jee6.petclinic.entities.Specialty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 04.01.14
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public interface SpecialtyDao {

    List<Specialty> getAll();

    void delete(long id);

    void addNew(Specialty vet);

    Specialty findById(long id);

    void update(Specialty vet);
}
