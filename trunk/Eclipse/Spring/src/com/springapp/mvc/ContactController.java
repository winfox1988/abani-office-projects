/**
 * 
 */
package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprinapp.domains.Contact;

/**
 * @author beheraab
 *  
 */
@Controller
public class ContactController {
	@RequestMapping ( value = "/add", method = RequestMethod.GET )
	public ModelAndView addContact() {
		return new ModelAndView("contacts", "command", new Contact());
	}
	
	@RequestMapping ( value = "/insert", method = RequestMethod.POST ) 
	public String insertContact(@ModelAttribute("contact")  Contact contact) {
		System.out.println("ContactController.insertContact() " + contact);
		return "redirect:add";
	}
}
