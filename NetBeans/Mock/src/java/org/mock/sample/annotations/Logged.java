/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.annotations;

import java.lang.annotation.*;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author behera
 */
@Inherited
@InterceptorBinding
@Retention (RetentionPolicy.RUNTIME)
@Target ({ElementType.METHOD, ElementType.TYPE})
public @interface Logged {
    
}
