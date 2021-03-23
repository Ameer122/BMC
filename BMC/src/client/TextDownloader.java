package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TextDownloader implements Runnable{
	HttpURLConnection connection = null;
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader reader;
	String myText = "";
	String line;
	URL tempUrl;
	int statusCode;
	protected String doInBackground(URL... url)
	{
		tempUrl = url[0];
		run(); // We switched Threads here since we don't know when the connection ends with the web service, so we don't keep our main thread busy downloading or uploading data to web service.
	return myText;
	}
	@Override
	public void run() {
		try
		{
			connection = (HttpURLConnection) tempUrl.openConnection();//connects to the server
			statusCode = connection.getResponseCode(); // 404 for example
			if(statusCode == HttpURLConnection.HTTP_OK)
			{
				is = connection.getInputStream();
				isr = new InputStreamReader(is);
				
				
				reader = new BufferedReader((isr));
				myText = "";
				line = reader.readLine();
				
				while(line !=null)
				{
					myText += line;
					line = reader.readLine();
				}
				
			}
			else
			{
				System.out.println("Failed to connect to server");
			}
			//OK - 200
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
