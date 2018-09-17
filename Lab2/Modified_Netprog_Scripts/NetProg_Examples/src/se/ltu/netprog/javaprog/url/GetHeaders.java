package se.ltu.netprog.javaprog.url;


//Sample Java code - uses URL object to retreive a web page 
//
//Looks for a url on the command line, prints out some headers that 
//	are sent back by the server when fetching the URL 
//Uses URLConnection object.

import java.net.*; 
import java.io.*; 
import java.util.*;	// need for Date object

public class GetHeaders {
	public static void main(String[] args) throws IOException, MalformedURLException
	{
		if (args.length!=1) 
		{ 
			System.out.println("You need to specify a URL"); 
			System.exit(0);
			
		}
		
		URL u = new URL(args[0]); 
		URLConnection uc = u.openConnection(); 
		
		//	InputStream in = u.openStream(); 

		//		BufferedReader r = new BufferedReader(

		//				new InputStreamReader ( u.openStream())); 
		//
		// String s; 
		// while (	(s = r.readLine()) != null) 
		// {
		//	System.out.println(s);
		// }

		
		System.out.println("Content-type: " + uc.getContentType()); 
		System.out.println("Content-encoding: "+ uc.getContentEncoding()); 
		System.out.println("Content-length: "+ uc.getContentLength());
		
		//This doesn't do what we want, since getLastModified returns 
		//	a long (number of ms since Jan 1, 1970). 
		
		System.out.println("Last-modified: "+ uc.getLastModified());
		//This will do it right 
		System.out.println("Last-modified: "+ new Date(uc.getLastModified()));

	
	} 
	
}