package com.nnk.msgsrv.anotation;

import java.lang.annotation.*;

/**
 * <b>package:com.nnk.msgsrv.anotation</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 20:23</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface MsgSrvCommand {
    /**
     *
     * @return
     */
    public String value();
}
