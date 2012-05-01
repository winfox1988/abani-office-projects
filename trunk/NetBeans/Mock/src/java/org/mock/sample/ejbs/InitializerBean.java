/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.ejbs;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author behera
 */
@Singleton
@Startup
public class InitializerBean {

    private static final Logger LOG = Logger.getLogger(InitializerBean.class.getName());
    
    @PostConstruct
    public void initialize (){
        //will write some code to initialize some cache
        LOG.log(Level.INFO, "initializing cache");
    }
    
    @PreDestroy
    public void destroy () {
        // Sys out to verify on TomEE
        System.out.println("destroying cache");
        LOG.log(Level.INFO, "destroying cache");
    }
}
