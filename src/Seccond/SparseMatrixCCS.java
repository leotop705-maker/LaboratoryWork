package Seccond;

public class SparseMatrixCCS {

    private final int rows;
    private final int cols;
    private final int nnz;

    private final double[] values;     // ненулевые значения
    private final int[] rowIndices;    // строки для values
    private final int[] colPtr;        // начало столбцов

    public SparseMatrixCCS(int rows, int cols,
                           double[] values,
                           int[] rowIndices,
                           int[] colPtr) {
        this.rows = rows;
        this.cols = cols;
        this.values = values;
        this.rowIndices = rowIndices;
        this.colPtr = colPtr;
        this.nnz = values.length;
    }


}
