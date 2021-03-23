package com.bmc.BMCServer;

import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Email")
public class EmailController {
	@GetMapping("SendMsg")
	public String SendMsg(@RequestParam String from, @RequestParam String to, @RequestParam String body)
	{
		boolean flag = false;
		if(isValid(to) && isValid(from))
		{
			EmailVendor emailVendor = new EmailVendor();
			
			if(to.contains("@gmail.com"))
			{
				emailVendor.setEmail_postfix("@gmail.com");
				emailVendor.setPassword("admin");
				emailVendor.setUser_name("admin");
				emailVendor.setServer_address("smtp.gmail.com");
				flag = true;
			}
			else if(to.contains("@yahoo.com"))
			{
				emailVendor.setEmail_postfix("@yahoo.com");
				emailVendor.setPassword("admin");
				emailVendor.setUser_name("admin");
				emailVendor.setServer_address("smtp.yahoo.com");
				flag = true;
			}
			else if(to.contains("@walla.co.il"))
			{
				emailVendor.setEmail_postfix("@walla.co.il");
				emailVendor.setPassword("admin");
				emailVendor.setUser_name("admin");
				emailVendor.setServer_address("smtp.walla.co.il");
				flag = true;
			}
			
	if(flag)
	{
		body = body.replaceAll("_"," ");
		Email email = new Email(to,from,body);
		System.out.println("Message has been sent To: " + email.getTo() + " From: " + email.getFrom() + " Body: " + email.getBody());
		System.out.println("vendors server information : ");
		System.out.println("Email Postfix : " + emailVendor.getEmail_postfix());
		System.out.println("Server address : " + emailVendor.getServer_address());
		return "Message has been sent successfully!";
	}
	else
	{
		System.out.println("Server Adress that has been entered by" + from + " is not available!");
		return "Server Adress that has been entered is not available";
	}
			
		}
	System.out.println("Invalid attempt to send a message from : " + from);
	return "Invalid Emails has been detected";
	}
	
	public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";                    
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
}
