package q007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MazeFactory {
    public static Maze create(MazeInputStream is) {
        InputStreamReader ir = new InputStreamReader(is);
        BufferedReader in = new BufferedReader(ir);
        List<String[]> allLine = in.lines().map(line -> line.split("")).collect(Collectors.toList());
        String[][] maze = new String[allLine.size()][allLine.get(0).length];
        AtomicInteger lineCounter = new AtomicInteger();
        allLine.stream().forEach(line -> {
            maze[lineCounter.getAndIncrement()] = line;
        });

        return new Maze(maze);
    }
}
