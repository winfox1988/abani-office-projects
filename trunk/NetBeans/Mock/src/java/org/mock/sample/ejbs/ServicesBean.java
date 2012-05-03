/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.ejbs;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author abani
 */
@Stateless
@LocalBean
public class ServicesBean {

    private static final Logger LOG = Logger.getLogger(ServicesBean.class.getName());
    @Asynchronous
    public void sendEmailAsync(final String recepient) {
        //perform all activities related to
        //the mailing actvity
        LOG.info("strat of sendEmailAsync");
        /*
        below code snippet is to show case
        a long running process. Don't use
        it in real time 
        */
        try {
            Thread.sleep(4000l);
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        LOG.info("end of sendEmailAsync");
    }
    public void sendEmail(final String recepient) {
        //perform all activities related to
        //the mailing actvity
        LOG.info("strat of sendEmail");
        /*
        below code snippet is to show case
        a long running process. Don't use
        it in real time 
        */
        try {
            Thread.sleep(4000l);
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        LOG.info("end of sendEmail");
    }
    @Asynchronous
    public Future<Integer> executeComputationAsync(final String employeeid) {
        LOG.info("strat of executeComputationAsync");
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        LOG.info("end of executeComputationAsync");
        return new AsyncResult<Integer>(100);
    }

    public int executeComputation(final String employeeid) {
        LOG.info("strat of executeComputation");
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        LOG.info("end of executeComputation");
        
        return 100;
    }
}
