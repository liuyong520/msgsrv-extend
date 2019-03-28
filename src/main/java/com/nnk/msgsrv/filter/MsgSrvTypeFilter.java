package com.nnk.msgsrv.filter;

import com.nnk.msgsrv.anotation.MsgSrvComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;


/**
 * <b>package:com.nnk.msgsrv.filter</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 19:39</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
public class MsgSrvTypeFilter extends AbstractClassTestingTypeFilter {
    private Logger LOGGER = LoggerFactory.getLogger(MsgSrvTypeFilter.class);
    @Override
    protected boolean match(ClassMetadata metadata) {
        Class<?> clazz = transformToClass(metadata.getClassName());
        if (clazz == null || !clazz.isAnnotationPresent(MsgSrvComponent.class)) {
            return false;
        }
        MsgSrvComponent msgSrvComponent = clazz.getAnnotation(MsgSrvComponent.class);
        if (msgSrvComponent.registerBean() && isAnnotatedBySpring(clazz)) {
            throw new IllegalStateException("类{" + clazz.getName() + "}已经标识了Spring组件注解,不能再指定[registerBean = true]");
        }
        //过滤抽象类,接口,注解,枚举,内部类及匿名类
        return !metadata.isAbstract() && !clazz.isInterface() && !clazz.isAnnotation() && !clazz.isEnum()
                && !clazz.isMemberClass() && !clazz.getName().contains("$");
    }

    /**
     * @param className
     * @return
     */
    private Class<?> transformToClass(String className) {
        Class<?> clazz = null;
        try {
            clazz = ClassUtils.forName(className, this.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.info("未找到指定HSF基础类{}", className);
        }
        return clazz;
    }

    /**
     * @param clazz
     * @return
     */
    private boolean isAnnotatedBySpring(Class<?> clazz) {
        return clazz.isAnnotationPresent(Component.class) || clazz.isAnnotationPresent(Configuration.class)
                || clazz.isAnnotationPresent(Service.class) || clazz.isAnnotationPresent(Repository.class)
                || clazz.isAnnotationPresent(Controller.class);
    }
}

