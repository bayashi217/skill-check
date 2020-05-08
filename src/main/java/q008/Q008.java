package q008;

import q008.collection.JavaFileList;
import q008.entity.JavaFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Q008 埋め込み文字列の抽出
 *
 * 一般に、定数定義の場合を除いて、プログラム中に埋め込み文字列を記述するのは良くないとされています。
 * そのような埋め込み文字列を見つけるために、埋め込み文字列や埋め込み文字（"test"や'a'など）が
 * 記述された行を出力するプログラムを作成してください。
 *
 * - 実行ディレクトリ配下（再帰的にチェック）に存在するすべてのjavaファイルをチェックする
 * - ファイル名はディレクトリ付きでも無しでも良い
 * - 行の内容を出力する際は、先頭のインデントは削除しても残しても良い

[出力イメージ]
Q001.java(12): return "test";  // テストデータ
Q002.java(10): private static final DATA = "test"
Q002.java(11): + "aaa";
Q002.java(20): if (test == 'x') {
Q004.java(13): Pattern pattern = Pattern.compile("(\".*\")|(\'.*\')");

 */
public class Q008 {
    /**
     * JavaファイルのStreamを作成する
     *
     * @return
     * @throws IOException
     */
    private static Stream<File> listJavaFiles() throws IOException {
        return Files.walk(Paths.get(".")).map(Path::toFile).filter(f -> f.getName().endsWith(".java"));
    }

    public static void main(String[] args) {
        try {
            JavaFileList javaFileList = new JavaFileList(listJavaFiles().map(file -> {
                try {
                    BufferedReader reader =  Files.newBufferedReader(file.toPath());
                    List<String> resources = reader.lines().collect(Collectors.toList());
                    return new JavaFile(
                            file.toPath().toString(),
                            resources
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                    return new JavaFile(
                            file.toPath().toString(),
                            Collections.emptyList()
                    );
                }
            }).collect(Collectors.toList()));
            javaFileList.getHasEmbeddedStringResourceList().print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// 完成までの時間: 00時間39分17秒
