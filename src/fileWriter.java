import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class fileWriter {
    private File F;
    public static PrintWriter printWriter;

    public fileWriter() throws IOException {
        F = new File("simulation.txt");
        printWriter = new PrintWriter("simulation.txt");
        if (!F.createNewFile())
            printWriter.print("");
    }
}
