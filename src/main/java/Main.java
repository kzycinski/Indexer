import index.Indexer;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = getUserInput();
        Indexer indexer = new Indexer(text);
        printMap(indexer.getIndexMap());
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text for indexer: ");
        return scanner.nextLine();
    }

    private static void printMap(Map<Character, Collection<String>> indexMap) {
        indexMap.keySet().forEach(x -> printLine(x, indexMap.get(x)));
    }

    private static void printLine(Character c, Collection<String> strings) {
        System.out.println(c + ": " + String.join(", ", strings));
    }
}
