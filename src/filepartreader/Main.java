package filepartreader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FilePartReader fpr = new FilePartReader();
        fpr.setup("resource/resource.txt",1,14);
        System.out.println(fpr.readLines());

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        System.out.println("Alphabetically: " + fwa.getWordsOrderedAlphabetically().toString());
        System.out.println("Contains 'a': " + fwa.getWordsContainingSubstring("a").toString());
        System.out.println("Palindromes: " + fwa.getStringsWhichPalindromes().toString());

    }

}
