public class Command {

    private final String method;
    private final String data;

    public Command(String method, String data) {
        this.method = method;
        this.data = data;
    }

    public String build() {
        return "{\"method\":\"" + method + "\"," + data + "}";
    }

}