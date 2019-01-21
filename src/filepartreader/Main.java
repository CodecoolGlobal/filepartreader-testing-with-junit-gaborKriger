package filepartreader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FilePartReader fpr = new FilePartReader();
        fpr.setup("resource/resource.txt",2,3);
        System.out.println(fpr.readLines());

        FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);
        System.out.println(fwa.getWordsOrderedAlphabetically().toString());
        System.out.println(fwa.getWordsContainingSubstring("a").toString());
        System.out.println(fwa.getStringsWhichPalindromes().toString());

    }

}
