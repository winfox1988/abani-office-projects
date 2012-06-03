/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.services.ws;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author behera
 */
@WebService(serviceName = "GreetService")
public class GreetService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "helloSlow")
    public String helloSlow(@WebParam(name = "name") String txt) {
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException ex) {
            Logger.getLogger(GreetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Hello " + txt + " !";
    }
}
