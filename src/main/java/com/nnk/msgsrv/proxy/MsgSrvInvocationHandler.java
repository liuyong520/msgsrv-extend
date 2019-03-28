package com.nnk.msgsrv.proxy;

import com.nnk.msgsrv.exception.MsgsrvProxyException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MsgSrvInvocationHandler<T> implements InvocationHandler {

    private final Class<T> mapperInterface;

    public MsgSrvInvocationHandler(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                return method.invoke(this, args);
            } catch (Throwable throwable) {
                throw new MsgsrvProxyException(throwable);
            }
        }
        return null;
    }
}
