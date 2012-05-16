/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.resty.samples.services;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.resty.samples.entities.Employee;


/**
 * REST Web Service
 *
 * @author abani
 */
@Path("generic")

public class EmployeeService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmployeeService
     */
    public EmployeeService() {
    }

    /**
     * Retrieves representation of an instance of org.resty.samples.services.EmployeeService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public List<Employee> getJson() {
        List<Employee> emp = new ArrayList<Employee>(3);
        emp.add(new Employee(5, "abani"));
        emp.add(new Employee(6, "kunal"));
        return emp;
    }

    /**
     * PUT method for updating or creating an instance of EmployeeService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void addEmployee(Employee employee) {
        System.out.println("Employee " + employee);
    }
}
