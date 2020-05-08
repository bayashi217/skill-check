package q003.model;

import q003.collection.WordList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class File {
    final String DELIMITER = "[ \\s,.;]";

    private final List<String> lines;

    public File(List<String> lines) {
        this.lines = lines;
    }

    public WordList getWordList() {
        return new WordList(lines.stream().flatMap(line ->
                Arrays.stream(line.split(DELIMITER)).map(word -> new Word(word.toLowerCase()))
        ).collect(Collectors.toList()));
    }
}
