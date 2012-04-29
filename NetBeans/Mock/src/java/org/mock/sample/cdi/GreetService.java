/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.cdi;

import org.mock.sample.annotations.Logged;

/**
 *
 * @author behera
 */
public class GreetService {
    @Logged
    public String greetCDI ( final String greeter ) {
        return "Hallo " + greeter + " from CDI";
    }
}
