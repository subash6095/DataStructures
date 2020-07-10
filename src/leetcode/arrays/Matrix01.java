package leetcode.arrays;

import java.util.*;

public class Matrix01 {
    public static void main(String[] args) {
        //int[][] input = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] input = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        Matrix01 matrix01 = new Matrix01();
        matrix01.updateMatrix(input);
        System.out.println("Updated Matrix :: ");
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }

    class Point {
        int x;
        int y;
        int number;

        Point(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", number=" + number +
                    '}';
        }
    }

    public int[][] updateMatrix(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) return matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    bfs(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    public void bfs(int[][] matrix, int i, int j) {
        Point first = new Point(i, j, matrix[i][j]);
        System.out.println("Point : " + first.toString());
        Queue<Point> queue = new LinkedList();
        queue.add(first);
        while (true) {
            Point p = queue.remove();
            if (p.number == 0) {
                matrix[first.x][first.y]
                        = Math.abs(first.x - p.x) + Math.abs(first.y - p.y);
                //System.out.println(("matrix[" + first.x + "][" + first.y + "] = " + matrix[first.x][first.y]));
                break;
            }

            if (p.y + 1 < matrix[0].length)
                queue.add(new Point(p.x, p.y + 1, matrix[p.x][p.y + 1]));
            if (p.y - 1 >= 0)
                queue.add(new Point(p.x, p.y - 1, matrix[p.x][p.y - 1]));
            if (p.x + 1 < matrix.length)
                queue.add(new Point(p.x + 1, p.y, matrix[p.x + 1][p.y]));
            if (p.x - 1 >= 0)
                queue.add(new Point(p.x - 1, p.y, matrix[p.x - 1][p.y]));
            System.out.println("Queue Size : " + queue.size());
        }
    }
}
