package com.espinozajg.jwt.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.sql.DataSourceDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@JsonIgnore
	private String user;

	@JsonIgnore
	private String pass;

	private String token;

	public User() {}

	public User(String user, String pass, String token) {
		super();
		this.user = user;
		this.pass = pass;
		this.token = token;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
