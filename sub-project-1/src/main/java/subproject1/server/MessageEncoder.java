package subproject1.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;
import subproject1.dto.Message;

public class MessageEncoder implements Encoder.Text<Message> {

    private static ObjectMapper gson = new ObjectMapper();

    @Override
    public String encode(Message message) {
        try {
            return gson.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}
