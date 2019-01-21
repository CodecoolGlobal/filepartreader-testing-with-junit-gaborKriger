package filepartreader;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    private String filePath;
    private Integer fromline;
    private Integer toLine;


    public void setup(String filePath, Integer fromLine, Integer toLine ) {
        this.filePath = filePath;

        try {
            if (fromLine > 0) {
                this.fromline = fromLine;
            } else {
                throw new IllegalArgumentException();
            }

            if (toLine > fromLine){
                this.toLine = toLine;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e);
        }
    }

    public String read() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        BufferedInputStream bis = new BufferedInputStream(fis);

        int i;
        StringBuilder result = new StringBuilder();

        while ((i = bis.read()) != -1) {
            result.append((char) i);
        }
        fis.close();
        return result.toString();
    }

    public String readLines() throws IOException {
        List<String> lines = Arrays.asList(read().split("\\r?\\n"));
        StringBuffer sb = new StringBuffer();
        for (int i = fromline; i < toLine; i++) {
            sb.append(lines.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

}
