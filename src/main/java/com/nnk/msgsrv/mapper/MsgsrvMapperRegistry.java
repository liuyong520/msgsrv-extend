package com.nnk.msgsrv.mapper;

import com.nnk.msgsrv.exception.BindingException;
import com.nnk.msgsrv.proxy.MsgSrvProxyFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MsgsrvMapperRegistry {
    public static MsgsrvMapperRegistry registry;
    private final Map<Class<?>, MsgSrvProxyFactory<?>> knownMappers = new HashMap();

    public <T> boolean hasMapper(Class<T> type) {
        return this.knownMappers.containsKey(type);
    }

    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (this.hasMapper(type)) {
                throw new BindingException("Type " + type + " is already known to the MapperRegistry.");
            }
            this.knownMappers.put(type, new MsgSrvProxyFactory(type));
        }

    }

    public Collection<Class<?>> getMappers() {
        return Collections.unmodifiableCollection(this.knownMappers.keySet());
    }

    public <T> T getMapper(Class<T> type){

        MsgSrvProxyFactory<T> mapperProxyFactory = (MsgSrvProxyFactory)this.knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new BindingException("Type " + type + " is not known to the MapperRegistry.");
        } else {
            try {
                return mapperProxyFactory.newInstance();
            } catch (Exception var5) {
                throw new BindingException("Error getting mapper instance. Cause: " + var5, var5);
            }
        }
    }
    public synchronized static MsgsrvMapperRegistry getRegistry() {
        if(registry == null){
            registry = new MsgsrvMapperRegistry();
        }
        return registry;
    }

}
