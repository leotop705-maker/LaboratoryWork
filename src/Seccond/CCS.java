package Seccond;

public class CCS {
    private int n;
    private int[] values;
    private int[] rowIndex;
    private int[] colPtr;

    public CCS(int n, int[] values, int[] rowIndex, int[] colPtr) {
        this.n = n;
        this.values = values;
        this.rowIndex = rowIndex;
        this.colPtr = colPtr;
    }

    public CCS mirror (){
        int nnz = values.length;
        int[] newValues = new int[nnz];
        int[] newRows = new int[nnz];
        int[] newCols = new int[n + 1];

        return new CCS(n, newValues, newRows, newCols);
    }

    public int getN() {
        return n;
    }

    public int[] getValues() {
        return values;
    }

    public int[] getRowIndex() {
        return rowIndex;
    }

    public int[] getColPtr() {return colPtr;}


    public static int[][] revers(int[][] matrix){
        //n - 1 - j, n - 1 - i
        int n = matrix.length;
        int[][] reversedMatrix = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                reversedMatrix[n - 1 - j][n - 1 - i] = matrix[i][j];
            }
        }
        return reversedMatrix;
    }



//    1 2 3 4 5 val
//    0 2 1 0 2 row
//    1 4 3 2 5
//    0 1 2 3 4 5
//    0 2 3 5 colptr
}
