package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimeZone;

public class Logger {
    private static Logger logger = new Logger("logs.txt");
    private BufferedWriter writer;

    private Logger(String fileName) {
    }

    public static void trace(String msg) {
        try {
            writer.write("[TRACE] " + msg);
            writer.flush();
        } catch (IOException ignored) {
        }
    }

    public static void debug(String msg) {
        try {
            writer.write("[DEBUG] " + msg);
            writer.flush();
        } catch (IOException ignored) {
        }
    }

    public static void error(String msg) {
        try {
            writer.write("[ERROR] " + msg);
            writer.flush();
        } catch (IOException ignored) {
        }
    }


}
