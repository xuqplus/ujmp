package cn.xuqplus.ujmp.day0;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;

public class CTest {
    /**
     * 余弦相似度/余弦距离计算
     */
    @Test
    public void cos() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(5, 5);
        for (int row = 0; row < dense.getRowCount(); row++) {
            for (int column = 0; column < dense.getColumnCount(); column++) {
                dense.setAsInt(column + 1, row, column);
            }
        }

        Matrix a = dense.plus(dense);
        System.out.println(a);
        // System.out.println(dense.cosineSimilarity(Calculation.Ret.LINK, true));
        System.out.println(dense.cosineSimilarityTo(dense, true));
    }

    @Test
    public void cos1() throws Exception {
        Matrix dense = DenseMatrix.Factory.zeros(5, 5);
        for (int row = 0; row < dense.getRowCount(); row++) {
            for (int column = 0; column < dense.getColumnCount(); column++) {
                dense.setAsInt(column + 1, row, column);
            }
        }
        Matrix a = dense.plus(dense);
        System.out.println(dense.cosineSimilarityTo(a, true));//0.9999999999999998
        a.setAsInt(1000, 1, 1);
        System.out.println(dense.cosineSimilarityTo(a, true));//0.1532053527730522
        /**
         * 计算前做二值化
         */
        dense.and(Calculation.Ret.ORIG, true);
        a.and(Calculation.Ret.ORIG, true);
        System.out.println(dense.cosineSimilarityTo(a, true));//1.0
    }
}
