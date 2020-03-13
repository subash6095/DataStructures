package misc;

public class SpiralMatrix {

    private static int[][] buildMatrix(int row, int col){
        int[][] matrix = new int[row][col];
        int maxCenter = (row%2==0) ? 2 : 1;
        int i=row/2, j=col/2;
        if (maxCenter == 2) {
            j = col/2 - 1;
        }

        int direction=0, steps=1, currentStep=0, change=0;

        for (int a = 1; a <= row*col; a++){
            matrix[i][j] = a;
            if (currentStep < steps)
                currentStep++;
            else {
                currentStep = 1;
                if (change == 1) {
                    steps++;
                }
                change = (change+1) % 2;
                direction = (direction+1) % 4;
            }

            System.out.println("a = " + a + ", steps = " + steps + ", currentStep = "
                    + currentStep + ", change = " + change + ", direction = " + direction);

            switch (direction){
                case 0: i--; break;
                case 1: j++; break;
                case 2: i++; break;
                case 3: j--; break;
            }
        }
        return matrix;
    }

    private static int getElement(int n, int[][] matrix, String path) {

        int maxCenter = n % 2 == 0 ? 2 : 1;
        int i=n/2, j=n/2;
        if (maxCenter == 2) {
            j = n / 2 - 1;
        }

        if (path == null || path.isEmpty()) {
            return -1;
        }

        String[] paths = path.split("");

        int current = 0;

        while ((i >= 0 && i <=n) && (j >=0 && j <=n)) {

            String nextPath = paths[current];

            if (nextPath.equals("L")) {
                j--;
            } else if (nextPath.equals("R")) {
                j++;
            } else if (nextPath.equals("U")) {
                i--;
            } else if (nextPath.equals("D")) {
                i++;
            }

            if (current == paths.length - 1 && (i>=0 && j >=0)) {
                return matrix[i][j];
            } else {
                current = current + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int row = 5;
        int col = 5;
        int[][] matrix = buildMatrix(row, col);

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }

        int element = getElement(5, matrix, "LURD");

        System.out.println("element = " + element);
    }
}
