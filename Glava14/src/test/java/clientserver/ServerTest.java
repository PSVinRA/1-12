package clientserver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ServerTest {
    @Test
    void testServerStart() {
        Server server = new Server(8080);
        assertDoesNotThrow(server::start);
    }
}
