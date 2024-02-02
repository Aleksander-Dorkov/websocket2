package subproject1.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;
import subproject1.dto.Message;

public class MessageDecoder implements Decoder.Text<Message> {

    private static ObjectMapper gson = new ObjectMapper();

    @Override
    public Message decode(String s) throws DecodeException {
        try {
            return gson.readValue(s, Message.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
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
