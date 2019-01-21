package filepartreader;

import java.io.IOException;
import java.util.*;

public class FileWordAnalyzer {

    private FilePartReader fpr;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public List getWordsOrderedAlphabetically() throws IOException {
        String text = fpr.readLines();
        List<String> words = Arrays.asList(text.split("[ -.,:\n\r]"));
        List<String> result = new ArrayList<>();

        ListIterator<String> iterator = words.listIterator();
        while (iterator.hasNext()) {
                iterator.set(iterator.next().toLowerCase());
        }
        for (String word : words) {
            if (!word.equals("")) {
                result.add(word);
            }
        }
        Collections.sort(result);
        return result;
    }

    public List getWordsContainingSubstring(String subString) throws IOException {
        String text = fpr.readLines();
        List<String> words = Arrays.asList(text.split("[ -.,:\n\r]"));
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.contains(subString)) {
                result.add(word);
            }
        }

        return result;
    }

    public List getStringsWhichPalindromes () throws IOException {
        String text = fpr.readLines();
        List<String> words = Arrays.asList(text.split("[ -.,:\n\r]"));
        List<String> palindrome = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word) && !word.equals("")) {
                palindrome.add(word);
            }
        }
        return palindrome;
    }

    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
