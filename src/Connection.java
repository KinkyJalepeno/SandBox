import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection implements AutoCloseable{

    private final Socket socket;
    private final PrintWriter output;
    private final BufferedReader input;

    public Connection(String host, int port) throws IOException {
        socket = new Socket(host, port);
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public String authenticate(String password) throws IOException {
        Command authenticationCommand = new Command("authentication", "\"server_password\":\"" + password + "\"");
        return executeCommand(authenticationCommand);

    }

    private String executeCommand(Command command) throws IOException {
        output.println(command.build());
        // TODO: is this necessary?
        input.readLine();
        output.println("");
        // end of TODO
        return input.readLine();
    }

    @Override public void close() throws IOException {
        input.close();
        output.close();
        socket.close();
    }
}