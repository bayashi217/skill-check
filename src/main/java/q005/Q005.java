package q005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Q005 データクラスと様々な集計
 *
 * 以下のファイルを読み込んで、WorkDataクラスのインスタンスを作成してください。
 * resources/q005/data.txt
 * (先頭行はタイトルなので読み取りをスキップする)
 *
 * 読み込んだデータを以下で集計して出力してください。
 * (1) 役職別の合計作業時間
 * (2) Pコード別の合計作業時間
 * (3) 社員番号別の合計作業時間
 * 上記項目内での出力順は問いません。
 *
 * 作業時間は "xx時間xx分" の形式にしてください。
 * また、WorkDataクラスは自由に修正してください。
 *
[出力イメージ]
部長: xx時間xx分
課長: xx時間xx分
一般: xx時間xx分
Z-7-31100: xx時間xx分
I-7-31100: xx時間xx分
T-7-30002: xx時間xx分
（省略）
194033: xx時間xx分
195052: xx時間xx分
195066: xx時間xx分
（省略）
 */
public class Q005 {
    /** データファイル */
    private static InputStream openDataFile() {
        return Q005.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) throws IOException {
        Stream<String> lines = new BufferedReader(new InputStreamReader(openDataFile())).lines();
        WorkDataList workDataList = new WorkDataList(lines.skip(1).map(line -> {
            String[] worker = line.split(",");
            return new WorkData(
                    worker[0],
                    worker[1],
                    worker[2],
                    worker[3],
                    Integer.parseInt(worker[4])
            );
        }).collect(Collectors.toList()));

        // 役職別
        workDataList.getTimeEachPosition().forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String position, Integer workTime) {
                System.out.println(position + ":" + timeFormatted(workTime));
            }
        });

        // Pコード別
        workDataList.getTimeEachPCode().forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String pCode, Integer workTime) {
                System.out.println(pCode + ":" + timeFormatted(workTime));
            }
        });

        // 社員番号別
        workDataList.getTimeEachNumber().forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String number, Integer workTime) {
                System.out.println(number + ":" + timeFormatted(workTime));
            }
        });
    }

    private static String timeFormatted(Integer time) {
        return String.format("%02d時間%02d分", time % 60, (time / 3600) % 60 );
    }
}
// 完成までの時間: 00時間16分41秒