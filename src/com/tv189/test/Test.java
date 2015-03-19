package com.tv189.test;

public class Test extends Thread{
	public static void main(String[] args) {
		for(int j=0;j<5;j++){
			Test t=new Test();
			Thread thread=new Thread(t);
			thread.start();
		}
	}
	
	public void pringInt(int s){
		System.out.println("调用前："+s);
		s=s+1;
		System.out.println("调用后方法中："+s);
	}

	@Override
	public void run() {
		while(true){
			int i=2;
			new Test().pringInt(i);
			System.out.println("调用后方法中："+i);
			super.run();
		}
	
	}
	
	
	
	
}
