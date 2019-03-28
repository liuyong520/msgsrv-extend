package com.nnk.msgsrv;

import com.nnk.msgsrv.handler.MsgSrvHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <b>package:com.nnk.msgsrv</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)com.nnk.msgsrv.MsgSrvCommandTest</b>
 * <b>creat date(创建时间):2019-02-18 21:25</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class MsgSrvCommandTestTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @org.junit.Before
    public void setUp() throws Exception {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testMsgsrvHandler() {
        MsgSrvHandler  msgSrvHandler = applicationContext.getBean(MsgSrvHandler.class);
        msgSrvHandler.SlowInt(null);
    }
}
