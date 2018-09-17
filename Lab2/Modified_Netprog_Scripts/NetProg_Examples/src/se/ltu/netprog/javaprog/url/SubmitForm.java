package se.ltu.netprog.javaprog.url;

//Sample Java code - uses URLConnection object to make an HTTP form submission 
// 
// Looks for a url on the command line, followed by a name and a value 
// (and possibly more names and values)
//creates a query string 
// from the name/value pairs and submits this content to the URL as POST data. 

// 
// Example command line: 
//	java SubmitForm http://omega005.sm.ltu.se/netprog/post/simple.cgi x 10 y 20 
//	the post data will look like "x=10&y=20"

import java.net.*; 
import java.io.*;

public class SubmitForm {

	public static void main(String[] args) throws IOException, MalformedURLException
	{
		if (args.length<3) 
		{ 
			System.out.println("You need to specify a URL, and a sequence of name value pairs"); System.exit(0);
		} 
		
		URL u = new URL(args[0]);
		//build the POST data (query string) 
		// use URLEncoder to do URL encoding 
		String postdata = URLEncoder.encode(args[1],"ASCII") + "=" + URLEncoder.encode(args[2],"ASCII"); 
		for (int i=3;i+1<args.length;i+=2) 
		{
			postdata = postdata + "&" + URLEncoder.encode(args[i],"ASCII") + "=" + URLEncoder.encode(args[i+1],"ASCII");
		}
		
		System.out.println("Encoded query is : " + postdata );
		
		// Create a URLConnection object 
		URLConnection uc = u.openConnection();
		
		// set it so we can write to the server (POST) 
		uc.setDoOutput(true);
		
		// get something we can write to that will send ASCII 
		OutputStreamWriter out =
			new OutputStreamWriter(uc.getOutputStream(),"ASCII"); 
		
		// send the POST data, the connection handles all the other stuff
		out.write(postdata); 
		out.close();
		
		// now lets get the response and print it out
		
		BufferedReader r = new BufferedReader(
				new InputStreamReader ( uc.getInputStream())); 
		
		String s; 
		while (	(s = r.readLine()) != null) 
		{
			System.out.println(s);
		}
		
	}
	
}