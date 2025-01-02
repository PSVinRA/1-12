package clientserver;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
//Романов Альберт Б762-2 Вариант 1
public class Client {
    private final String serverHost;
    private final int serverPort;
    private String username;
    private PrintWriter writer;
    private BufferedReader reader;

    public Client(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void start() {
        try (Socket socket = new Socket(serverHost, serverPort)) {
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.println("ОТ: " + username);

            Thread listener = new Thread(() -> {
                try {
                    String incomingMessage;
                    while ((incomingMessage = reader.readLine()) != null) {
                        System.out.println(incomingMessage);
                    }
                } catch (IOException e) {
                    System.err.println("Соединение закрыто.");
                }
            });
            listener.start();

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("Введите имя получателя: ");
                    String recipient = scanner.nextLine();

                    System.out.print("Введите сообщение: ");
                    String message = scanner.nextLine();

                    sendMessage(recipient, message);

                    System.out.print("Хотите отправить ещё сообщение? (да/нет): ");
                    String response = scanner.nextLine();
                    if (!response.equalsIgnoreCase("да")) {
                        System.out.println("Клиент завершает работу.");
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка клиента: " + e.getMessage());
        }
    }

    public void sendMessage(String recipient, String message) {
        writer.println("ДЛЯ: " + recipient);
        writer.println("СООБЩЕНИЕ: " + message);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите имя сервера (например, localhost): ");
            String serverHost = scanner.nextLine();

            System.out.print("Введите порт сервера: ");
            int serverPort = scanner.nextInt();
            scanner.nextLine();

            Client client = new Client(serverHost, serverPort);

            System.out.print("Введите ваше имя: ");
            String username = scanner.nextLine();
            client.setUsername(username);

            client.start();
        }
    }
}
