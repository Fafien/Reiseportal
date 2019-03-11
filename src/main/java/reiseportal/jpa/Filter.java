/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.jpa;

import java.io.Serializable;

/**
 *
 * @author jonas
 */
public class Filter implements Serializable {
    
    private String filterLabel = "";
    private String filterChecked = "";

    public Filter() {
    }

    public String getFilterLabel() {
        return filterLabel;
    }

    public String getFilterChecked() {
        return filterChecked;
    }

    public void setFilterLabel(String filterLabel) {
        this.filterLabel = filterLabel;
    }

    public void setFilterChecked(String filterChecked) {
        this.filterChecked = filterChecked;
    }
}
