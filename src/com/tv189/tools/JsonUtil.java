package com.tv189.tools;

import java.util.List;
import com.google.gson.Gson;
import com.tv189.domain.Channel;
import com.tv189.domain.Program;

public class JsonUtil{
 
    private static Gson gson=null;
    static{
        if(gson==null){
            gson=new Gson();
        }
    }
    private JsonUtil(){}
   
    public static Program jsonToProgramList(String jsonStr){
    	Program obj=null;
        if(gson!=null){
            java.lang.reflect.Type type=new com.google.gson.reflect.TypeToken<Program>(){}.getType();
            obj=gson.fromJson(jsonStr, type);
        }
        return obj;
    }
    
    public static Channel jsonToChannelList(String jsonStr){
        Channel obj=null;
        if(gson!=null){
            java.lang.reflect.Type type=new com.google.gson.reflect.TypeToken<Channel>(){}.getType();
            obj=gson.fromJson(jsonStr, type);
        }
        return obj;
    }
    
}
