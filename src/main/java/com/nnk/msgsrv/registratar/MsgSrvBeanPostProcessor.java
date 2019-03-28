package com.nnk.msgsrv.registratar;

import com.nnk.msgsrv.anotation.MsgSrvComponent;
import com.nnk.msgsrv.config.MsgSrvConfig;
import com.nnk.msgsrv.mapper.MsgSrvMapperFactoryBean;
import com.nnk.msgsrv.mapper.MsgsrvMapperRegistry;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

/**
 * <b>package:com.nnk.msgsrv.registratar</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 20:10</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
public class MsgSrvBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter implements InitializingBean, BeanFactoryAware
{
    private BeanFactory beanFactory;
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MsgSrvMapperFactoryBean && isScanedGeneratedMsgSrvBean(beanName)) {
            Class<?> underlyingClass = MsgSrvBeanDefinitionRegistrar.getUnderlyingClass(beanName);
            Object underlyingBean = beanFactory.getBean(underlyingClass);
//            ((MsgSrvSpringProviderBean)bean).setTarget(underlyingBean);
//            ((MsgSrvSpringProviderBean)bean).setServiceInterface(underlyingClass.getInterfaces()[0].getName());
//            ((MsgSrvMapperFactoryBean) bean).setClazz(underlyingClass);
//            MsgsrvMapperRegistry registry = MsgsrvMapperRegistry.getRegistry();
//            //顶层接口
//            registry.addMapper(underlyingClass.getInterfaces()[0]);
//            //获取所有的方法
//            HashMap<String, HashMap<Object, Method>> allMsgSrvCommandMethodMappings = findAllMsgSrvCommandMethodMapping(underlyingClass, underlyingBean);
//            //统一交给HandlerMappingsManager管理
//            HandlerMappingsManager.putAll(allMsgSrvCommandMethodMappings);
        }
        return bean;
    }





    /**
     * 当前Bean是否是通过{@linkplain com.nnk.msgsrv.anotation.MsgSrvComponentScan}注解式生成的Bean
     *
     * @param beanName
     * @return
     */
    private boolean isScanedGeneratedMsgSrvBean(String beanName) {
        return beanName.startsWith(MsgSrvMapperFactoryBean.class.getSimpleName()) && beanName.contains("#");
    }
}
