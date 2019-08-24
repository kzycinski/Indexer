package index;

import java.util.*;

public class Indexer {

    private Map<Character, Collection<String>> indexMap;

    public Indexer(String text) {
        indexMap = new TreeMap<>();
        index(text);
    }

    private void index(String text) {
        String parsedText = parseText(text);
        indexParsedText(parsedText);
    }

    private String parseText(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : text.toCharArray()) {
            addCharacterIfValid(character, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void addCharacterIfValid(Character character, StringBuilder stringBuilder) {
        if (isValid(character)) {
            stringBuilder.append(character);
        }
    }

    private boolean isValid(Character character) {
        return Character.isLetter(character) || character.equals(' ');
    }

    private void indexParsedText(String text) {
        String[] words = text.split(" ");
        Arrays.stream(words).forEach(s -> indexWord(s.toLowerCase()));
    }

    private void indexWord(String word) {
        word.chars().forEach(c -> addWordToMap(word, (char) c));
    }

    private void addWordToMap(String word, Character character) {
        if (indexMap.containsKey(character)) {
            addWordToExistingCharacter(word, character);
        } else {
            addWordToNewCharacter(word, character);
        }
    }

    private void addWordToExistingCharacter(String word, Character character) {
        Collection<String> wordList = indexMap.get(character);
        wordList.add(word);
        indexMap.put(character, wordList);
    }

    private void addWordToNewCharacter(String word, Character character) {
        indexMap.put(character, new TreeSet<>(Collections.singletonList(word)));
    }

    public Map<Character, Collection<String>> getIndexMap() {
        return indexMap;
    }
}
