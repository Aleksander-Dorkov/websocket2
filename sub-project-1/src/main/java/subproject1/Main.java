package subproject1;

import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import subproject1.client.ChatClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class Main {


    public static void main(String[] args) throws URISyntaxException, DeploymentException, IOException {
        var a = SpringApplication.run(Main.class);

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            container.connectToServer(ChatClient.class, new URI("ws://localhost:8081/chat"));
        } catch (DeploymentException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
