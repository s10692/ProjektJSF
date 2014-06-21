package com.example.jsfdemo.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 7765876811740798583L;

	
	private static final String[] users = {"anna:qazwsx","kate:123456","dariusz:dariusz"};
	
	private String username;
	private String password;
	
	private boolean loggedIn;

	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	/**
	 * Login operation.
	 * @return
	 */
	public String doLogin() {
		
		for (String user: users) {
			String dbUsername = user.split(":")[0];
			String dbPassword = user.split(":")[1];
			
	
			if (dbUsername.equals(username) && dbPassword.equals(password)) {
				loggedIn = true;
				return navigationBean.redirectToWelcome();
			}
		}
		
	    //Login ERRR
		FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
		
		return navigationBean.toLogin();
		
	}
	
	/**
	 * Logout operation.
	 * @return
	 */
	public String doLogout() {
		
		loggedIn = false;
		
		// Wiadomość wylogowania
		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return navigationBean.toLogin();
	}

	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}
	
}
