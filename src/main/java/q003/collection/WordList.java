package q003.collection;

import q003.model.Word;

import java.util.List;
import java.util.stream.Collectors;

public class WordList {
    final private List<String> FILTER_WORD = List.of(
        "–",
        ""
    );
    final private List<Word> list;
    final private List<Word> filter;

    public WordList(List<Word> list) {
        this.list = list;
        this.filter = filter();
    }

    public List<Word> getList() {
        return filter;
    }

    private List<Word> filter() {
        return list.stream().filter(word ->
            !FILTER_WORD.contains(word.getWord())).collect(Collectors.toList());
    }

    public WordList uniqAndCount() {
        return new WordList(filter.stream().map(word ->
            new Word(
                word.getWord(),
                (int) filter.stream().filter(value -> value.equalWord(word.getWord())).count()
            )
        ).distinct().collect(Collectors.toList()));
    }
}
