package q003;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {
    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(openDataFile()));
        String del = "[ \\s,.;]";
        HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(del);
            for (String word : words) {
                String lowerWord = word.toLowerCase();
                if (lowerWord.equals("-") || lowerWord.equals("")) {
                    continue;
                }

                if (!dictionary.containsKey(lowerWord)) {
                    dictionary.put(lowerWord, 0);
                }
                dictionary.replace(lowerWord, dictionary.get(lowerWord) + 1);
            }
        }
        Map<String, Integer> tree = new TreeMap<>(dictionary);
        for (String word : tree.keySet()) {
            String viewWord = word;
            if (viewWord.equals("i")) {
                viewWord = word.toUpperCase();
            }
            System.out.println(viewWord + "=" + tree.get(word));
        }
    }
}
// 完成までの時間: xx時間 xx分