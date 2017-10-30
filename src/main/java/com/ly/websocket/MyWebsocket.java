package com.ly.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by ly on 2017/10/19 15:09
 */
@ServerEndpoint("/websocket")
public class MyWebsocket {
    private static CopyOnWriteArraySet<MyWebsocket> websockets = new CopyOnWriteArraySet<MyWebsocket>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        websockets.add(this);
    }

    @OnClose
    public void onClose() {
        websockets.remove(this);
    }

    @OnMessage
    public void onMessage(String message) {
        for (MyWebsocket item : websockets) {
            try {
                item.send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void send(String message) throws IOException {
        this.session.getAsyncRemote().sendText(message);
        //this.session.getBasicRemote().sendText(message);

    }


    @OnError
    public void onError(Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

}
