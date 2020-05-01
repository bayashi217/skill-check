package q005;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作業時間管理クラス
 * 自由に修正してかまいません
 */
public class WorkDataList {
    private List<WorkData> list;

    public WorkDataList(List<WorkData> list) {
        this.list = list;
    }

    /**
     * 役職別の合計作業時間
     *
     * @return
     */
    public Map<String, Integer> getTimeEachPosition() {
        Map<String, Integer> timeList = new HashMap<>();
        list.forEach(data -> {
            if (!timeList.containsKey(data.getPosition())) {
                timeList.put(data.getPosition(), 0);
            }
            timeList.put(data.getPosition(), timeList.get(data.getPosition()) + data.getWorkTime());
        });
        return timeList;
    }

    /**
     * Pコード別の合計作業時間
     *
     * @return
     */
    public Map<String, Integer> getTimeEachPCode() {
        Map<String, Integer> timeList = new HashMap<>();
        list.forEach(data -> {
            if (!timeList.containsKey(data.getPCode())) {
                timeList.put(data.getPCode(), 0);
            }
            timeList.put(data.getPCode(), timeList.get(data.getPCode()) + data.getWorkTime());
        });
        return timeList;
    }

    /**
     * 社員番号別の合計作業時間
     *
     * @return
     */
    public Map<String, Integer> getTimeEachNumber() {
        Map<String, Integer> timeList = new HashMap<>();
        list.forEach(data -> {
            if (!timeList.containsKey(data.getNumber())) {
                timeList.put(data.getNumber(), 0);
            }
            timeList.put(data.getNumber(), timeList.get(data.getNumber()) + data.getWorkTime());
        });
        return timeList;
    }
}
