package com.hchbht.server;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

public class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {

	public Object getRequest(IoSession session) {
		return null;
	}

	public Object getResponse(IoSession session, Object object) {
		return object;
	}

	

	public boolean isResponse(IoSession session, Object object) {
		return false;
	}

	public boolean isRequest(IoSession arg0, Object object) {
		return false;
	}

}
