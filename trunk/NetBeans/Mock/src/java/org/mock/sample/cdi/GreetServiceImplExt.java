/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.cdi;

import javax.enterprise.inject.Alternative;
import org.mock.sample.annotations.ExternalService;

/**
 *
 * @author abani
 */
@Alternative @ExternalService
public class GreetServiceImplExt implements GreetService {

    @Override
    public String greetCDI(String greeter) {
        return "Hallo " + greeter + " from External Service";
    }
    
}
