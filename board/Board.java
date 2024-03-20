package board;
import coordinates.Coordinates;
import jumper.Jumper;

import java.util.HashMap;

public class Board {
    public int size;
    public String[][] matrix;
    public HashMap<String, Jumper> jumpers;

    public Board(int n) {
        this.size = n;
        this.matrix = new String[n][n];
        int num = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = ++num + "";
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    matrix[i][j] = ++num + "";
                }
            }
        }
        setJumpers();
    }

    public void printBoard() {
        int n = this.size;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void setJumpers() {
        this.jumpers = new HashMap<>();
        // Example jumper initialization, replace with your desired setup
        this.jumpers.put("16", new Jumper(new Coordinates(4, 2), new Coordinates(1, 6)));
        this.jumpers.put("47", new Jumper(new Coordinates(7, 4), new Coordinates(4, 7)));
        this.jumpers.put("62", new Jumper(new Coordinates(7, 8), new Coordinates(2, 4)));
        this.jumpers.put("99", new Jumper(new Coordinates(10, 9), new Coordinates(5, 3)));

        this.jumpers.put("1", new Jumper(new Coordinates(1, 1), new Coordinates(3, 8)));
        this.jumpers.put("4", new Jumper(new Coordinates(1, 4), new Coordinates(3, 2)));
        this.jumpers.put("27", new Jumper(new Coordinates(3, 7), new Coordinates(8, 2)));
        this.jumpers.put("57", new Jumper(new Coordinates(6, 7), new Coordinates(9, 4)));
    }
}
