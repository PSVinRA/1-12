package clientserver;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ClientTest {
    @Test
    void testSendMessage() {
        Client client = new Client("127.0.0.1", 8080);
        client.setUsername("Test_user");
        assertDoesNotThrow(() -> client.sendMessage("Other_user", "Привет!"));
    }
}
