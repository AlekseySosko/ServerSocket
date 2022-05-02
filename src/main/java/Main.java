import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started!");

        try (ServerSocket serverSocket = new ServerSocket(8786);
             Socket clientSocket = serverSocket.accept();
             Scanner scanner = new Scanner(clientSocket.getInputStream());
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            System.out.println("New connection accepted");

            writer.println("Write your name");

            String name = scanner.nextLine();

            System.out.println("Name client: " + name);

            writer.println("Are you child? (yes/no)");

            String answerOne = scanner.nextLine();

            if (answerOne.equals("yes")) {
                System.out.println("Welcome to the kids area, " + name + " Let's play!");
            } else if (answerOne.equals("no")) {
                System.out.println("Welcome to the adult zone, " + name + " Have a good rest, or a good working day!");
            }
        }

    }
}
