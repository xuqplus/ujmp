package cn.xuqplus.ujmp.day0;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.SparseMatrix;

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
    public void inverse() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(10, 10);

        for (int row = 0; row < dense.getRowCount(); row++) {
            dense.setAsObject(1, row, row);
            dense.setAsObject(1, row, row);
        }

        System.out.println(dense);
        System.out.println(dense.inv());//逆矩阵
        System.out.println(dense.pinv());
        System.out.println(dense.det());
    }
}
