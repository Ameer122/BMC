package com.bmc.BMCServer;

public class EmailVendor {
private String Server_address;
private String User_name;
private String Password;
private String Email_postfix;

public String getServer_address() {
	return Server_address;
}
public void setServer_address(String server_address) {
	Server_address = server_address;
}
public String getUser_name() {
	return User_name;
}
public void setUser_name(String user_name) {
	User_name = user_name;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmail_postfix() {
	return Email_postfix;
}
public void setEmail_postfix(String email_postfix) {
	Email_postfix = email_postfix;
}


}
