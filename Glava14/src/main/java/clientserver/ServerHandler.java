package clientserver;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
//Романов Альберт Б762-2 Вариант 1
public class ServerHandler implements Runnable {
    private static final Map<String, Socket> clients = new HashMap<>();
    private final Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String from = reader.readLine().split(": ")[1];
            String to = reader.readLine().split(": ")[1];
            String message = reader.readLine().split(": ")[1];

            clients.put(from, clientSocket);

            if (clients.containsKey(to)) {
                try (PrintWriter toWriter = new PrintWriter(clients.get(to).getOutputStream(), true)) {
                    toWriter.println("Сообщение от " + from + ": " + message);
                }
                writer.println("Сообщение доставлено.");
            } else {
                writer.println("Получатель не найден.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

