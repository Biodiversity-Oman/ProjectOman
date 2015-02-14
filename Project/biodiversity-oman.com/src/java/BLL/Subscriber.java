/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author lennyasus
 */
public class Subscriber {
	
	private String subscriberName;
	private String email;

	/**
	 * @return the name
	 */
	public String getSubscriberName() {
		return subscriberName;
	}

	/**
	 * @param subscriberName the name to set
	 */
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
