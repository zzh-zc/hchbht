package com.hchbht.server;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

/**
 * Created by zzh on 2021/03/17
 */
public class TimeServerHandler extends IoHandlerAdapter {

    /** 30秒发送一次心跳包 */
    private static final int HEARTBEATRATE = 50;
    private static Logger logger = Logger.getLogger(TimeServerHandler.class);

    public TimeServerHandler(){
        NioSocketAcceptor acceptorGK = new NioSocketAcceptor();
        acceptorGK.getFilterChain().addFirst("faultPool", new ExecutorFilter(Executors.newCachedThreadPool()));
        acceptorGK.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory(Charset.forName("UTF-8"))));
        acceptorGK.getSessionConfig().setReadBufferSize(2048);
        acceptorGK.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        KeepAliveMessageFactory faultHeartBeatFactory = new KeepAliveMessageFactoryImpl();
        KeepAliveFilter faultHeartBeat = new KeepAliveFilter(faultHeartBeatFactory,IdleStatus.BOTH_IDLE,new RequestTimeoutCloseHandler());
        faultHeartBeat.setForwardEvent(true);
        faultHeartBeat.setRequestInterval(HEARTBEATRATE);
        acceptorGK.getFilterChain().addLast("heartbeat", faultHeartBeat);
        acceptorGK.setHandler(new MinaTcpServerGk());
        SocketSessionConfig dcfgFault = acceptorGK.getSessionConfig();
        dcfgFault.setReuseAddress(true);
        acceptorGK.setDefaultLocalAddress(new InetSocketAddress(11087));
        try {
            acceptorGK.bind();
            System.out.println("Mina服务已启动，端口：" + 11087);
        } catch (IOException e) {
            logger.error("bind tcp port 11086 failed");
            e.printStackTrace();
        }


        NioSocketAcceptor acceptorVoc = new NioSocketAcceptor();
        acceptorVoc.getFilterChain().addFirst("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));
        acceptorVoc.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory(Charset.forName("UTF-8"))));
        acceptorVoc.getSessionConfig().setReadBufferSize(2048);
        acceptorVoc.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        KeepAliveMessageFactory heartBeatFactoryVoc = new KeepAliveMessageFactoryImpl();
        KeepAliveFilter heartBeatVoc = new KeepAliveFilter(heartBeatFactoryVoc,
                IdleStatus.BOTH_IDLE,new RequestTimeoutCloseHandler());
        heartBeatVoc.setForwardEvent(true);
        heartBeatVoc.setRequestInterval(HEARTBEATRATE);
        acceptorVoc.getFilterChain().addLast("heartbeat", heartBeatVoc);
        acceptorVoc.setHandler(new MinaTcpServerVoc());
        SocketSessionConfig dcfg6 = acceptorVoc.getSessionConfig();
        dcfg6.setReuseAddress(true);
        acceptorVoc.setDefaultLocalAddress(new InetSocketAddress(11088));
        try {
            acceptorVoc.bind();
            System.out.println("Mina服务已启动，端口：" + 11088);
        } catch (IOException e) {
            logger.error("bind tcp port 11087 failed");
            e.printStackTrace();
        }


        NioSocketAcceptor acceptorYY = new NioSocketAcceptor();
        acceptorYY.getFilterChain().addFirst("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));
        acceptorYY.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory(Charset.forName("UTF-8"))));
        acceptorYY.getSessionConfig().setReadBufferSize(2048);
        acceptorYY.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        KeepAliveMessageFactory heartBeatFactoryYY = new KeepAliveMessageFactoryImpl();
        KeepAliveFilter heartBeatYY = new KeepAliveFilter(heartBeatFactoryYY,
                IdleStatus.BOTH_IDLE,new RequestTimeoutCloseHandler());
        heartBeatYY.setForwardEvent(true);
        heartBeatYY.setRequestInterval(HEARTBEATRATE);
        acceptorYY.getFilterChain().addLast("heartbeat", heartBeatYY);
        acceptorYY.setHandler(new MinaTcpServerYy());
        SocketSessionConfig dcfgYY = acceptorYY.getSessionConfig();
        dcfgYY.setReuseAddress(true);
        acceptorYY.setDefaultLocalAddress(new InetSocketAddress(11086));
        try {
            acceptorYY.bind();
            System.out.println("Mina服务已启动，端口：" + 11086);
        } catch (IOException e) {
            logger.error("bind tcp port 11088 failed");
            e.printStackTrace();
        }
    }
}
