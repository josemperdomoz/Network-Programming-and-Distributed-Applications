package se.ltu.netprog.javaprog.threads;

public  class Shared0 {
	protected int x=0, y=0;
	public int dif(){
		return x-y;
	}
	public void bump() throws InterruptedException{
		x++;
		Thread.sleep(9);
		y++;
	}
}
