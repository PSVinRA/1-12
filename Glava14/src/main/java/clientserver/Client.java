package clientserver;
import java.io.*;
import java.net.Socket;
//Романов Альберт Б762-2 Вариант 1
public class Client {
    private final String serverHost;
    private final int serverPort;
    private String username;

    public Client(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void sendMessage(String recipient, String message) throws IOException {
        try (Socket socket = new Socket(serverHost, serverPort);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            writer.println("ОТ: " + username);
            writer.println("ДЛЯ: " + recipient);
            writer.println("СООБЩЕНИЕ: " + message);

            System.out.println("Ответ сервера: " + reader.readLine());
        }
    }
}

