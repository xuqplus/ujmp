package cn.xuqplus.ujmp.day0;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.SparseMatrix;
import org.ujmp.core.calculation.Calculation;

public class Matrix0Test {
    @Test
    public void empty() throws Exception {
        Matrix matrix = DenseMatrix.Factory.emptyMatrix();
        System.out.println(matrix);
    }

    @Test
    public void row1column1() throws Exception {
        Matrix matrix = DenseMatrix.Factory.zeros(1, 1);
        System.out.println(matrix);

        matrix.setAsObject(123D, 0, 0);
        System.out.println(matrix);
    }

    @Test
    public void row100column100() throws Exception {
        Matrix matrix = DenseMatrix.Factory.zeros(100, 100);
        System.out.println(matrix);

        matrix.setAsObject(123D, 0, 0);
        System.out.println(matrix);
    }

    @Test
    public void row10column100() throws Exception {
        Matrix matrix = DenseMatrix.Factory.zeros(10, 100);
        matrix.setAsObject(123D, 0, 0);
        System.out.println(matrix);
    }

    @Test
    public void row10column10() throws Exception {
        Matrix matrix = SparseMatrix.Factory.zeros(10, 10);
        matrix.setAsObject(123D, 0, 0);
        System.out.println(matrix);
    }

    @Test
    public void plus() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(10, 10);
        Matrix sparse = SparseMatrix.Factory.zeros(10, 10);

        dense.setAsObject(10, 9, 9);
        dense.setAsObject(1, 0, 0);
        sparse.setAsObject(10, 9, 9);
        sparse.setAsObject(1, 0, 0);

        System.out.println(dense.plus(sparse));
    }

    @Test
    public void minus() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(10, 10);
        Matrix sparse = SparseMatrix.Factory.zeros(10, 10);

        dense.setAsObject(10, 9, 9);
        dense.setAsObject(1, 0, 0);
        sparse.setAsObject(10, 9, 9);
        sparse.setAsObject(1, 0, 0);

        System.out.println(dense.minus(sparse));
    }

    @Test
    public void times() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(10, 10);
        Matrix sparse = SparseMatrix.Factory.zeros(10, 10);

        for (int row = 0; row < dense.getRowCount(); row++) {
            dense.setAsObject(row, row, 2);
            dense.setAsObject(row, row, 2);
            sparse.setAsObject(row, row, 2);
            sparse.setAsObject(row, row, 2);
        }

        System.out.println(dense);
        System.out.println(dense.times(2));
        System.out.println(sparse);
        System.out.println(sparse.times(2));
    }

    /**
     * 矩阵变换/转置
     */
    @Test
    public void transpose() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(10, 10);
        Matrix sparse = SparseMatrix.Factory.zeros(10, 10);

        for (int row = 0; row < dense.getRowCount(); row++) {
            dense.setAsObject(row, row, 0);
            dense.setAsObject(row, row, 0);
            sparse.setAsObject(row, row, 0);
            sparse.setAsObject(row, row, 0);
        }

        System.out.println(dense);
        System.out.println(dense.transpose());
        System.out.println(sparse);
        System.out.println(sparse.transpose());
    }

    @Test
    public void rowSum() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(5, 5);
        for (int row = 0; row < dense.getRowCount(); row++) {
            for (int column = 0; column < dense.getColumnCount(); column++) {
                dense.setAsInt(column + 1, row, column);
            }
        }
        System.out.println(dense);
        System.out.println(dense.getRowList().get(0));
        System.out.println(dense.getRowList().get(0).getValueSum());
    }

    @Test
    public void and() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(5, 5);
        for (int row = 0; row < dense.getRowCount(); row++) {
            for (int column = 0; column < dense.getColumnCount(); column++) {
                dense.setAsInt(column, row, column);
            }
        }
        System.out.println(dense);
        System.out.println(dense.and(Calculation.Ret.LINK, dense));
        System.out.println(dense.and(Calculation.Ret.LINK, dense).getRowList());
        System.out.println(dense.and(Calculation.Ret.LINK, dense).getRowList().get(0).getValueSum());//true=1, false=0

        /**
         * 内部二值化
         */
        dense.and(Calculation.Ret.ORIG, true);
    }

    @Test
    public void timesMatrix() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(5, 5);
        for (int row = 0; row < dense.getRowCount(); row++) {
            for (int column = 0; column < dense.getColumnCount(); column++) {
                dense.setAsInt(column, row, column);
            }
        }
        System.out.println(dense);
        System.out.println(dense.times(dense));
        System.out.println(dense.times(dense).times(dense));
    }
}
