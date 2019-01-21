package filepartreader;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private final String TEST_WORDS =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
            "Proin sollicitudin urna sed est tincidunt ultrices.\n" +
            "Nam vitae mi ac tellus ornare congue quis eget elit.\n" +
            "Praesent commodo diam eget porta elementum.\n" +
            "Curabitur sed est et est rhoncus tristique eget vel purus.";

    @org.junit.jupiter.api.Test
    void fromLineBiggerThanZero() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            fpr.setup("resource/resource.txt",-2,3);
            System.out.println("Test : Failure (FromLine cannot be smaller than zero!)");
        });
        System.out.println("Test : Passed (FromLine cannot be smaller than zero!)");
    }

    @org.junit.jupiter.api.Test
    void toLineCannotBeSmallerThanFromLine() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            fpr.setup("resource/resource.txt",2,1);
            System.out.println("Test : Failure (ToLine cannot be smaller than fromLine!)");
        });
        System.out.println("Test : Passed (ToLine cannot be smaller than fromLine!)");
    }

    @org.junit.jupiter.api.Test
    void readFile() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("test.txt",1,5);
        assertThrows(FileNotFoundException.class, () -> {
            fpr.read();
            System.out.println("Test : Failure (File not found!)");
        });
        System.out.println("Test : Passed (File found!)");
    }

    @org.junit.jupiter.api.Test
    void testReadLines() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("resource/test.txt",1,5);
        assertThrows(IOException.class, () -> {
            fpr.readLines();
            System.out.println("Test : Failure (File is unreadable!)");
        });
        System.out.println("Test : Passed (File is readable!)");
    }

    @org.junit.jupiter.api.Test
    void correctScan() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("resource/test.txt",1,5);
        assertThrows(IOException.class, () -> {
            String text = fpr.readLines();
            assertEquals("Test : Failure (Scanning doesn't match!)",text,TEST_WORDS);
        });
        System.out.println("Test : Passed (Scanning matches!)");
    }
}