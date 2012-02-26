/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.jsfbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author CHIKI
 */
@ManagedBean ( name = "carousel" )
@SessionScoped
public class CarouselController implements Serializable{
    private List<String> members;

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
    @PostConstruct
    public void initialize (){
        if ( null == members ) {
            System.out.println("initializing members");
            members = new ArrayList<String>(7);
            members.add("abani");
            members.add("chiki");
            members.add("prem");
            members.add("sagar");
            members.add("lisa");
            members.add("badal");
            members.add("tikina");
            members.add("sony");
            members.add("ajit");
            members.add("iti");
        }
    }
}
