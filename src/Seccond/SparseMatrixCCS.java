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

    public static SparseMatrixCCS fromDense(double[][] a) {
        int rows = a.length;
        int cols = a[0].length;

        int[] colPtr = new int[cols + 1];

        // 1. Считаем количество ненулевых в каждом столбце
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] != 0.0) {
                    colPtr[j + 1]++;
                }
            }
        }

        // 2. Префиксная сумма — получаем начало каждого столбца
        for (int j = 0; j < cols; j++) {
            colPtr[j + 1] += colPtr[j];
        }

        int nnz = colPtr[cols];

        double[] values = new double[nnz];
        int[] rowIndices = new int[nnz];

        // next[j] — текущая позиция для записи в столбец j
        int[] next = new int[cols];

        // 3. Заполняем values и rowIndices по столбцам
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double v = a[i][j];
                if (v != 0.0) {
                    int pos = colPtr[j] + next[j];
                    values[pos] = v;
                    rowIndices[pos] = i;
                    next[j]++;
                }
            }
        }

        return new SparseMatrixCCS(rows, cols, values, rowIndices, colPtr);
    }
    // Получить элемент A[row][col]
    public double get(int row, int col) {
        checkIndices(row, col);

        int start = colPtr[col];
        int end = colPtr[col + 1];

        // Бинарный поиск по rowIndices внутри столбца
        int lo = start;
        int hi = end - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int r = rowIndices[mid];

            if (r == row) {
                return values[mid];
            } else if (r < row) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return 0.0; // элемент отсутствует — значит ноль
    }
}
