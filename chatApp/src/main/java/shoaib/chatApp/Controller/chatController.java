package shoaib.chatApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import shoaib.chatApp.Model.ChatMessage;
import shoaib.chatApp.Service.ChatService;

import java.time.LocalDateTime;
import java.util.Objects;

@Controller
public class chatController {
    private final ChatService service;
    @Autowired
    public chatController(ChatService service) {
        this.service = service;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message){
        service.saveMessage(message);
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor){
       headerAccessor.getSessionAttributes().put("username",message.getSender());
        message.setType(ChatMessage.MessageType.JOIN);
        message.setTimestamp(LocalDateTime.now());
        service.saveMessage(message);
        return message;
    }
    @MessageMapping("/chat.Leave")
    @SendTo("/topic/public")
    public ChatMessage UserLeft(@Payload ChatMessage message,SimpMessageHeaderAccessor headerAccessor){
        String username=(String) headerAccessor.getSessionAttributes().remove("username");
        message.setSender(username);
        message.setTimestamp(LocalDateTime.now());
        message.setType(ChatMessage.MessageType.LEAVE);
        service.UserExit(message.getSender());
        return message;

    }


}
