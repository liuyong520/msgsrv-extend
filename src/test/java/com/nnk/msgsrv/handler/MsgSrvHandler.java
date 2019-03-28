package com.nnk.msgsrv.handler;

import com.nnk.msgsrv.anotation.MsgSrvCommand;
import com.nnk.msgsrv.anotation.MsgSrvComponent;
import nnk.msgsrv.server.Request;

/**
 * <b>package:com.nnk.msgsrv.handler.impl</b>
 * <b>project(项目):msgsrvextend</b>
 * <b>class(类)${CLASS_NAME}</b>
 * <b>creat date(创建时间):2019-02-18 20:31</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
@MsgSrvComponent(registerBean = true)
public interface MsgSrvHandler  {

    public void SlowInt(Request request);
}
