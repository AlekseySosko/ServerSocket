import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("localHost", 8786);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             Scanner scanner = new Scanner(clientSocket.getInputStream());
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println(scanner.nextLine());

            writer.println(reader.readLine());

            System.out.println(scanner.nextLine());

            writer.println(reader.readLine());

        }
    }
}
