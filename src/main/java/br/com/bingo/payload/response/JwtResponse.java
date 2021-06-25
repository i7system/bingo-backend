package br.com.bingo.payload.response;

import java.util.List;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String email;
	private String user;

	public JwtResponse(String accessToken, String email, String user) {
		this.token = accessToken;
		this.email = email;
		this.user=user;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


}
