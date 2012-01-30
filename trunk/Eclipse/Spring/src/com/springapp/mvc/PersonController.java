/**
 * 
 */
package com.springapp.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprinapp.domains.Persons;

/**
 * @author beheraab 
 *
 */
@Controller
public class PersonController {
	@Autowired MongoOperations mongoOperations;  
	
	@RequestMapping ( value = "/show", method = RequestMethod.GET )
	public ModelAndView showPersons() {
		System.out.println("PersonController.addContact() " + mongoOperations);
		List<Persons> results = mongoOperations.findAll(Persons.class);
		System.out.println("PersonController.addContact() " + results);
		return new ModelAndView("listpersons", "persons", results);
	}
	@RequestMapping ( value = "/delete/{firstname}", method = RequestMethod.GET )
	public String deletePerson(@PathVariable("firstname") String firstname) {
		System.out.println("PersonController.deletePerson() firstname " + firstname);
		Persons pers = new Persons();
		pers.setFirstname(firstname);
		mongoOperations.remove(pers);
		return "redirect:/index.jsp";
	}
}
