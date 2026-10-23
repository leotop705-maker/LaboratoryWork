//package Seccond;
//
//public class SparseMatrixCCS {
//
//    private final int rows;
//    private final int cols;
//    private final int nnz;
//
//    private final int[] values;     // ненулевые значения
//    private final int[] rowIndices;    // строки для values
//    private final int[] colPtr;        // начало столбцов
//
//    public SparseMatrixCCS(int rows, int cols, int[] values, int[] rowIndices, int[] colPtr) {
//        this.rows = rows;
//        this.cols = cols;
//        this.values = values;
//        this.rowIndices = rowIndices;
//        this.colPtr = colPtr;
//        this.nnz = values.length;
//    }
//
//    //худеем
//    public static SparseMatrixCCS createCCSMatrix(int[][] matrix){
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        int[] colPtr = new int[cols + 1];
//
//        int nnz = colPtr[cols];
//        int[] values = new int[nnz];
//        int[] rowIndices = new int[nnz];
//        int[] next = new int[cols];
//
//        //чекать нули
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] != 0) {
//                    colPtr[j + 1]++;
//                }
//            }
//        }
//
//        //индекс (указатели на начало) столбов
//        for (int j = 0; j < cols; j++) {
//            colPtr[j + 1] += colPtr[j];
//        }
//
//        //Запихиваем значения и индексы строк
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                int v = matrix[i][j];
//                if (v != 0) {
//                    int pos = colPtr[j] + next[j];
//                    values[pos] = v;
//                    rowIndices[pos] = i;
//                    next[j]++;
//                }
//            }
//        }
//
//        return new SparseMatrixCCS(rows, cols, values, rowIndices, colPtr);
//    }
//
//    //ну взять элемент
//    public int getElement(int row, int col){
//
//        int begin = colPtr[col];
//        int end = colPtr[col + 1];
//
//        //бинарный поиск по rowIndices внутри столбца? чё?
//
//        int lo = begin;
//        int hi = end - 1;
//
//        while (lo <= hi){
//            int mid = (lo + hi) >>> 1;
//            int r = rowIndices[mid];
//
//            if (r == row) {
//                return values[mid];
//            } else if (r < row) {
//                lo = mid + 1;
//            } else {
//                hi = mid - 1;
//            }
//        }
//        return 0;
//    }
//
//    //обратно набираем массу
//    public int[][] returnNormalMatrix(){
//        int[][] matrix = new int[rows][cols];
//
//        for (int i = 0; i < cols; i++){
//            for (int j = colPtr[i]; j < colPtr[j + 1]; j++){
//                matrix[rowIndices[j]][i] = values[j];
//            }
//        }
//        return matrix;
//    }
//}
