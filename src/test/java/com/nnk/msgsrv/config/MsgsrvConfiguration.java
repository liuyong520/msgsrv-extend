package com.nnk.msgsrv.config;

import com.nnk.msgsrv.anotation.MsgSrvComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MsgSrvComponentScan("com.nnk.msgsrv.handler")
public class MsgsrvConfiguration {
}
