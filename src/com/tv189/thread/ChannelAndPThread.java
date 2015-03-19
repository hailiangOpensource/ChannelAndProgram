package com.tv189.thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;

import com.tv189.domain.RequestProxy;
import com.tv189.logic.ChannelLogic;
import com.tv189.logic.ProgramLogic;

public class ChannelAndPThread extends Thread {
	private static Queue<RequestProxy> logObjects = new ConcurrentLinkedQueue<RequestProxy>();
	
	public static void addRequestProxy(RequestProxy requestProxy) {
		logObjects.add(requestProxy);
	}
	public void run() {
		System.out.println("************************业务处理流程启动**************************");
		while(true){
			Integer size = logObjects.size();
			for (Integer i = 0; i < size; i++) {
				RequestProxy proxy = logObjects.poll();
				synProgramOrChannel(proxy.getSynctype(),proxy.getMethod(),proxy.getContent());
			}
			Integer sleepTime = 5*1000;			//5秒写一次
			try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void synProgramOrChannel (String synctype,String method,String content){
 		if(synctype.equals("liveProgram")){
     		ProgramLogic prolLogic = new ProgramLogic();
     		prolLogic.publishOrCancelProgram(synctype, method, content);
 		}
 		if(synctype.equals("liveContent")){
     		ChannelLogic channelLogic = new ChannelLogic();
     		channelLogic.publishOrCancelChannel(synctype, method, content);
 		}
	}
	public void initThread(){
		Thread  tp=TreadPool.getInstance().getThreadFactory().newThread(new ChannelAndPThread());
		tp.start();
	}
	
}