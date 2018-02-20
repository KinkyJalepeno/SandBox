import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class Sandbox {

    public static void main(String... args) {
        Sandbox sandbox = new Sandbox();
        sandbox.connect();
    }

    private void connect() {
        System.out.println("Do you want to connect to a gateway? ");
        Scanner sc = new Scanner(System.in);

        String answer = sc.next();
        if (answer.equals("n") || answer.equals("N")) {
            System.exit(0);
        }
        int port = 63333;
        String passWord = "g4t3w4y1";
        String ipAddress = "192.168.16.230";

        try (Connection conn = new Connection(ipAddress, port)) {
            String authenticationResult = conn.authenticate(passWord);
            System.out.println(authenticationResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
