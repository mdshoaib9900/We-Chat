package shoaib.chatApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import shoaib.chatApp.ChatAppApplication;
import shoaib.chatApp.Model.ChatMessage;
import shoaib.chatApp.Repo.ChatMessageRepository;

import java.time.LocalDateTime;

@Service
public class ChatService {

    private final ChatMessageRepository repository;
    @Autowired
    private ChatService(ChatMessageRepository repository){
        this.repository=repository;
    }
    public ChatMessage saveMessage(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        return repository.save(message);
    }

    public void UserExit(String sender) {
    

    }
}
