package test;

public class SpiralOrderMatrix {
    /*
      Input :
      1 2 3
      4 5 6
      7 8 9

      OutPut:
      1 2 3 6 9 8 7 4 5
     */
    public static void main(String[] args) {
        //int[][] input = { {1,2,3}, {4,5,6}, { 7,8,9}};
        int[][] input = { {1,2,3,4}, {5,6,7,8}, {9, 10, 11,12}, {13,14,15,16}};
        printSpiralMatrix(input);
    }

    public static void printSpiralMatrix(int[][] input){
        int row = input.length;
        int col = input[0].length;

        int rowStart = 0;
        int rowEnd = row-1;
        int colStart = 0;
        int colEnd = col-1;

        while(rowStart <= rowEnd && colStart <= colEnd) {

            for(int j = colStart; j <= colEnd; j++)
                System.out.print(input[rowStart][j] + " ");
            rowStart++;

            for(int i = rowStart; i <= rowEnd; i++) {
                System.out.print(input[i][colEnd] + " ");
            }
            colEnd--;

            for(int k = colEnd; k >= colStart; k--){
                System.out.print(input[rowEnd][k] + " ");
            }
            rowEnd--;

            for(int l = rowEnd; l >= rowStart; l--){
                System.out.print(input[l][colStart] + " ");
            }
            colStart++;
        }
    }

}
