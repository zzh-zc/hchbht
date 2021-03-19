package com.hchbht.server;

import org.apache.commons.lang.StringUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<String> list = new ArrayList<>();
        str = "##0340ST=31;CN=2011;PW=123456;MN=88888880000009;Flag=0;CP=&&DataTime=20151218092100;S101-Rtd=10.5,S101-Flag=N;S102-Rtd=0,S102-Flag=N;S103-Rtd=0.5,S103-Flag=N;S104-Rtd=0,S104-Flag=N;S105-Rtd=1.728,S105-Flag=N;S201-Rtd=24.31,S201-Flag=N;S202-Rtd=0,S202-Flag=N;H101-Rtd=1,H101-Flag=N;H102-Rtd=0,H102-Rtd=N;J01-Rtd=1,J02-Flag=N;J02-Rtd=1,J02-Flag=N&&1B00";
        if(StringUtils.isNotBlank(str) && str.length()>=6 && str.startsWith("##")){
            String firstData = str.substring(6,str.length()-6);
            String[] dataList = firstData.split(";");
            for (int i = 0; i < dataList.length; i++) {
                if(dataList[i].contains("&&")){
                    list.add(dataList[i].split("&&")[1]);
                }else{
                    String[] data =  dataList[i].split(",");
                    for (int j = 0; j < data.length; j++) {
                        list.add(data[j]);
                    }
                }
                if(!list.isEmpty()){
                    list.parallelStream().forEach(res -> {

                    });
                }
            }
            if (str.trim().equalsIgnoreCase("quit")) {
                session.close();
                return;
            }
            Date date = new Date();
            // 返回数据
//        session.write(date.toString());
        }
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
