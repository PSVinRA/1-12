package networkscanner;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
//Романов Альберт Б762-2 Вариант 3
public class NetworkScanner {
    public static List<String> scanNetwork(String subnet, int timeout) throws IOException {
        List<String> activeHosts = new ArrayList<>();
        for (int i = 1; i <= 254; i++) {
            String host = subnet + "." + i;
            if (InetAddress.getByName(host).isReachable(timeout)) {
                activeHosts.add(host);
            }
        }
        return activeHosts;
    }

    public static void main(String[] args) throws IOException {
        String subnet = "192.168.0";
        int timeout = 100;
        List<String> activeHosts = scanNetwork(subnet, timeout);
        System.out.println("Активные узлы: " + activeHosts);
    }
}
