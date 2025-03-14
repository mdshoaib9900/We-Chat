package shoaib.chatApp.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import shoaib.chatApp.Model.ChatMessage;

@Component
public class WebSocketEventListener {
    private static  final Logger logger= LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations operations;
    @EventListener
    public void handleWebSocketDisconnects(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
        String username=(String)headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected : " + username);

            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setType(ChatMessage.MessageType.LEAVE);
            chatMessage.setSender(username);

            // Broadcast the leave message to all subscribers
           operations.convertAndSend("/topic/public", chatMessage);
        }
    }
}
