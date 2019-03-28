package com.nnk.msgsrv.proxy;

import java.lang.reflect.Proxy;

public class MsgSrvProxyFactory<T> {
    private Class<T> mapperInterface;

    public MsgSrvProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public void setMapperInterface(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }
    protected T newInstance(MsgSrvInvocationHandler<T> mapperProxy){
        return (T) Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[]{this.mapperInterface}, mapperProxy);
    }
    public T newInstance(){
        MsgSrvInvocationHandler<T> mapperProxy = new MsgSrvInvocationHandler<T>(mapperInterface);
        return this.newInstance(mapperProxy);
    }
}
