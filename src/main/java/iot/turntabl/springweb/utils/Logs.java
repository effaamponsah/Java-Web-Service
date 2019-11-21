package iot.turntabl.springweb.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logs {
    private static final String fileName ="logging.txt";
    public static void writeToFile(String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
        writer.write(data+" ");
        writer.write(String.valueOf(new Date())+ "\n");
        writer.close();
    }
}

