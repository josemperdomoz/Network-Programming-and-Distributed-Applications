package se.ltu.netprog.javaprog.url;

import java.net.*; 
import java.io.*;

public class GetPage {

	public static void main(String[] args) throws IOException, MalformedURLException
	{	
		
		if (args.length!=1) 
		{ 
			System.out.println("You need to specify a URL"); 
			System.exit(0);
		}
		
		URL u = new URL(args[0]); 
		//	InputStream in = u.openStream(); 
		BufferedReader r = new BufferedReader(
				new InputStreamReader ( u.openStream())); 
		
		String s; 
		while (	(s = r.readLine()) != null) 
		{
			System.out.println(s);
		}
	}
}