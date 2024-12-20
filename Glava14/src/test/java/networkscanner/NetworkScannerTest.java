package networkscanner;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NetworkScannerTest {
    @Test
    void testScanNetwork() throws IOException {
        String subnet = "127.0.0";
        int timeout = 100;
        List<String> activeHosts = NetworkScanner.scanNetwork(subnet, timeout);
        assertFalse(activeHosts.isEmpty(), "Не найдено активных узлов.");
    }
}
