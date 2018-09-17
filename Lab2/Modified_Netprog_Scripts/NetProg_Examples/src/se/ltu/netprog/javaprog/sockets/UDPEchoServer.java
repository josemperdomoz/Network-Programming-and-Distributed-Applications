package se.ltu.netprog.javaprog.sockets;


import java.net.*;// need this for InetAddress, Socket, ServerSocket 
import java.io.*;// need this for I/O stuff

public class UDPEchoServer { 
	static final int BUFSIZE=1024;
	
	static public void main(String args[]) throws SocketException 
	{ 
		
		if (args.length != 1) {
			throw new IllegalArgumentException("Must specify a port!"); 
						
		}
		
		int port = Integer.parseInt(args[0]);
		DatagramSocket s = new DatagramSocket(port);
		DatagramPacket dp = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
                byte[] sendData = new byte[1024];
                
                
		try { 
			while (true) {
				
                                
                                s.receive(dp);
                                InetAddress clientAddress = dp.getAddress();
                                int clientPort = dp.getPort();
				// print out client's address 
				System.out.println("Message from " + dp.getAddress().getHostAddress());
				// Send it right back 
				s.send(dp);
                                String stringData = " José Mauricio Perdomo ";
				dp.setLength(BUFSIZE);// avoid shrinking the packet buffer
		                sendData = stringData.getBytes();
                                DatagramPacket myNamePacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                                s.send(myNamePacket);
                                //s.receive(myNamePacket);
                                
			} 
		} catch (IOException e) {
			System.out.println("Fatal I/O Error !"); 
			System.exit(0);
			
		} 

	}
}