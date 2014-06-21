package com.example.jsfdemo.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1520318172495977648L;

	public String redirectToLogin() {
		return "/login.xhtml?faces-redirect=true";
	}
	
	
	public String toLogin() {
		return "/login.xhtml";
	}
	

	public String redirectToInfo() {
		return "/info.xhtml?faces-redirect=true";
	}
	

	public String toInfo() {
		return "/info.xhtml";
	}
	

	public String redirectToWelcome() {
		return "/home.xhtml?faces-redirect=true";
	}
	
	
	public String toWelcome() {
		return "/home.xhtml";
	}
	
}
