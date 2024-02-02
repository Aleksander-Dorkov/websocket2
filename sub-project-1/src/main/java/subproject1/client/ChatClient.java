package subproject1.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import subproject1.dto.Message;

@ClientEndpoint()
public class ChatClient {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @OnOpen
    public void onOpen(Session session) {
        sendMessage(session, "asdasd");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Received message: " + message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Connection closed");
    }

    private void sendMessage(Session session, String content) {
        try {
            // Create a Message object and serialize it to JSON
            Message message = new Message();
            message.setFrom("your_username");
            message.setTo("recipient_username"); // specify the recipient
            message.setContent(content);

            // Send the JSON message to the server
            session.getBasicRemote().sendText(objectMapper.writeValueAsString(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
