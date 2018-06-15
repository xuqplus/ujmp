package cn.xuqplus.ujmp.day0;

import cn.xuqplus.ujmp.IMGUtil;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class BTest {
    @Test
    public void aa() throws Exception {
        String filename = "src/aaa.bmp";
        File file = new File(filename);
        BufferedImage bi = ImageIO.read(file);
        //获取当前图片的高,宽,ARGB
        int h = bi.getHeight();
        int w = bi.getWidth();
        int arr[][] = new int[w][h];
        for (int h0 = 0; h0 < h; h0++) {
            for (int w0 = 0; w0 < w; w0++) {
                arr[w0][h0] = IMGUtil.getImageRgb(bi.getRGB(w0, h0));//该点的灰度值
            }
        }
        for (int h0 = 0; h0 < h; h0++) {
            for (int w0 = 0; w0 < w; w0++) {
                if (arr[w0][h0] > 130) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
