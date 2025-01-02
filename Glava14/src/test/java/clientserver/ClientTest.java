package clientserver;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    void testMultipleClientsCanExchangeMessages() throws IOException, InterruptedException {
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                Socket clientSocket1 = serverSocket.accept();
                Socket clientSocket2 = serverSocket.accept();

                BufferedReader reader1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
                PrintWriter writer1 = new PrintWriter(clientSocket1.getOutputStream(), true);

                BufferedReader reader2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
                PrintWriter writer2 = new PrintWriter(clientSocket2.getOutputStream(), true);

                assertEquals("ОТ: Client1", reader1.readLine());
                assertEquals("ОТ: Client2", reader2.readLine());

                assertEquals("ДЛЯ: Client2", reader1.readLine());
                assertEquals("СООБЩЕНИЕ: Привет!", reader1.readLine());
                writer2.println("Сообщение от Client1: Привет!");

                assertEquals("ДЛЯ: Client1", reader2.readLine());
                assertEquals("СООБЩЕНИЕ: Здравствуй!", reader2.readLine());
                writer1.println("Сообщение от Client2: Здравствуй!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        Thread.sleep(100);

        Client client1 = new Client("127.0.0.1", 8080);
        client1.setUsername("Client1");
        new Thread(() -> client1.sendMessage("Client2", "Привет!")).start();

        Client client2 = new Client("127.0.0.1", 8080);
        client2.setUsername("Client2");
        new Thread(() -> client2.sendMessage("Client1", "Здравствуй!")).start();

        Thread.sleep(500);
        serverThread.interrupt();
    }
}
