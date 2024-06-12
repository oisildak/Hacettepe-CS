import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StackOperation.StackOperation(args[0]);//taking command.txt
        QueueOperation.QueueOperation(args[0]);
    }
}
