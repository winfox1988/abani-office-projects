/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.resty.samples.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abani
 */
@XmlRootElement
public class Employee implements Serializable {
    private long eid;
    private String firstName;

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Employee(long eid, String name) {
        this.eid = eid;
        this.firstName = name;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + eid + ", name=" + firstName + '}';
    }
    
}
