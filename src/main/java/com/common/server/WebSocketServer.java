package com.common.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.springframework.web.socket.server.standard.SpringConfigurator;

/**
 * 必须加configurator = SpringConfigurator.class，否则在这个服务器端点里的@Autowried都将空指针
 */
@ServerEndpoint(value = "/webSocket/{digits}", configurator = SpringConfigurator.class)
public class WebSocketServer {

	Logger logger = Logger.getLogger(WebSocketServer.class);

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static volatile int onlineCount = 0;

	// 记录每个用户下多个终端的连接
	private static Map<String, WebSocketServer> socketMap = new HashMap<>();

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	private String digits;

	/**
	 * 连接建立成功调用的方法
	 * 
	 * @param digits 学号或工号
	 */
	@OnOpen
	public void onOpen(@PathParam("digits") String digits, Session session) {
		this.session = session;
		this.digits = digits;
		addOnlineCount();
		// 根据该digits当前是否已经在别的终端登录进行添加操作
		if (socketMap.containsKey(this.digits)) {
			logger.info("当前digits:{" + this.digits + "}已有其他终端登录");
			socketMap.remove(this.digits);
			socketMap.put(this.digits, this);
		} else {
			logger.info("当前digits:{" + this.digits + "}终端登录");
			socketMap.put(this.digits, this);
		}
		logger.info("当前终端个数为：{" + getOnlineCount() + "}");
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		subOnlineCount();
		socketMap.remove(this.digits);
		logger.info("当前终端个数为：{" + onlineCount + "}");
	}

	/**
	 * 收到客户端消息后调用的方法
	 * 
	 * @param message 客户端发送过来的消息
	 * @param session 可选的参数
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		logger.info("收到来自digits为：{" + this.digits + "}的消息：{" + message + "}");
	}

	/**
	 * 发生错误时调用
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		logger.error(this.digits + "的连接发送错误");
		error.printStackTrace();
	}

	/**
	 * @Title: sendMessageToUser
	 * @Description: 发送消息给用户下的所有终端
	 * @param @param userId 用户id
	 * @param @param message 发送的消息
	 * @param @return 发送成功返回true，反则返回false
	 */
	public static Boolean sendMessageTodigits(String digits, String message) {
		if (socketMap.containsKey(digits)) {
			System.out.println(" 给digits为：{" + digits + "}的所有终端发送消息：{" + message + "}");
			try {
				socketMap.get(digits).session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(" 给digits为：{" + digits + "}发送消息失败");
				return false;
			}
			return true;
		} else {
			System.out.println("发送错误：当前连接不包含:" + digits);
			return false;
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}
}
