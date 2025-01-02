package clientserver;
import java.io.*;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
//Романов Альберт Б762-2 Вариант 1
public class ServerHandler implements Runnable {
    private static final ConcurrentHashMap<String, PrintWriter> clients = new ConcurrentHashMap<>();
    private final Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String from = reader.readLine().split(": ")[1];

            clients.put(from, writer);
            System.out.println("Зарегистрированные клиенты: " + clients.keySet());
            System.out.println("Клиент " + from + " подключился.");

            String to;
            String message;

            while (true) {
                try {
                    to = reader.readLine().split(": ")[1];
                    message = reader.readLine().split(": ")[1];

                    if (clients.containsKey(to)) {
                        clients.get(to).println("Сообщение от " + from + ": " + message);
                        writer.println("Сообщение доставлено.");
                    } else {
                        writer.println("Получатель не найден.");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Клиент " + from + " отключился.");
                    clients.remove(from);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
