package filepartreader;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    private String filePath;
    private Integer fromline;
    private Integer toLine;


    public void setup(String filePath, Integer fromLine, Integer toLine) {

        if (fromLine < 0) {
            throw new IllegalArgumentException("FromLine cannot be smaller than zero!");
        }

        if (toLine < fromLine) {
            throw new IllegalArgumentException("ToLine cannot be smaller than fromLine!");
        }

        this.filePath = filePath;
        this.fromline= fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
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
        String read = null;
        try {
            read = read();
        } catch (IOException e) {
            throw new IOException("File is unreadable!");
        }
        List<String> lines = Arrays.asList(read.split("\\r?\\n"));
        StringBuffer sb = new StringBuffer();
        for (int i = fromline; i < toLine; i++) {
            sb.append(lines.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

}
