/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.cdi;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import org.mock.sample.annotations.MaxNumber;

/**
 *
 * @author abani
 */
@Named(value = "generator")
@ApplicationScoped
public class Generator implements Serializable{
    private static final long serialVersionUID = -7213673465118041882L;
    private int maxNumber = 100;

    @Produces @MaxNumber int getMaxNumber() {
        return maxNumber * 4;
    }
    
    
    /**
     * Creates a new instance of Generator
     */
    public Generator() {
    }
}
