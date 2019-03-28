package com.nnk.msgsrv.handler.impl;

import com.nnk.msgsrv.anotation.MsgSrvCommand;
import com.nnk.msgsrv.anotation.MsgSrvComponent;
import com.nnk.msgsrv.handler.MsgSrvHandler;
import nnk.msgsrv.server.Request;
@MsgSrvComponent(registerBean = true)
public class MsgSrvHandlerImpl implements MsgSrvHandler {
    @MsgSrvCommand(value = "handler")
    public void SlowInt(Request request) {

    }
}
