package com.nnk.msgsrv.handler;

import com.nnk.msgsrv.handlerMappings.HandlerMappingsManager;
import nnk.msgsrv.server.Request;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;

public class DefaultMsgHandler {

    public void handler(Request request){
        if(!HandlerMappingsManager.containsKey(request.getCmdName())){
            return;
        }
        HashMap<Object, Method> map = HandlerMappingsManager.get(request.getCmdName());
        if(map.size()!=1){
            throw new RuntimeException("msgsrv 配置异常");
        }
        Object handler = map.keySet().iterator().next();
        Method method = map.get(handler);
        ReflectionUtils.invokeMethod(method,handler,request);
    }
}
