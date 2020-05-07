package q007;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest {

    @Test
    public void returnMinus1IfCanNotGoal() {
        String[][] mazeString = {
                {"X","X","X","X","X","X","X"},
                {"X","S"," "," "," ","X","X"},
                {"X"," ","X","X","X","X","X"},
                {"X","X"," ","X"," ","X","X"},
                {"X","X"," ","X"," ","X","X"},
                {"X","X"," "," "," ","E","X"},
                {"X","X","X","X","X","X","X"}
        };
        Maze maze = new Maze(mazeString);
        assertEquals(-1, maze.shortestRouteLength());
    }

    @Test
    public void returnShortestRouteLengthIfCanGoal() {
        String[][] mazeString = {
                {"X","X","X","X","X","X","X"},
                {"X","S"," "," "," ","X","X"},
                {"X"," ","X","X","X","X","X"},
                {"X"," "," ","X"," ","X","X"},
                {"X","X"," ","X"," ","X","X"},
                {"X","X"," "," "," ","E","X"},
                {"X","X","X","X","X","X","X"}
        };
        Maze maze = new Maze(mazeString);
        assertEquals(8, maze.shortestRouteLength());
    }
}