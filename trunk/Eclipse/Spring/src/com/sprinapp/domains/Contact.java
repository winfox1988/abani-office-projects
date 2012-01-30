/**
 * 
 */
package com.sprinapp.domains;

import java.io.Serializable;

/**
 * @author beheraab
 *
 */
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstname;
    private String lastname;
    private String email;
    private String telephone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", telephone=" + telephone
				+ "]";
	}
}
