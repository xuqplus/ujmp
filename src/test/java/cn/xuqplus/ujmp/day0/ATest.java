package cn.xuqplus.ujmp.day0;

import org.junit.After;
import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.SparseMatrix;
import org.ujmp.core.treematrix.DefaultTreeMatrix;
import org.ujmp.core.treematrix.TreeMatrix;
import org.ujmp.core.util.matrices.MandelbrotMatrix;

public class ATest {
    @Test
    public void aa() throws Exception {
        // create a TreeMatrix with Strings as elements
        TreeMatrix<String> treeMatrix = new DefaultTreeMatrix<String>();

        // create data
        treeMatrix.setRoot("root");
        treeMatrix.addChild("root", "child1");
        treeMatrix.addChild("root", "child2");
        treeMatrix.addChild("root", "child3");
        treeMatrix.addChild("child1", "subChild11");
        treeMatrix.addChild("child1", "subChild12");
        treeMatrix.addChild("child1", "subChild13");
        treeMatrix.addChild("child2", "subChild21");
        treeMatrix.addChild("child3", "subChild31");
        treeMatrix.addChild("child3", "subChild32");
        treeMatrix.addChild("subChild12", "subSubChild121");
        treeMatrix.addChild("subChild12", "subSubChild122");
        treeMatrix.addChild("subSubChild122", "subSubSubChild1221");

        // show on screen
        treeMatrix.showGUI();
    }

    @Test
    public void quickStart() {
        // create a dense empty matrix with 4 rows and 4 columns
        Matrix dense = DenseMatrix.Factory.zeros(4, 4);

        // set entry at row 2 and column 3 to the value 5.0
        dense.setAsDouble(5.0, 2, 3);

        // set some other values
        dense.setAsDouble(1.0, 0, 0);
        dense.setAsDouble(3.0, 1, 1);
        dense.setAsDouble(4.0, 2, 2);
        dense.setAsDouble(-2.0, 3, 3);
        dense.setAsDouble(-2.0, 1, 3);

        // print the final matrix on the console
        System.out.println(dense);

        // create a sparse empty matrix with 4 rows and 4 columns
        Matrix sparse = SparseMatrix.Factory.zeros(4, 4);
        sparse.setAsDouble(2.0, 0, 0);

        // basic calculations
        Matrix transpose = dense.transpose();
        Matrix sum = dense.plus(sparse);
        Matrix difference = dense.minus(sparse);
        Matrix matrixProduct = dense.mtimes(sparse);
        Matrix scaled = dense.times(2.0);

        Matrix inverse = dense.inv();
        Matrix pseudoInverse = dense.pinv();
        double determinant = dense.det();

        Matrix[] singularValueDecomposition = dense.svd();
        Matrix[] eigenValueDecomposition = dense.eig();
        Matrix[] luDecomposition = dense.lu();
        Matrix[] qrDecomposition = dense.qr();
        Matrix choleskyDecomposition = dense.chol();
    }

    @Test
    public void mandelbrotMatrix() {
        // create a matrix from the Mandelbrot set
        Matrix m = new MandelbrotMatrix();

        // show on screen
        m.showGUI();
    }

    @After
    public void after() throws InterruptedException {
        //wait
        while (true) {
            Thread.sleep(10000);
        }
    }
}
