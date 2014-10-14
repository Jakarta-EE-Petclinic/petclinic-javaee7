package org.woehlke.javaee7.petclinic.web;



import org.richfaces.component.SortOrder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by tw on 13.03.14.
 */
@ManagedBean
@SessionScoped
public class VetSortingBean implements Serializable {

    private SortOrder sortOrderFirstName = SortOrder.unsorted;
    private SortOrder sortOrderLastName = SortOrder.unsorted;
    private SortOrder sortOrderSpecialties = SortOrder.unsorted;

    public void setSortOrderToFirstName() {
        if (sortOrderFirstName == SortOrder.ascending) {
            sortOrderFirstName = SortOrder.descending;
        } else {
            sortOrderFirstName = SortOrder.ascending;
        }
        sortOrderLastName = SortOrder.unsorted;
        sortOrderSpecialties = SortOrder.unsorted;
    }

    public void setSortOrderToLastName() {
        sortOrderFirstName = SortOrder.unsorted;
        if (sortOrderLastName == SortOrder.ascending) {
            sortOrderLastName = SortOrder.descending;
        } else {
            sortOrderLastName = SortOrder.ascending;
        }
        sortOrderSpecialties = SortOrder.unsorted;
    }

    public void setSortOrderToSpecialties() {
        sortOrderFirstName = SortOrder.unsorted;
        sortOrderLastName = SortOrder.unsorted;
        if (sortOrderSpecialties == SortOrder.ascending) {
            sortOrderSpecialties = SortOrder.descending;
        } else {
            sortOrderSpecialties = SortOrder.ascending;
        }
    }

    public SortOrder getSortOrderFirstName() {
        return sortOrderFirstName;
    }

    public void setSortOrderFirstName(SortOrder sortOrderFirstName) {
        this.sortOrderFirstName = sortOrderFirstName;
    }

    public SortOrder getSortOrderLastName() {
        return sortOrderLastName;
    }

    public void setSortOrderLastName(SortOrder sortOrderLastName) {
        this.sortOrderLastName = sortOrderLastName;
    }

    public SortOrder getSortOrderSpecialties() {
        return sortOrderSpecialties;
    }

    public void setSortOrderSpecialties(SortOrder sortOrderSpecialties) {
        this.sortOrderSpecialties = sortOrderSpecialties;
    }
}
