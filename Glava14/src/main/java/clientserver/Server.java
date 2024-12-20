package clientserver;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Романов Альберт Б762-2 Вариант 1
public class Server {
    private final int port;
    private final ExecutorService executor;

    public Server(int port) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен по порту " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executor.execute(new ServerHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(8080);
        server.start();
    }
}

