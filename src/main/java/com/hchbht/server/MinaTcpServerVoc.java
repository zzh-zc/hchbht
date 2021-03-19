package com.hchbht.server;

import org.apache.commons.lang.StringUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * Created by zzh on 2021/03/17
 */
public class MinaTcpServerVoc extends IoHandlerAdapter {
    public static void main(String[] args) throws IOException {
        new MinaTcpServerVoc();
    }
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        String str = message.toString();
        String clientIP = "";
        int clientPort = 0;
        if(StringUtils.isEmpty(String.valueOf(session.getRemoteAddress()))){
            clientIP = (String)session.getAttribute("KEY_SESSION_CLIENT_IP");
            clientPort = (Integer) session.getAttribute("KEY_SESSION_CLIENT_PORT");
        }else{
            clientIP = ((InetSocketAddress)session.getRemoteAddress()).getAddress().getHostAddress();
            clientPort = ((InetSocketAddress)session.getRemoteAddress()).getPort();
        }
        System.out.println("设备IP---------- -->"  + clientIP);
        System.out.println("设备PORT---------- -->"  + clientPort);
        System.out.println("VOC--------------VOC数据Message -->"  + str);
        if (str.trim().equalsIgnoreCase("quit")) {
            session.close();
            return;
        }
        Date date = new Date();
        // 返回数据
//        session.write(date.toString());
    }
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("会话关闭");
    }
    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        System.out.println("会话异常");
        super.exceptionCaught(session, cause);
    }
    @Override
    public void messageSent(IoSession iosession, Object obj) throws Exception {
        System.out.println("服务端消息发送");
        super.messageSent(iosession, obj);
    }
    @Override
    public void sessionCreated(IoSession iosession) throws Exception {
        System.out.println("会话创建");
        String clientIP = ((InetSocketAddress) iosession.getRemoteAddress()).getAddress().getHostAddress();
        int clientPort = ((InetSocketAddress) iosession.getRemoteAddress()).getPort();
        iosession.setAttribute("KEY_SESSION_CLIENT_IP", clientIP);
        iosession.setAttribute("KEY_SESSION_CLIENT_PORT", clientPort);
        super.sessionCreated(iosession);
    }
    @Override
    public void sessionIdle(IoSession iosession, IdleStatus idlestatus)
            throws Exception {
        System.out.println("会话休眠");
        super.sessionIdle(iosession, idlestatus);
    }
    @Override
    public void sessionOpened(IoSession iosession) throws Exception {
        System.out.println("会话打开");
        super.sessionOpened(iosession);
    }
}
