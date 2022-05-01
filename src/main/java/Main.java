import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started!");

        try (ServerSocket serverSocket = new ServerSocket(8786)) {
            Socket socket = serverSocket.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("New connection accepted");

            final String name = scanner.nextLine();

            writer.println(String.format("Hi %s, your port is %d", name, socket.getPort()));;
        }

    }
}
