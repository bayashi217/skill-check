package q007;

import java.util.Objects;

public class Maze {
    private final String[][] maze;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String[] line: maze) {
            for (String cell: line) {
                str.append(cell);
            }
            str.append("\n");
        }
        return str.toString();
    }

    public Maze(String[][] maze) {
        this.maze = maze;
    }

    public int wight() {
        return maze[0].length;
    }

    public int height() {
        return maze.length;
    }

    public int shortestRouteLength() {
        int startY = 0;
        for (String[] line: maze) {
            int startX = 0;
            for (String cell: line) {
                if (Objects.equals("S", cell)) {
                    int shortestRouteLength = calcShortestRouteLength(startX, startY, 0);
                    if (shortestRouteLength == Integer.MAX_VALUE) {
                        return -1;
                    }
                    return shortestRouteLength;
                }
                ++startX;
            }
            ++startY;
        }
        return -1;
    }

    private int calcShortestRouteLength(int startX, int startY, int count) {
        int min = Integer.MAX_VALUE;
        try {
            if (maze[startY][startX].equals("S") && 0 < count) {
                return min;
            }
            switch (maze[startY][startX]) {
                case "X":
                    return min;
                case " ":
                    maze[startY][startX] = String.valueOf(count);
                case "S":
                    break;
                case "E":
                    return count;
                default:
                    int x = Integer.parseInt(maze[startY][startX]);
                    if (count < x) {
                        maze[startY][startX] = "0";
                        return calcShortestRouteLength(startX, startY, count);
                    }
                    return min;
            }
            min = Math.min(min, calcShortestRouteLength(startX + 1, startY, count + 1));
            min = Math.min(min, calcShortestRouteLength(startX - 1, startY, count + 1));
            min = Math.min(min, calcShortestRouteLength(startX, startY + 1, count + 1));
            min = Math.min(min, calcShortestRouteLength(startX, startY - 1, count + 1));
            return min;
        } catch (IndexOutOfBoundsException err) {
            return min;
        }
    }
}
