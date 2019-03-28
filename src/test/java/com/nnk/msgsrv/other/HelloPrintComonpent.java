package com.nnk.msgsrv.other;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <b>package:com.nnk.msgsrv</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 21:21</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
@Service
public class HelloPrintComonpent implements Print {
    public void sayHello(){
        System.out.println(HelloPrintComonpent.class.getName() + "hello");
    }
}
