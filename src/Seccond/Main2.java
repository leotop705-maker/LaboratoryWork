package Seccond;
//Дана разреженная матрицa(CCS).
//Зеркальное отображение относительно диагонали, проходящей с левого нижнего угла к правому верхнему углу.

public class Main2 {

    public static CCS loseWeight(int[][] matrix){
        int n = matrix.length;
        int nnz = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value != 0) {
                    nnz++;
                }
            }
        }
        int[] values = new int[nnz];
        int[] rows = new int[nnz];
        int[] cols = new int[n + 1];
        int p = 0;

        for (int j = 0; j < n; j++){
            cols[j] = p;
            for (int i = 0; i < n; i++){
                if (matrix[i][j] != 0){
                    values[p] = matrix[i][j];
                    rows[p] = i;
                    p++;
                }
            }
        }
        cols[n] = p;
        return new CCS(n, values, rows, cols);
    }

    public static int[][] gainWeight(CCS matrix){

        int n = matrix.getN();
        int[] values = matrix.getValues();
        int[] rows = matrix.getRowIndex();
        int[] cols = matrix.getColPtr();

        int[][] weightMatrix = new int[n][n];

        for (int j = 0; j < n; j++){
            for (int p = cols[j]; p < cols[j + 1]; p++){
                weightMatrix[rows[p]][j] = values[p];
            }
        }
        return weightMatrix;
    }

    public static void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 3;
        int[] values = new int[] {1, 4, 3, 2, 5};
        int[] rows = new int[] {0, 2, 1, 0, 2};
        int[] cols = new int[] {0, 2, 3, 5};

        CCS matrix = new CCS(n, values, rows, cols);

        int[][] heavyMatrix = gainWeight(matrix);
        int[][] reversedHeavyMatrix = CCS.revers(heavyMatrix);

        CCS finalMatrix = loseWeight(reversedHeavyMatrix);

        printMatrix(reversedHeavyMatrix);
    }

}

