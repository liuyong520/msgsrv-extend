package com.nnk.msgsrv.mapper;


import org.springframework.beans.factory.FactoryBean;

/**
 * <b>package:com.nnk.msgsrv.registratar</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 20:13</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
public class MsgSrvMapperFactoryBean<T> implements FactoryBean<T>{
    //此时的class 对象必须是一个接口来着
    private Class<T> mapperInterface;

    public MsgSrvMapperFactoryBean() {
    }
    public MsgSrvMapperFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T getObject() throws Exception {

        MsgsrvMapperRegistry mapperRegistry = MsgsrvMapperRegistry.getRegistry();
        try {
            return mapperRegistry.getMapper(mapperInterface);
        }catch (Throwable throwable){
            throw new IllegalArgumentException(throwable);
        }
    }

    public Class<?> getObjectType() {
        return mapperInterface;
    }

    public boolean isSingleton() {
        return true;
    }
}
