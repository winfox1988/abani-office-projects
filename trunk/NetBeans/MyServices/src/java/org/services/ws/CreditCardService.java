/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.services.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.services.domains.CreditCard;

/**
 *
 * @author behera
 */
@WebService(serviceName = "CreditCardService")
public class CreditCardService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "validateCard")
    public boolean validateCard(@WebParam(name = "card") CreditCard creditCard) {
        System.out.println("Credit Card :: " + creditCard);
        return true;
    }
}
