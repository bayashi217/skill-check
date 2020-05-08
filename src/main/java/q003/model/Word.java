package q003.model;

import java.util.Objects;

public class Word implements Comparable {
    private final String word;
    private final Integer count;

    public Word(String word) {
        this(word, 0);
    }

    public Word(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Boolean equalWord(String word) {
        return this.word.equals(word);
    }

    @Override
    public String toString() {
        String viewWord = word;
        if (viewWord.equals("i")) {
            viewWord = word.toUpperCase();
        }
        return viewWord + "=" + count;
    }

    @Override
    public int compareTo(Object o) {
        Word word = (Word) o;
        return this.word.compareTo(word.getWord());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
