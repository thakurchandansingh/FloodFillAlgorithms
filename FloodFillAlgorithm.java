package dp;

public class FloodFillAlgorithm {
    static int count = 0;

    public static void printMatrix(int[][] m) {
        int rows = m.length - 1;
        int cols = m[0].length - 1;
        System.out.println();
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++)
                System.out.printf("%4s", m[i][j]);
            System.out.println();
        }
    }

    public static void floodFill(int[][] m, int row, int col) {
        int rows = m.length - 1;
        int cols = m[0].length - 1;
        if (row < 0 || row > rows)
            return;
        if (col < 0 || col > cols)
            return;
        if (m[row][col] != 1)
            return;
        m[row][col] = 2;
        count++;
        printMatrix(m);
        floodFill(m, row - 1, col - 1);
        floodFill(m, row - 1, col);
        floodFill(m, row - 1, col + 1);
        floodFill(m, row, col + 1);
        floodFill(m, row + 1, col + 1);
        floodFill(m, row + 1, col);
        floodFill(m, row + 1, col - 1);
        floodFill(m, row, col - 1);


    }

    public static void main(String[] args) {
        int[][] m = {{0, 0, 1, 0}, {1, 0, 1, 1}, {0, 0, 1, 0}};
    /*
    printMatrix(m);
    floodFill(m,0,2);
    System.out.println(count);*/
        int maxcount = -1;
        int rows = m.length - 1;
        int cols = m[0].length - 1;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++)
                if (m[i][j] == 1) {
                    count = 0;
                    floodFill(m, i, j);
                    if (count > maxcount)
                        maxcount = count;
                }
        }
        System.out.println(maxcount);
    }
}
