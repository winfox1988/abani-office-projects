/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.jsfbeans;

import java.io.Serializable;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
//import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author CHIKI
 */
@ManagedBean ( name = "schedule" )
@SessionScoped
public class ScheduleController implements Serializable {
    private ScheduleModel eventModel; 
    //private ScheduleEvent event = new DefaultScheduleEvent();
    public ScheduleController() {  
         eventModel = new DefaultScheduleModel(); 
         eventModel.addEvent(new DefaultScheduleEvent("Ejipura Fest", Calendar.getInstance().getTime() , Calendar.getInstance().getTime()));
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }
}
