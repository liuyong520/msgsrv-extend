package com.nnk.msgsrv;

import nnk.msgsrv.server.MsgSrvLongConnector;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <b>package:com.nnk.msgsrv</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 20:25</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");

        PropertyConfigurator.configure("config/log4j.properties");
        MsgSrvLongConnector msgSrvLongConnector = new MsgSrvLongConnector("config/msgsrv-refund.xml");
        msgSrvLongConnector.start();
    }
}
