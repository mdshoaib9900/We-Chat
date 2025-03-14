package shoaib.chatApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shoaib.chatApp.Model.ChatMessage;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {

}
