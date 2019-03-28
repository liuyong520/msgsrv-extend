package com.nnk.msgsrv;

import nnk.msgsrv.server.MsgSrvLongConnector;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.nnk.msgsrv");
        annotationConfigApplicationContext.refresh();
        PropertyConfigurator.configure("config/log4j.properties");
        MsgSrvLongConnector msgSrvLongConnector = new MsgSrvLongConnector("config/msgsrv-refund.xml");
        msgSrvLongConnector.start();
    }
}
