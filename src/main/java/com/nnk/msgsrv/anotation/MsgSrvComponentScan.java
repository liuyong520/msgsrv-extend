package com.nnk.msgsrv.anotation;

import com.nnk.msgsrv.registratar.MsgSrvBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <b>package:com.nnk.msgsrv.anotation</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 19:35</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MsgSrvBeanDefinitionRegistrar.class)
public @interface MsgSrvComponentScan {


        /**
         * @return
         */
        String[] value() default {};

        /**
         * 扫描包
         *
         * @return
         */
        String[] basePackages() default {};

        /**
         * 扫描的基类
         *
         * @return
         */
        Class<?>[] basePackageClasses() default {};

        /**
         * 包含过滤器
         *
         * @return
         */
        ComponentScan.Filter[] includeFilters() default {};

        /**
         * 排斥过滤器
         *
         * @return
         */
        ComponentScan.Filter[] excludeFilters() default {};

}
