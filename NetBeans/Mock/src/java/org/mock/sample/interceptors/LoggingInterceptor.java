/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mock.sample.interceptors;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.mock.sample.annotations.Logged;


/**
 *
 * @author behera
 */
@Logged
@Interceptor
public class LoggingInterceptor {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(LoggingInterceptor.class.getName());
    public LoggingInterceptor() {
    }

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext)
            throws Exception {
        LOG.log(Level.INFO, "Entering {1}:{0}() ", new Object[]{invocationContext.getMethod().getName(), 
            invocationContext.getMethod().getDeclaringClass().getName()});

        return invocationContext.proceed();
    }
}
