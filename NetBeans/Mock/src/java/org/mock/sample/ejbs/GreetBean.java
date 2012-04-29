/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.ejbs;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import org.mock.sample.annotations.Logged;

/**
 *
 * @author behera
 */
@Stateless
@LocalBean
@Named ( value = "greet" )
public class GreetBean {
   private static final Logger LOG = Logger.getLogger(GreetBean.class.getName());
   @Logged
   public String greet( final String greeter ){
       return "Hallo " + greeter + " from EJB";
   }
   @Asynchronous
   public void longRunningAction () {
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        LOG.log(Level.INFO, "longRunningAction complete");
   }
   @PostConstruct
   public void init () {
       LOG.log(Level.INFO, "initializing GreetBeen");
   }
   @Logged
   public String invoke () {
       //LOG.log(Level.INFO, "invoking JSF managed bean method");
       return "invoked";
   }
}
