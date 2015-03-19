package com.tv189.controller;

import java.net.URLDecoder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ThreadFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tv189.domain.RequestProxy;
import com.tv189.domain.ResponseObject;
import com.tv189.helper.CreateAndAddLogHelper;
import com.tv189.helper.GetParaHelper;
import com.tv189.helper.LogConfigHelper;
import com.tv189.log.MyLoggerManager;
import com.tv189.logic.ProgramLogic;
import com.tv189.logic.ChannelLogic;
import com.tv189.thread.ChannelAndPThread;
import com.tv189.thread.TreadPool;

/**
 * Servlet implementation class ChannelAndProgram
 */
public class ChannelAndProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 @Override
		public void init() throws ServletException {
			super.init();
			ThreadFactory  tp=TreadPool.getInstance().getThreadFactory();
			Thread t=tp.newThread(new ChannelAndPThread());
			Thread logger=tp.newThread(new MyLoggerManager());
			t.start();
			logger.start();
		}
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

    	 Gson gson = new Gson();
         PrintWriter pwriter = response.getWriter();
         String code ="0";
         String msg = "ok";
         
         String loggerName = LogConfigHelper.getHttpInfoLoggerName();
		/*
		 * 获取synctype、    method、content参数	 
		 */
    	String synctype = request.getParameter("synctype");
    	String method = request.getParameter("method");
    	String content = request.getParameter("content");

    	Map<String,String[]> map=request.getParameterMap();
    	synctype = GetParaHelper.getParaMap(map, synctype);
    	method = GetParaHelper.getParaMap(map, method);
    	content = GetParaHelper.getParaMap(map, content);

    	ServletInputStream sInputStream = request.getInputStream();
		try {
			content = GetParaHelper.getParaBySteam(sInputStream, content);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		content = URLDecoder.decode(content,"utf-8");
		
		String msg1 = "转换前,synctype为："+synctype+",method为："+method+",cotent为:"+content;
		CreateAndAddLogHelper.createAndAddLogger(loggerName, msg1);
		
		String msg2 = "一条新请求："+request.getLocalPort()+request.getRemoteAddr()+request.getRequestURI()+request.getQueryString();
		CreateAndAddLogHelper.createAndAddLogger(loggerName, msg2);
		
     	if(content!=null && content.length()!=0 && synctype!=null && synctype.length()!=0 && method!=null&& method.length()!=0 ){
     		ChannelAndPThread.addRequestProxy(new RequestProxy(synctype, method, content));//加到业务处理队列等待处理
     	}else{
     		code ="1";
            msg = "parameter error";
     	}
     	ResponseObject responseObj = new ResponseObject(code, msg, null);
     	pwriter.write(gson.toJson(responseObj));
    }

}
