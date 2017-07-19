package com.haku.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.haku.model.Account;
import com.haku.service.AccountService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "accountController")
@SessionScoped
public class AccountController {
	private Account account = new Account();
	private AccountService accountService = new AccountService();
	private String register;
	private String hasError;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String login() {
		if (register.equals("true")) {
			boolean check = accountService.registerEmail(account);
			if (check)
				hasError = "Success";
			else {
				System.out.println("log");
				hasError = "account already exists";
			}
		} else {
			if (accountService.authenticAccount(account)) {
				return "home";
			} else {
				hasError = "Incorrect username or password";
			}
		}
		return "login";
	}

	public String logout() {
		hasError = "";
		return "login";
	}

	public String getHasError() {
		return hasError;
	}

	public void setHasError(String hasError) {
		this.hasError = hasError;
	}

}
