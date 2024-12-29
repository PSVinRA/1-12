package clientserver;
import java.io.*;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
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
        try (var socket = new Socket(serverHost, serverPort);
             var writer = new PrintWriter(socket.getOutputStream(), true);
             var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            writer.println("ОТ: " + username);
            writer.println("ДЛЯ: " + recipient);
            writer.println("СООБЩЕНИЕ: " + message);

            System.out.println("Ответ сервера: " + reader.readLine());
        }
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

            System.out.println("Клиент готов отправлять сообщения.");
            while (true) {
                System.out.print("Введите имя получателя: ");
                String recipient = scanner.nextLine();

                System.out.print("Введите сообщение: ");
                String message = scanner.nextLine();

                client.sendMessage(recipient, message);

                System.out.print("Хотите отправить ещё сообщение? (да/нет): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("да")) {
                    System.out.println("Клиент завершает работу.");
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка клиента: " + e.getMessage());
        }
    }
}


