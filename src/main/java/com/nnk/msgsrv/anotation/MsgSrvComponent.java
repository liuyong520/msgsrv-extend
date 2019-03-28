package com.nnk.msgsrv.anotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <b>package:com.nnk.msgsrv.anotation</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 19:32</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface MsgSrvComponent {
    /**
     * 是否要将标识此注解的类注册为Spring的Bean
     *
     * @return
     */
    boolean registerBean() default false;

    /**
     * 组建名字
     * @return
     */
    String value() default "";

    /**
     * 加载的msgsrv 配置
     * @return
     */
    String configPath() default "";
}
