package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		Email email = new Email(); // Creates an empty Object of Email
		Scanner scan = new Scanner(System.in); //Defines a scanner that allows the client to enter his details
		System.out.println("customer Email: ");
    	email.setTo(scan.nextLine()); // Sets ' To ' as to who is the email is supposed to be sent to.
		System.out.println("Your Email: ");
		email.setFrom(scan.nextLine()); //Sets ' From ' as from who the email is.
		System.out.println("Body:");
		email.setBody(scan.nextLine()); //Sets ' Body of the email' 
		String body = email.getBody().replaceAll("\\s","_"); //Replaces spaces in our text with _ so we can pass it as URL
		try {
			URL url = new URL("http://localhost:8080/Email/SendMsg?from="+email.getFrom()+"&to="+email.getTo()+"&body="+body); //Defines a new URL, which is the same one that is being running using our server
			TextDownloader download = new TextDownloader(); //Defines download object from TextDownloaded Class
			String test = download.doInBackground(url); //Receives the message the url returns + runs it.
			System.out.println(test); //Prints the message that has been sent back from the server
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
