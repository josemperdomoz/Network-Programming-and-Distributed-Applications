package se.ltu.netprog.javaprog.threads;

public class Race0 extends Thread {
	static Shared0 s;
	
	static volatile boolean done=false;
	public static void main(String[] x){
		Thread lo=new Race0();
		s=new Shared0();
		try{
			lo.start();
			while(!done){
				s.bump();
				sleep(30);
			}
			lo.join();
		}catch (InterruptedException e)
	{
		return;
	}
	
}
public void run(){
	int i;
	try{
		for(i=0;i<1000;i++){
			if(i%60==0)
				System.out.println();
			System.out.print(".X".charAt(s.dif()));
			sleep(20);
                        		
		}
		System.out.println();
		done=true;
		
	}catch (InterruptedException e) {return;}
}
}
