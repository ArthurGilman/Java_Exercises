package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimeZone;

public class Logger {
    private String fileName;
    private final BufferedWriter writer;

    public Logger(String fileName) throws IOException {
        this.fileName = fileName;
        writer = new BufferedWriter(new FileWriter(fileName));
    }

    public void trace(String msg) {
        try {
            writer.write("[TRACE] " + msg);
            writer.flush();
        } catch (IOException ignored) {
        }
    }

    public void debug(String msg) {
        try {
            writer.write("[DEBUG] " + msg);
            writer.flush();
        } catch (IOException ignored) {
        }
    }

    public void error(String msg) {
        try {
            writer.write("[ERROR] " + msg);
            writer.flush();
        } catch (IOException ignored) {
        }
    }


}
